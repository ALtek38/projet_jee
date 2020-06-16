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
 * @author p0607615
 */
public class Controleur extends HttpServlet {
    
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
        response.sendRedirect("menu.jsp");
       
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
        response.sendRedirect("menu.jsp");
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
            case "Afficher tous les enregistrements" :
                try{
                requeteur=new MagasinHelper();
                resultatrequete a = new resultatrequete();
                a.setResult(requeteur.getClients());
                request.setAttribute("resultat",a);//déclaration de mon javabean dans mes paramètres POST
                request.getRequestDispatcher("resultat.jsp").forward(request,response);//renvoie mon résultat à la page resultat.jsp affichée par le navigateur client
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            break;
            case "inserer un enregistrement" :
                try{
                    requeteur=new MagasinHelper();
                    resultatrequete a = new resultatrequete();
                    resultatrequete b = new resultatrequete();
                   a.setResult(requeteur.getDiscountCode());
                    b.setResult(requeteur.getMicroMarket());
                   request.setAttribute("dc",a);
                    request.setAttribute("cp",b);
                    request.getRequestDispatcher("form_inscription.jsp").forward(request,response);
                }         
                catch (SQLException e){
                request.setAttribute("erreur", "erreur requete "+e);
                request.getRequestDispatcher("error.jsp").forward(request,response);
                };
            break;
            case "Enregistrer" :
                try{
                requeteur=new MagasinHelper();
                String param1 = request.getParameter("nom");
                String param2 = request.getParameter("adresse");
                String param3 = request.getParameter("telephone");
                String param4 = request.getParameter("email");
                String param5 = request.getParameter("code_remise");
                String param6 = request.getParameter("CP");
                requeteur.insertCustomer(30000, param5.charAt(0), param6);
                }
                catch (Exception e){
                request.setAttribute("erreur", "erreur requete "+e);
                request.getRequestDispatcher("error.jsp").forward(request,response);
                };
                request.setAttribute("confirm", "Enregistrement effectué");
                request.getRequestDispatcher("confirm.jsp").forward(request,response);
                break;
               
           case "Modifier" :
                try{
                requeteur=new MagasinHelper();
                String param1 = request.getParameter("numero");
                String param2 = request.getParameter("nom");
                String param3 = request.getParameter("adresse");
                String param4 = request.getParameter("telephone");
                Character param5 = request.getParameter("Remise").charAt(0);
                String param6 = request.getParameter("Code_Postal");
                requeteur.updateCustomer(Integer.parseInt(param1),param2,param3,param4,param5,param6);
               
                }
                catch (Exception e){
                    request.setAttribute("erreur", "erreur requete "+e);
                    request.getRequestDispatcher("error.jsp").forward(request,response);
                };
                request.setAttribute("confirm", "Modification effectuée");
                request.getRequestDispatcher("confirm.jsp").forward(request,response);
            break;
            case "Supprimer" :
                try{
                requeteur=new MagasinHelper();
                String param1=request.getParameter("numero");
               requeteur.deleteCustomer(Integer.parseInt(param1));
               
                }
                catch (Exception e){
                    request.setAttribute("erreur", "erreur requete "+e);
                    request.getRequestDispatcher("error.jsp").forward(request,response);
                };                
                request.setAttribute("confirm", "Suppression effectuée");//message de confirmation de suppression envoyé à la jsp
                request.getRequestDispatcher("confirm.jsp").forward(request,response);
            break;
           case "Afficher les achats" :
                try{
                   try{
                requeteur=new MagasinHelper();
                resultatrequete a = new resultatrequete();
                a.setResult(requeteur.getAchats(Integer.parseInt(request.getParameter("numero"))));
                request.setAttribute("resultat",a);//déclaration de mon javabean dans mes paramètres POST
                request.getRequestDispatcher("achats.jsp").forward(request,response);//renvoie mon résultat à la page resultat.jsp affichée par le navigateur client
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                    
                }
                catch (Exception e){
                    request.setAttribute("erreur", "erreur requete "+e);
                    request.getRequestDispatcher("error.jsp").forward(request,response);
                };
                break;
               
                
              
            default ://cas où la variable Operation envoyée par les jsp prend la valeur d'un numéro de client
                try{
                    requeteur=new MagasinHelper();
                    resultatrequete a = new resultatrequete();
                    a.setClient(requeteur.getClient(Integer.parseInt(request.getParameter("Operation"))));
                    request.setAttribute("resultat",a);
                    resultatrequete b = new resultatrequete();
                    b.setResult(requeteur.getDiscountCode());
                    resultatrequete c = new resultatrequete();
                     c.setResult(requeteur.getMicroMarket());
                    request.setAttribute("dc",b);
                    request.setAttribute("zip",c);
                    request.getRequestDispatcher("detail.jsp").forward(request,response);
                   
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
