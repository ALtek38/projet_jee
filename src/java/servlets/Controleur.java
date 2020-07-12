

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
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modele.*;
import modele.UserSession;

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
         try{
                    // on créé l'objet session
                    HttpSession session = request.getSession();
                    // On récupère le login et le mot de passe (ne fonctionne pas car la page login.jsp ne renvoie pas sur le controleur)
                    String login = request.getParameter("j_username");
                    String password = request.getParameter("j_password");
                    // on créé l'utilisateur associé à la session
                    UserSession user = new UserSession (login, password);
                    // On définis les attributs de la session
                    session.setAttribute("user", user);
                    // On envoie la session au beans
                    resultatrequete a = new resultatrequete();
                    a.setSession(session);
                    // On passe le bean à request
                    request.setAttribute("session", a);
                    // On fait passer request à la page menu.jsp
                    request.getRequestDispatcher("menu.jsp").forward(request,response);
                } 
                catch (Exception e){
                    e.getMessage();
                }
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
        List<String> list_client = Arrays.asList("Afficher tous les clients","Ajouter un nouveau client","Enregistrer le client","Modifier le client","Supprimer le client","Afficher les achats","Rechercher un client");
        List<String> aff_client = Arrays.asList("");
        List<String> list_vente = Arrays.asList("Afficher toutes les ventes","Ajouter une nouvelle vente","Enregistrer la vente","Modifier la vente","Supprimer la vente");
        List<String> list_produit = Arrays.asList("Afficher tous les produits","Ajouter un nouveau produit");
        List<String> list_stock = Arrays.asList("Afficher tous les stocks","Ajouter du stock");
        
        //System.out.println(request.getParameter("afficher_client"));
        
        
        if (list_client.contains(request.getParameter("Operation_client"))){
        switch(request.getParameter("Operation_client")){
            case "Afficher tous les clients" :
                try{
                requeteur=new MagasinHelper();
                resultatrequete a = new resultatrequete();
                a.setResult(requeteur.getClients());
                request.setAttribute("resultat",a);//déclaration de mon javabean dans mes paramètres POST
                request.getRequestDispatcher("resultat_client.jsp").forward(request,response);//renvoie mon résultat à la page resultat.jsp affichée par le navigateur client
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            break;
            case "Rechercher un client" :
                response.sendRedirect("recherche.jsp");
                //request.getRequestDispatcher("recherche.jsp").forward(request,response);//renvoie mon résultat à la page resultat.jsp affichée par le navigateur client
            break;
            case "Ajouter un nouveau client" :
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
            case "Enregistrer le client" :
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
               
           case "Modifier le client" :
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
            case "Supprimer le client" :
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
                    a.setClient(requeteur.getClient(Integer.parseInt(request.getParameter("afficher_client")))); 
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
        }else if(list_vente.contains(request.getParameter("Operation_vente"))){
        switch(request.getParameter("Operation_vente")){ 
            case "Afficher toutes les ventes" :
                try{
                requeteur=new MagasinHelper();
                resultatrequete a = new resultatrequete();
                a.setResult(requeteur.getVentes());
                //System.out.println(a);
                request.setAttribute("resultat",a);//déclaration de mon javabean dans mes paramètres POST
                request.getRequestDispatcher("resultat_vente.jsp").forward(request,response);//renvoie mon résultat à la page resultat.jsp affichée par le navigateur client
                }
                catch (SQLException e){
                    //e.printStackTrace();
                }
            break;
            case "Ajouter une nouvelle vente" :
                try{
                    requeteur=new MagasinHelper();
                    resultatrequete a = new resultatrequete();
                    resultatrequete b = new resultatrequete();
                    a.setResult(requeteur.getClients());
                    b.setResult(requeteur.getProduits());
                    request.setAttribute("produit",b);
                    request.setAttribute("client",a);
                    request.getRequestDispatcher("ajout_vente.jsp").forward(request,response);
                }         
                catch (SQLException e){
                request.setAttribute("erreur", "erreur requete "+e);
                request.getRequestDispatcher("error.jsp").forward(request,response);
                };
            break;
            case "Enregistrer la vente" :
                try{
                requeteur=new MagasinHelper();
                String param1 = request.getParameter("produit");
                String param2 = request.getParameter("quantité");
                String param3 = request.getParameter("livraison");
                String param4 = request.getParameter("date_livr");
                String param5 = request.getParameter("vente");
                String param6 = request.getParameter("compagnie");
                String param7 = request.getParameter("client");
                //requeteur.insertVente(30000, param1.charAt(0),(Short)param2,(Bigparam3,param4,param5, param6,param7);
                }
                catch (Exception e){
                request.setAttribute("erreur", "erreur requete "+e);
                request.getRequestDispatcher("error.jsp").forward(request,response);
                };
                request.setAttribute("confirm", "Enregistrement effectué");
                request.getRequestDispatcher("confirm.jsp").forward(request,response);
                break;
                
              
            default ://cas où la variable Operation envoyée par les jsp prend la valeur d'un numéro de client
                try{
                    requeteur=new MagasinHelper();
                    resultatrequete a = new resultatrequete();
                    a.setVente(requeteur.getVente(Integer.parseInt(request.getParameter("Operation_vente"))));
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
        }else if(list_produit.contains(request.getParameter("Operation_produit"))){
        switch(request.getParameter("Operation_produit")){ 
            case "Afficher tous les produits" :
                try{
                requeteur=new MagasinHelper();
                resultatrequete a = new resultatrequete();
                a.setResult(requeteur.getProduitsCode());
                //System.out.println(a);
                request.setAttribute("resultat",a);//déclaration de mon javabean dans mes paramètres POST
                request.getRequestDispatcher("resultat_produit.jsp").forward(request,response);//renvoie mon résultat à la page resultat.jsp affichée par le navigateur client
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            break;
            case "Ajouter un nouveau produit" :
                requeteur=new MagasinHelper();
                request.getRequestDispatcher("ajout_produit.jsp").forward(request,response);
            break;
            
                
              
            default ://cas où la variable Operation envoyée par les jsp prend la valeur d'un numéro de client
                try{
                    requeteur=new MagasinHelper();
                    resultatrequete a = new resultatrequete();
                    a.setVente(requeteur.getVente(Integer.parseInt(request.getParameter("Operation_vente"))));
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
        }else if (list_stock.contains(request.getParameter("Operation_stock"))){
            switch(request.getParameter("Operation_stock")){ 
            case "Afficher tous les stocks" :
                try{
                requeteur=new MagasinHelper();
                resultatrequete a = new resultatrequete();
                a.setResult(requeteur.getProduits());
                //System.out.println(a);
                request.setAttribute("resultat",a);//déclaration de mon javabean dans mes paramètres POST
                request.getRequestDispatcher("resultat_stock.jsp").forward(request,response);//renvoie mon résultat à la page resultat.jsp affichée par le navigateur client
                }
                catch (SQLException e){
                    e.printStackTrace();
                }
            break;
            case "Ajouter du stock" :
                    request.getRequestDispatcher("ajout_stock.jsp").forward(request,response);
                
            break;
            }
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
