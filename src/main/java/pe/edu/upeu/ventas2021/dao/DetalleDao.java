/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.ventas2021.dao;

import java.util.List;
import java.util.Map;
import pe.edu.upeu.ventas2021.model.Detalle;


/**
 *
 * @author alum.fial1
 */
public interface DetalleDao {
    int create(Detalle d);
    Detalle read(int key);
    int update(Detalle d);
    int delete(int key);
    List<Detalle> readAll();
    List<Map<String,Object>> readAll2();
}
