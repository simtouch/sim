/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sim.util;

import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Franky Villadiego
 */
public class SessionMonitor implements AWTEventListener, ActionListener{

    private final Timer timer=new Timer(600000,this);
    private static final SessionMonitor session=null;
    private static String myUserName;
    private static String myUserLogin;

    private static SessionMonitor getInstance(){
        return session==null? createInstance():session;
    }
    private static SessionMonitor createInstance(){
        return new SessionMonitor();
    }

    private SessionMonitor(){
        timer.setRepeats(false);
        timer.start();
    }

    public static void init(){
        Toolkit.getDefaultToolkit().addAWTEventListener(getInstance(), AWTEvent.KEY_EVENT_MASK | AWTEvent.FOCUS_EVENT_MASK);
    }

    @Override
    public void eventDispatched(AWTEvent event) {
        timer.restart();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,"Session expiro");
    }

    public static String getUserName() {
        return myUserName;
    }

    public static void setUserName(String userName) {
        myUserName = userName;
    }

    public static String getUserLogin() {
        return myUserLogin;
    }

    public static void setUserLogin(String userLogin) {
        myUserLogin = userLogin;
    }

}
