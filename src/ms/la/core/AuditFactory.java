/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.la.core;

import ms.la.model.LAlog;
import ms.la.model.Line;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author s.mariniello
 */

public class AuditFactory extends SerializeData {

    private static AuditFactory auditFactory;
    private Audit auditAllLogs;
    private StringBuffer out;
    private boolean encoded;
    private boolean checkFile = false;
    private String keyUser = "log";
    
    private AuditFactory() {
        checkAllDir();
    }

    private AuditFactory(String keyUser) {
        this.keyUser = keyUser;
        checkAllDir();
    }

    public Audit getAudit() {
        if (auditAllLogs == null) {
            auditAllLogs = this.getLAudit();
        }
        if (auditAllLogs == null) {
            auditAllLogs = new Audit();
        }
        this.salva(auditAllLogs);

        return auditAllLogs;
    }

    public AuditFactory log(Line<?> line) {
        this.getLAlog().add(line);
        this.write();
        return this;
    }
    
    public AuditFactory log(String line) {
        this.getLAlog().add(new Line<String>(line));
        this.write();
        return this;
    }
    
    public LAlog getLAlog(String user) {
        this.keyUser = user;
        LAlog alog = this.getAudit().get(this.keyUser);
        if (alog == null) {
            alog = new LAlog(this.keyUser);
            auditAllLogs.put(this.keyUser, alog);
        }
        this.salva(alog, this.keyUser);
        return alog;

    }

    private LAlog getLAlog() {
        LAlog alog = this.getAudit().get(this.keyUser);
        if (alog == null) {
            alog = new LAlog(this.keyUser);
            auditAllLogs.put(this.keyUser, alog);
        }
        this.salva(alog, this.keyUser);
        return alog;

    }

    public void setAudit(Audit auditAllLogs) {
        this.auditAllLogs = auditAllLogs;
    }

    public boolean isEncoded() {
        return encoded;
    }

    public AuditFactory setEncoded(boolean encoded) {
        this.encoded = encoded;
        return this;
    }
 
 
    public AuditFactory laSettyng(Settyngs settyngs) {
        this.setSettyng(settyngs);
 
        checkAllDir();
        return this;
    }
    
    public synchronized static AuditFactory get() {

        if (auditFactory == null) {
            auditFactory = new AuditFactory("LOG");

        } else {
            auditFactory.keyUser = "LOG";
        }

        return auditFactory;

    }

    
    public synchronized static AuditFactory get(String keyUser) {

        if (auditFactory == null) {
            auditFactory = new AuditFactory(keyUser);

        } else {
            auditFactory.keyUser = keyUser;
        }
        return auditFactory;

    }

    
    
    private StringBuffer writeLogAllUser() {
        this.checkPathUser();

        StringBuffer outLg = new StringBuffer();
        Collection<LAlog> laLog = this.getAudit().values();
        for (LAlog log : laLog) {
            Iterator<Line<?>> line = log.iterator();
            outLg.append("**********************************************************************************************************************************\n");
            outLg.append(" USER LOG : ");
            outLg.append(log.getUser());
            outLg.append(" DATE LOG : ");
            outLg.append(log.getTimeLoggin());
            outLg.append("\n");
            outLg.append("**********************************************************************************************************************************\n");

            while (line.hasNext()) {
                outLg.append(line.next().toString());
                outLg.append("\n");
            }

        }

        if (isEncoded()) {
            return new StringBuffer(Base64.getEncoder().encodeToString(outLg.toString().getBytes()));
        }

        return outLg;

    }

    
    private StringBuffer writeLog(String userLoggin) {
        this.checkPathUser();

        StringBuffer outLg = new StringBuffer();

        Iterator<Line<?>> lines = this.getLAlog(userLoggin).iterator();

        while (lines.hasNext()) {
            outLg.append(lines.next().toString());
            outLg.append("\n");
        }
        if (isEncoded()) {
            return new StringBuffer(Base64.getEncoder().encodeToString(outLg.toString().getBytes()));
        }
        return outLg;

    }

    private void checkPathUser() {

        if (!this.checkFile) {
            File file = new File(getPath_Log_User());
            if (!file.exists()) {
                file.mkdirs();
            } else {
                this.checkFile = true;
            }
        }
    }

 

    public AuditFactory write() {

        this.out = this.writeLog(this.keyUser);

        BufferedWriter in = null;
        try {
            File f = new File(getPath_Log_User()+ this.keyUser + checkExtension());
            in = new BufferedWriter(new FileWriter(f));
            in.write(this.out.toString());

        } catch (IOException ex) {
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
            }
        }

        return writeAllLogs();
    }

    public AuditFactory write(String userLoggin) {

        this.out = this.writeLog(userLoggin);

        BufferedWriter in = null;
        try {
            File f = new File(getPath_Log_User()+ userLoggin + checkExtension());
            in = new BufferedWriter(new FileWriter(f));
            in.write(this.out.toString());

        } catch (IOException ex) {
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
            }
        }
        return this;
    }

    private AuditFactory writeAllLogs() {
        this.out = this.writeLogAllUser();

        BufferedWriter in = null;
        try {
            File f = new File(getPath_Log() + checkLogAllNameUser());
            in = new BufferedWriter(new FileWriter(f));
            in.write(this.out.toString());

        } catch (IOException ex) {
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
            }
        }

        return this;

    }
 
    
}
