/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyventas.daoImpl;

import com.pyventas.config.Conexion;
import com.pyventas.dao.Metodos;
import com.pyventas.entity.Rol;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author dreyna
 */
public class RolDaoImpl implements Metodos<Rol> {

    private CallableStatement cstmt;
    private ResultSet rs;
    private Connection cx = null;

    @Override
    public int create(Rol t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Rol t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rol read(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Rol> readAll1() {
        String SQL = "{call PKG_CRUD_ROL.SP_LISTAR_ROLES(?)}";
        List<Rol> roles = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            cstmt = cx.prepareCall(SQL);
            cstmt.registerOutParameter(1, OracleTypes.REF_CURSOR);
            cstmt.execute();
            rs = ((OracleCallableStatement)cstmt).getCursor(1);
            while(rs.next()){
                Rol rol = new Rol();
                rol.setIdrol(rs.getInt("idrol"));
                rol.setNomrol(rs.getString("nomrol"));
                rol.setEstado(rs.getInt("estado"));
                rol.setFecha(rs.getString("fecha"));
                roles.add(rol);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return roles;
    }

    @Override
    public List<Map<String, Object>> readAll2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
