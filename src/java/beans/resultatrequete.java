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
import java.util.logging.Logger;
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
    private HttpSession session;
    
    public resultatrequete() {}

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public List getResult() {
        return result;
    }
    public List getClients(){
        return clients;
    }
     public Customer getClient() {
        return client;
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
}
