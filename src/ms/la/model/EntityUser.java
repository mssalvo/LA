/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.la.model;

import java.io.Serializable;

/**
 *
 * @author s.mariniello
 */
public class EntityUser implements Serializable{
    
   String code;
   String userId;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

  
    public String userString() {
        return " [" + "CODE=" + code + " | USERID=" + userId + "] ";
    }
   
    
}
