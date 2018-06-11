/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.la.model;

import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author s.mariniello
 */
public class LogSettyng implements Serializable{
   
    private String folderDay = new SimpleDateFormat("ddMMyyy").format(new Date(System.currentTimeMillis()));
    private String path_home=System.getProperty("user.dir") + File.separator;
    private String logNameFileSerialize="laAuditAll.file";
    private String logNameLog= "allUserLogs.txt";
    private String logExtension=".txt";
    private String logFileExtension=".file";
    
    
    public String getFolderDay() {
        return folderDay;
    }

    public void setFolderDay(String folderDay) {
        this.folderDay = folderDay;
    }

    public String getPath_home() {
        return path_home;
    }

    public void setPath_home(String path_home) {
        this.path_home = path_home;
    }

    public String getLogNameFileSerialize() {
        return logNameFileSerialize;
    }

 

    public String getLogNameLog() {
        return logNameLog;
    }

    public void setLogNameLog(String logNameLog) {
        this.logNameLog = logNameLog;
    }

    public String getLogExtension() {
        return logExtension;
    }

    public void setLogExtension(String logExtension) {
        this.logExtension = logExtension;
    }

    public String getLogFileExtension() {
        return logFileExtension;
    }

 


}
