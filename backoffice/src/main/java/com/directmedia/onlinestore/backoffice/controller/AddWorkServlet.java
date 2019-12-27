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
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
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
        boolean notAllowed = true;
        
        String title;
        int release;
        String genre;
        String summary;
        String mainArtist;
        
        String method = request.getMethod().toUpperCase();
        
        if (method.compareTo("POST") == 0) {
            notAllowed = false;
        }
            
        if (notAllowed != true) {
            try {
                title = request.getParameter("title");
                release = Integer.parseInt(request.getParameter("release"));
                genre = request.getParameter("genre");
                summary = request.getParameter("summary");
                mainArtist = request.getParameter("main_artist");

                Work currentWork = new Work();
                boolean alreadyExists = false;

                Iterator<Work> itr = Catalog.listOfWorks.iterator();
                while (itr.hasNext() && alreadyExists == false) {
                    currentWork = itr.next();
                    if ((currentWork.getTitle().compareTo(title) == 0)                              // same title
                            && (currentWork.getRelease() == release)                                // same release year
                            && (currentWork.getMainArtist().getName().compareTo(mainArtist) == 0)   // same main artist
                       ) {
                        alreadyExists = true;
                    }
                }

                if (alreadyExists == false) {
                    Artist newArtist = new Artist(mainArtist);
                    Work newWork = new Work(title);
                    newWork.setGenre(genre);
                    newWork.setRelease(release);
                    newWork.setSummary(summary);
                    newWork.setMainArtist(newArtist);
                    Catalog.listOfWorks.add(newWork);

                    request.setAttribute("identifiantOeuvre", newWork.getId());
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/workAddedSuccess");
                    dispatcher.forward(request, response);
                } else {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/workAddedFailure");
                    dispatcher.forward(request, response);
                }
            } catch (NumberFormatException nfe) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/workAddedFailure");
                dispatcher.forward(request, response);
            }
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/workAddedFailure");
            dispatcher.forward(request, response);
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
