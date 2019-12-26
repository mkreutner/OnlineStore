/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.directmedia.onlinestore.controller;

import com.directmedia.onlinestore.core.entity.Catalog;
import com.directmedia.onlinestore.core.entity.ShoppingCart;
import com.directmedia.onlinestore.core.entity.Work;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mkreutner
 */
@WebServlet(name = "AddToCartServlet", urlPatterns = {"/addToCart"})
public class AddToCartServlet extends HttpServlet {

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
        HttpSession session = request.getSession();
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            boolean notAllowed = true;

            String method = request.getMethod().toUpperCase();

            if (method.compareTo("POST") == 0) {
                notAllowed = false;
            }

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>"
                    + "<html>"
                    + "<head>"
                    + "<title>Front Office - Caddie</title>"
                    + "</head>"
                    + "<body>");
            if (notAllowed == true) {
                out.println("<h1>Methode de soumission du formulaire interdite...</h1>");
            } else {
                // Do the stuff...
                // Retreive work id
                int workId = Integer.parseInt(request.getParameter("work_id"));
                // Search work in catalog
                Work currentWork = new Work();
                boolean workFound = false;

                Iterator<Work> itr = Catalog.listOfWorks.iterator();
                while (itr.hasNext() && workFound == false) {
                    currentWork = itr.next();
                    if (currentWork.getId() == workId) {
                        workFound = true;
                    }
                }
                
                if (workFound == false) {
                    out.println("<h1>L'oeuvre ne peut être ajouter au caddie car elle est inconnue</h1>"
                            + "<input type=\"button\" value=\"Retour à la liste\" onclick=\"history.back()\">");
                }
                
                ShoppingCart shoppingCart = null;
                Object oShoppingCart = session.getAttribute("ShoppingCart");
                if (oShoppingCart == null) {
                    // Customer has not yet a shopping cart 
                    shoppingCart = new ShoppingCart();
                } else {
                    // Customer has already a shopping cart
                    shoppingCart = (ShoppingCart)oShoppingCart;
                }
                shoppingCart.items.add(currentWork);
                
                session.setAttribute("ShoppingCart", shoppingCart);
                
                out.println("<h1>Oeuvre ajoutée au caddie (" + shoppingCart.items.size() + ")</h1>"
                        + "<a href=\"/frontoffice/catalogue\">Retour au catalogue</a>");
            }

            out.println("</body>"
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
