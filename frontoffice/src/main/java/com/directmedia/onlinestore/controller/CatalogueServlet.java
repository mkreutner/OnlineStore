/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.directmedia.onlinestore.controller;

import com.directmedia.onlinestore.core.entity.Artist;
import com.directmedia.onlinestore.core.entity.Catalog;
import com.directmedia.onlinestore.core.entity.Work;
import java.io.IOException;
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
@WebServlet(name = "CatalogueServlet", urlPatterns = {"/catalogue"})
public class CatalogueServlet extends HttpServlet {

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
        
        if (Catalog.listOfWorks.isEmpty()) {

            Artist tomCruise = new Artist("Tom Cruise");
            Artist michaelJackson = new Artist("Michael Jackson");
            Artist louisDeFunes = new Artist("Louis De Funes");

            Work minorityReport = new Work("Minority Report");
            Work bad = new Work("Bad");
            Work leGendarmeDeSaintTropez = new Work("Le Gendarme De Saint Tropez");

            minorityReport.setMainArtist(tomCruise);
            bad.setMainArtist(michaelJackson);
            leGendarmeDeSaintTropez.setMainArtist(louisDeFunes);

            minorityReport.setRelease(2002);
            bad.setRelease(1987);
            leGendarmeDeSaintTropez.setRelease(1964);

            minorityReport.setSummary("En 2054, la ville de Washington a réussi à éradiquer la criminalité. Grâce aux visions du futur fournies par trois individus exceptionnels doués de précognition (appelés précogs), les agents de Précrime peuvent arrêter les criminels juste avant qu’ils ne commettent leurs méfaits. Mais un jour, le chef de l'unité John Anderton reçoit des précogs une vision le concernant : dans moins de 36 heures, il aura assassiné un homme qu’il ne connaît pas encore et pour une raison qu’il ignore. Choqué, il prend la fuite, poursuivi par ses coéquipiers qui ont pour mission de l’arrêter conformément au système.");
            bad.setSummary("Le clip, d'une durée de 18 minutes, a été réalisé par Martin Scorsese et écrit par Richard Price. On y retrouve Michael Jackson, la chanteuse Roberta Flack (qui fait la voix de la mère de Michael), ainsi que Wesley Snipes, qui débute alors sa carrière audiovisuelle.\n" +
    "\n" +
    "Daryl (Michael Jackson) un jeune garçon qui vit dans un quartier pauvre et malfamé de la ville de New York, revient de son école privée pour garçons pour les vacances d'hiver. Il retrouve sa bande avec qui il faisait des mauvais coups (parmi eux, Wesley Snipes). Mais Daryl ne semble plus méchant depuis qu'il est revenu, il est plus sérieux. Ses amis disent qu'il n'est plus méchant (« bad » en anglais) et Daryl veut alors leur prouver qu'il peut encore être un voyou. Cependant, dans une station du métro de New York (Hoyt-Schermerhorn Sts), après avoir essayé d'agresser un vieil homme, Daryl le laisse partir. Ses amis lui crient qu'il n'est plus « bad » et une dispute éclate.\n" +
    "\n" +
    "Soudain, des danseurs arrivent derrière Daryl et ce dernier apparaît avec des vêtements noirs avec des chaînes. Il simule un coup de fouet et la musique de « Bad » démarre. Le groupe se met à danser et provoque le désordre dans la station de métro. À la fin de la chanson, Daryl et ses danseurs se retrouvent devant la bande et lui crient « Who's Bad ? » (Qui est méchant ?) avec le poing devant le visage.\n" +
    "\n" +
    "Puis, Daryl et ses danseurs crient plusieurs fois sur un air rythmé « Who's Bad ? », pour prouver à la bande de Wesley Snipes qu'ils sont bien eux aussi des voyous. Daryl et Wesley Snipes se serre finalement la main. Ce dernier et ses amis quittent la station de métro et la caméra se tourne vers Daryl qui n'a plus ses vêtements noirs avec des chaînes mais ceux qu'il portait au début du clip. Les danseurs sont partis et Daryl se retrouve seul dans le métro, laissant supposer que tout cela n'était que le fruit de son imagination...");
            leGendarmeDeSaintTropez.setSummary("Grâce aux loyaux services rendus à une commune non nommée des Alpes-Maritimes1,Note 1, où il était jusqu'ici en poste, Ludovic Cruchot, gendarme, est muté dans le Var, à Saint-Tropez tout en étant promu maréchal des logis-chef.\n" +
    "\n" +
    "Arrivé sur les lieux de sa nouvelle affectation, Cruchot participe aux vaines et répétitives chasses aux nudistes organisées par son supérieur, l'adjudant Gerber, tandis que de son côté sa fille unique Nicole, qui s'ennuyait autrefois à mourir dans son village, est éblouie par le luxe de sa nouvelle ville. Mais, n'arrivant pas à se faire accepter par les jeunes bourgeois de la station balnéaire, elle s'invente un père fictif richissime : celui-ci serait milliardaire, possèderait un yacht dans cette cité et s'appellerait Archibald Ferguson, qu'elle n'aurait jamais rencontré.\n" +
    "\n" +
    "Contraint par Nicole et bien malgré lui, Cruchot va se retrouver au cœur du manège de sa fille, qui va le mêler à son histoire et par là même, à la recherche d'un Rembrandt volé (au musée de l'Annonciade), lorsque les amis de cette dernière chercheront à le rencontrer. Il essayera pourtant et par tous les moyens de préserver son identité officielle intacte au vu de son adjudant et de ses collègues.");

            minorityReport.setGenre("Science Fiction");
            bad.setGenre("Pop");
            leGendarmeDeSaintTropez.setGenre("Comédie");

            Catalog.listOfWorks.add(minorityReport);
            Catalog.listOfWorks.add(bad);
            Catalog.listOfWorks.add(leGendarmeDeSaintTropez);
        }
        
        request.setAttribute("works", Catalog.listOfWorks);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/catalogue.jsp");
        dispatcher.forward(request, response);
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
