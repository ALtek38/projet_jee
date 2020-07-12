/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.beans.*;
import modele.*;
import java.io.Serializable;
import java.sql.*;
import java.util.*;
import javax.servlet.http.HttpSession;

/**
 *
 * @author p0607615
 * 
 */
public class resultatrequete implements Serializable {
           
    private List result;
    private List clients;
    private Customer client;
    private PurchaseOrder vente;
    private List ventes;
    private HttpSession session;
    
    public resultatrequete() {}
    
    public List getResult() {
        return result;
    }
    public List getClients(){
        return clients;
    }
    
    public List getVentes(){
        return ventes;
    }
     public Customer getClient() {
        return client;
    }
     
     public PurchaseOrder getVente() {
        return vente;
    }
     public void setResult (List value)throws SQLException {
        result=value;
    }
    public void setClients (List value)throws SQLException {
        clients=value;
    }
    public void setClient (Object value)throws SQLException {
        client=(Customer)value;
    }
    
    public void setVente (Object value)throws SQLException {
        vente=(PurchaseOrder)value;
    }
    
    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }
}
