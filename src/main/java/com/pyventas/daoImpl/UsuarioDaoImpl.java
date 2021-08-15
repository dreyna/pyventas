/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyventas.daoImpl;

import com.pyventas.config.Conexion;
import com.pyventas.dao.Metodos;
import com.pyventas.entity.Usuario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author dreyna
 */
public class UsuarioDaoImpl implements Metodos<Usuario> {

    private CallableStatement cstmt;
    private ResultSet rs;
    private Connection cx = null;

    @Override
    public int create(Usuario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Usuario t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario read(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> readAll1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Map<String, Object>> readAll2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Map<String, Object> validar(String user, String pass) {
        String SQL = "{call PKG_CRUD_USUARIO.SP_VALIDAR_USUARIO(?,?,?)}";
        //EXECUTE PKG_CRUD_USUARIO.SP_VALIDAR_USUARIO('dreyna','123',:P_DATOSUSER)
        Map<String, Object> datosuser = new HashMap<>();
        try {
            cx = Conexion.getConexion();
            cstmt = cx.prepareCall(SQL);
            cstmt.setString(1,user);
            cstmt.setString(2, pass);
            cstmt.registerOutParameter(3, OracleTypes.REF_CURSOR);
            cstmt.execute();
            rs = ((OracleCallableStatement) cstmt).getCursor(3);
            while (rs.next()) {
                datosuser.put("idusuario", rs.getInt("IDUSUARIO"));
                datosuser.put("nombres", rs.getString("NOMBRES"));
                datosuser.put("usuario", rs.getString("USERNAME"));
                datosuser.put("idrol", rs.getInt("IDROL"));
                datosuser.put("rol", rs.getString("NOMROL"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return datosuser;
    }
}
