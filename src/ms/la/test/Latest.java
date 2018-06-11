/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.la.test;

import ms.la.core.AuditFactory;
import ms.la.core.Settyngs;
import ms.la.model.Line;
import ms.la.model.Log;
import ms.la.model.LogSettyng;


/**
 *
 * @author s.mariniello
 */
public class Latest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        
                AuditFactory log = AuditFactory.get("UGO").setEncoded(true).laSettyng(new Settyngs() {
                    @Override
                    public void settyng(LogSettyng settyng) {
                     settyng.setLogExtension("lb");
                     settyng.setLogNameLog("TestSettyng");
                     settyng.setPath_home("/home/utente/Scrivania/test22");
                    }
                })
                .log(new Line<>(new Log("UGO", "getUtente", "MODIFICA UTENTE")))
                .log(new Line<>(new Log("UGO", "getUtente", "MODIFICA UTENTE")))
                .log(new Line<>(new Log("UGO", "getUtente", "MODIFICA UTENTE")))
                .log(new Line<>(new Log("UGO", "getUtente", "MODIFICA UTENTE")))
                .log(new Line<>(new Log("UGO", "getUtente", "MODIFICA UTENTE")));
     
        
        
     
 
        
                AuditFactory.get("ALBERTO").setEncoded(false)
                .log(new Line<>(new Log("ALBERTO", "getUtente", "MODIFICA UTENTE")))
                .log(new Line<>(new Log("ALBERTO", "getUtente", "MODIFICA UTENTE")))
                .log(new Line<>(new Log("ALBERTO", "getUtente", "MODIFICA UTENTE")))
                .log(new Line<>(new Log("ALBERTO", "getUtente", "MODIFICA UTENTE")));
                 
                AuditFactory.get("MICHELA").setEncoded(true)
                .log(new Line<>(new Log("MICHELA", "getUtente", "MODIFICA UTENTE")))
                .log(new Line<>(new Log("MICHELA", "getUtente", "MODIFICA UTENTE")))
                .log(new Line<>(new Log("MICHELA", "getUtente", "MODIFICA UTENTE")))
                .log(new Line<>(new Log("MICHELA", "getUtente", "MODIFICA UTENTE")));
                 
                 AuditFactory.get("ROSA").setEncoded(false)
                .log(new Line<>(new Log("ROSA", "getUtente", "MODIFICA UTENTE")))
                .log(new Line<>(new Log("ROSA", "getUtente", "MODIFICA UTENTE")))
                .log(new Line<>(new Log("ROSA", "getUtente", "MODIFICA UTENTE")))
                .log(new Line<>(new Log("ROSA", "getUtente", "MODIFICA UTENTE")));
                 
                AuditFactory.get().setEncoded(false)
                .log(new Line<>(new Log("LOG", "getUtente", "MODIFICA UTENTE")))
                .log(new Line<>(new Log("LOG", "getUtente", "MODIFICA UTENTE")))
                .log(new Line<>(new Log("LOG", "getUtente", "MODIFICA UTENTE")))
                .log(new Line<>(new Log("LOG", "getUtente", "MODIFICA UTENTE")));
                          

                 
                          
 
        
    }
    
}
