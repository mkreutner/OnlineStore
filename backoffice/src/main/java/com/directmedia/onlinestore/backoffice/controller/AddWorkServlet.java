/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.directmedia.onlinestore.backoffice.controller;

import com.directmedia.onlinestore.core.entity.Artist;
import com.directmedia.onlinestore.core.entity.Catalog;
import com.directmedia.onlinestore.core.entity.Work;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mkreutner
 */
@WebServlet(name = "AddWorkServlet", urlPatterns = {"/add-work"})
public class AddWorkServlet extends HttpServlet {

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
        
        String title;
        int release;
        String genre;
        String summary;
        String mainArtist;
        
        String method = request.getMethod().toUpperCase();
        
        if (method.compareTo("GET") == 0) {
            title = request.getParameter("title");
            release = Integer.parseInt(request.getParameter("release"));
            genre = request.getParameter("genre");
            summary = request.getParameter("summary");
            mainArtist = request.getParameter("main_artist");
        } else {
            // todo: implement POST treatment
            title = "";
            release = 0;
            genre = "";
            summary = "";
            mainArtist = "";
        }
        
        Artist newArtist = new Artist(mainArtist);
        Work newWork = new Work(title);
        newWork.setGenre(genre);
        newWork.setRelease(release);
        newWork.setSummary(summary);
        newWork.setMainArtist(newArtist);
        Catalog.listOfWorks.add(newWork);
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>"
                    + "<html>"
                    + "<head>"
                    + "<title>Back Office - Ajout Oeuvre</title>"
                    + "</head>"
                    + "<body>"
                    + "  <div>" 
                    + "    <p>Le film a été ajouté.</p>"
                    + "    <p>[" + newWork.getId() + "] - " + newWork.getTitle() + "(" + Integer.toString(newWork.getRelease()) + ")</p>"
                    + "  </div>"
                    + "  <div>" 
                    + "    <a href=\"/backoffice/home\">Retour</a>" 
                    + "  </div>"
                    + "</body>"
                    + "</html>");
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
