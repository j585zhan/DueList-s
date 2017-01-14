/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duelist;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jimmy
 */
public class Timer {
    private String dateDue;
    private long offset;
    private long MSeconds;
    
    public Timer (String dateDue){
        this.dateDue = dateDue;
    }
    
    public void update () {
        // example "17/01/13 23:44:58";

        // Custom date format
        SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd HH:mm:ss");  

        Date due = null;
        Date current = new Date();
        try {
            due = format.parse(dateDue);
        } catch (ParseException e) {
            e.printStackTrace();
        }    

        // Get msec from each, and subtract.
        MSeconds = due.getTime() - current.getTime();
//      long Seconds = MSeconds / 1000;
//      long Minutes = MSeconds / (60 * 1000);         
//      System.out.println("Time in hours: " + MSeconds + " hours.");
//      System.out.println("Time in seconds: " + Seconds + " seconds.");         
//      System.out.println("Time in minutes: " + Minutes + " minutes.");
    }
    
    public long getMSeconds() {
        return MSeconds;
    }
    
    public void dueDayUpdate() {
        
    }
}
