/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.ventas2021.dao;

import pe.edu.upeu.ventas2021.model.Producto;



/**
 *
 * @author alum.fial1
 */
public interface ProductoDao {
    Producto buscarProductoCodigo(int cod);
}
