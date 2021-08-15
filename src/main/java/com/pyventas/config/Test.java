/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyventas.config;

import com.google.gson.Gson;
import com.pyventas.daoImpl.RolDaoImpl;
import com.pyventas.daoImpl.UsuarioDaoImpl;
import com.pyventas.entity.Rol;
import java.util.List;

/**
 *
 * @author dreyna
 */
public class Test {
static RolDaoImpl rdao = new RolDaoImpl();
static UsuarioDaoImpl udao = new UsuarioDaoImpl();
static Gson gson = new Gson();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //conexion();
        //listar();
        validar();
       // create();
        //update();
       //delete();
       // buscar();
    }

    static void conexion() {
        if (Conexion.getConexion() != null) {
            System.out.println("conectado");
        } else {
            System.out.println("No conectado");
        }
    }

    static void listar() {
        List<Rol> lista;
        lista = rdao.readAll1();
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).getNomrol());
        }
    }
    static void validar() {
        System.out.println(gson.toJson(udao.validar("dreyna", "123")));
    }
/*
    static void create() {
        int x = vdao.create(new Venta("22/06/2021", 2340, 10, 5, 1));//
        System.out.println(x);
    }

    static void update() {
        Venta venta = new Venta("10/07/2021", 3000, 0, 10, 2);
        venta.setVenta_id(4);
        int x = vdao.update(venta);
        System.out.println(x);
    }
    static void delete() {
        int x = vdao.delete(4);
        System.out.println(x);
    }
    static void buscar(){
    Venta venta = vdao.read(2);
        System.out.println(venta.getTotal());
    }
*/
}
