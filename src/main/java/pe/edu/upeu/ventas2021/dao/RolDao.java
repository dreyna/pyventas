/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.ventas2021.dao;

import java.util.List;
import pe.edu.upeu.ventas2021.model.Rol;


/**
 *
 * @author alum.fial1
 */
public interface RolDao {
    int create(Rol r);
    int update(Rol r);
    int delete(int key);
    Rol read(int key);
    List<Rol> readAll();
    boolean search(String rol);
}
