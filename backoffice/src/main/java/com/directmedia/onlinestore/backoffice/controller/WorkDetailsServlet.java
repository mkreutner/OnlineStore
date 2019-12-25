/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.directmedia.onlinestore.backoffice.controller;

import com.directmedia.onlinestore.core.entity.Catalog;
import com.directmedia.onlinestore.core.entity.Work;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mkreutner
 */
@WebServlet(name = "WorkDetailsServlet", urlPatterns = {"/work-details"})
public class WorkDetailsServlet extends HttpServlet {

    private String printKeyValue(String key, String value) {
        return "<li><em>" + key + "</em> : " + value + "</li>";
    }

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            int nbWorks = Catalog.listOfWorks.size();
            int id = Integer.parseInt(request.getParameter("id"));

            Work currentWork = new Work();
            boolean workFound = false;

            Iterator<Work> itr = Catalog.listOfWorks.iterator();
            while (itr.hasNext() && workFound == false) {
                currentWork = itr.next();
                if (currentWork.getId() == id) {
                    workFound = true;
                }
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Back Office - Oeuvre</title>");
            out.println("</head>");
            out.println("<body>");
            if (workFound == false) {
                out.println("<h1>Aucune oeuvre trouvée...</h1>");
            } else {
                out.println("<h1>Détail de l'oeuvre : "
                        + currentWork.getTitle()
                        + " (" + "" + "/" + Integer.toString(nbWorks) + ")</h1>"
                        + "<ul>"
                        + printKeyValue("Titre", currentWork.getTitle())
                        + printKeyValue("Genre", currentWork.getGenre())
                        + printKeyValue("Année", Integer.toString(currentWork.getRelease()))
                        + printKeyValue("Resumé", currentWork.getSummary())
                        + "<li><em>Act(eur/rice) Principal(e)</em> : <ul>"
                        + printKeyValue("Nom", currentWork.getMainArtist().getName())
                        + "</ul>"
                        + "</ul>"
                );
            }
            out.println("</hr>");
            out.println("<input type=\"button\" value=\"Retour à la liste\" onclick=\"history.back()\">");
            out.println("</body>");
            out.println("</html>");
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
