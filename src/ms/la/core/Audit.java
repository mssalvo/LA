/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.la.core;

import ms.la.model.LAlog;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author s.mariniello
 */
public class Audit extends LinkedHashMap<String, LAlog> implements Serializable{

    public Audit() {
    }

    public Audit(Map<? extends String, ? extends LAlog> m) {
        super(m);
    }

    @Override
    public LAlog get(Object key) {
        return super.get(key); 
    }

    @Override
    public LAlog put(String key, LAlog value) {
        return super.put(key, value); 
    }

    @Override
    public int size() {
        return super.size();  
    }
    
    
    
}
