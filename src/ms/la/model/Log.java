/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.la.model;

import java.io.Serializable;
import java.util.UUID;
 

/**
 *
 * @author s.mariniello
 */
public class Log  implements Serializable{
    
    private String user;
    private String method;
    private String action;
    private String id;

    
    
    public Log(String user, String method, String action, String id) {
        this.user = user;
        this.method = method;
        this.action = action;
        this.id = id;
    }

    public Log(String user, String method, String action) {
        this.user = user;
        this.method = method;
        this.action = action;
    }

    public Log() {
    }
    
    
    
    
    @Override
    public String toString() {
        
        return "[ user= " + user + " ][ method= " + method + " ][ action= " + action + " ]"+(id!=null?"[ id= " + id + "]":"");
    }

 
    
    
}
