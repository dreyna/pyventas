/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upeu.ventas2021.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.upeu.ventas2021.dao.RolDao;
import pe.edu.upeu.ventas2021.daoImpl.RolDaoImp;
import pe.edu.upeu.ventas2021.model.Rol;



/**
 *
 * @author dreyna
 */
public class RolController extends HttpServlet {
    private final RolDao rd = new RolDaoImp();
    private final Gson g = new Gson();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
        int op = Integer.parseInt(request.getParameter("opc"));
        switch(op){
            case 1: out.println(g.toJson(rd.readAll()));//lista de todos los roles
                    break;
            case 2: out.println(g.toJson(rd.read(Integer.parseInt(request.getParameter("id"))))); //Lista un rol en base del ID
                    break;
           case 3:                       

                    rd.create(new Rol(request.getParameter("nombrerol")));// Registra un nuevo rol
                    break;
            case 4: Rol ro = new Rol(Integer.parseInt(request.getParameter("id")), request.getParameter("nomrol")); //modificar un rol
                    rd.update(ro);
                    break;
            case 5: rd.delete(Integer.parseInt(request.getParameter("id")));//eliminar Rol
                    break;
 
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
