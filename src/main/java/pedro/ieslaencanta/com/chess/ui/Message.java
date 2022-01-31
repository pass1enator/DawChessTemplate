/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.chess.ui;

import java.util.Timer;
import java.util.TimerTask;
import org.apache.batik.anim.dom.SVGDOMImplementation;
import org.w3c.dom.*;

/**
 *
 * @author Pedro
 */
public class Message {

    private String msg;
    private int time;
    
    private boolean running;
    private Document doc;
    private Element e;
    private Timer timer;
    private TimerTask task;

    public Message(String msg, int time, Document doc) {
        this.msg = msg;
        this.doc = doc;
        this.time = time;

        this.timer = new Timer();
        this.running = false;

    }

    public void stop() {
        this.running = false;
    }

    public void start() {
        
        this.createElement();
        this.running = true;
        this.task = new TimerTask() {
            @Override
            public void run() {
                running = false;
                Element l = doc.getElementById("msg");
                System.out.println(l.getAttributeNS(null, "id"));
                doc.getDocumentElement().removeChild(l);
            }
        };
        this.timer.schedule(this.task, this.getTime());
    }

    private void createElement() {
       
        this.e = doc.createElementNS(SVGDOMImplementation.SVG_NAMESPACE_URI, "text");
        
        this.e.setAttributeNS(null, "x", "170");
        this.e.setAttributeNS(null, "y", "212");
        this.e.setAttributeNS(null, "fill", "green");
        this.e.setAttributeNS(null, "font-family", "Verdana");
        this.e.setAttributeNS(null, "font-size", "42");
        this.e.setAttributeNS(null, "id", "msg");//this.msg);

        this.e.setAttributeNS(null, "stroke", "orange");
        this.e.setAttributeNS(null, "stroke-width", "3");
        this.e.setTextContent(this.getMsg());
        this.doc.getDocumentElement().appendChild(this.e);

    }

    public boolean isRun() {
        return this.running;

    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @return the time
     */
    public int getTime() {
        return time;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @param time the time to set
     */
    public void setTime(int time) {
        this.time = time;
    }

}
