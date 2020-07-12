/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import beans.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.*;

/**
 *
 * @author dhond
 */
public class Controleur_vente extends HttpServlet{
    
    MagasinHelper requeteur;
    String erreur;     
    
     @Override
    public void init(){        
       
    }
     @Override
    public void destroy() {        
             
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
        response.sendRedirect("vente.jsp");
       
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
        response.sendRedirect("vente.jsp");
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
        switch(request.getParameter("Operation")){
            case "Afficher toutes les ventes" :
                try{
                requeteur=new MagasinHelper();
                old_resultatrequete a = new old_resultatrequete();
                a.setResult(requeteur.getVentes());
                System.out.println(a);
                request.setAttribute("resultat",a);//déclaration de mon javabean dans mes paramètres POST
                request.getRequestDispatcher("resultat_vente.jsp").forward(request,response);//renvoie mon résultat à la page resultat.jsp affichée par le navigateur client
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            break;
            case "Ajouter une nouvelle vente" :
                try{
                    requeteur=new MagasinHelper();
                    old_resultatrequete a = new old_resultatrequete();
                    a.setResult(requeteur.getClients());
                    request.setAttribute("client",a);
                    request.getRequestDispatcher("ajout_vente.jsp").forward(request,response);
                }         
                catch (SQLException e){
                request.setAttribute("erreur", "erreur requete "+e);
                request.getRequestDispatcher("error.jsp").forward(request,response);
                };
            break;
                
              
            default ://cas où la variable Operation envoyée par les jsp prend la valeur d'un numéro de client
                try{
                    requeteur=new MagasinHelper();
                    old_resultatrequete a = new old_resultatrequete();
                    a.setClient(requeteur.getVente(Integer.parseInt(request.getParameter("Operation"))));
                    request.setAttribute("resultat",a);
                    //resultatrequete b = new resultatrequete();
                    //b.setResult(requeteur.getDiscountCode());
                    //resultatrequete c = new resultatrequete();
                    // c.setResult(requeteur.getMicroMarket());
                    //request.setAttribute("dc",b);
                    //request.setAttribute("zip",c);
                    request.getRequestDispatcher("detail_vente.jsp").forward(request,response);
                   
                }
                catch (Exception e){
                    request.setAttribute("erreur", "erreur requete "+e);
                    request.getRequestDispatcher("error.jsp").forward(request,response);
                };
        }           
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
