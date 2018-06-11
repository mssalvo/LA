/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.la.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author s.mariniello
 */
public class Line<T> implements Serializable{

    
private T t;    

private Date time;

public Line(){}

public Line(T t){this.t=t; this.time=new Date();}

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
        this.time=new Date();
    }

    @Override
    public String toString() {
      return new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS").format(time)+" "+(t!=null?t.toString():"-");  
    }
    
    


}
