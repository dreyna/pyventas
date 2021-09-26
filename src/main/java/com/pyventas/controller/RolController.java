/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pyventas.controller;

import com.google.gson.Gson;
import com.pyventas.daoImpl.RolDaoImpl;
import com.pyventas.entity.Rol;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dreyna
 */
public class RolController extends HttpServlet {
RolDaoImpl rdao = new RolDaoImpl(); 
Gson gson = new Gson();

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
    // out.println(gson.toJson(rdao.readAll1()));
     int op = Integer.parseInt(request.getParameter("opc"));
     switch(op){
         case 1:out.println(gson.toJson(rdao.readAll1()));
             break;
         case 2:out.println(gson.toJson(rdao.create(new Rol(request.getParameter("rol")))));
            break;
         case 3:Rol r = new Rol();
                r.setIdrol(Integer.parseInt(request.getParameter("idrol")));
                r.setNomrol(request.getParameter("rol"));
                r.setEstado(Integer.parseInt(request.getParameter("estado")));                    
                out.println(gson.toJson(rdao.update(r))); break;
         case 4:out.println(gson.toJson(rdao.delete(Integer.parseInt(request.getParameter("idr")))));break;
         case 5:out.println(gson.toJson(rdao.read(Integer.parseInt(request.getParameter("idr")))));break;
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
