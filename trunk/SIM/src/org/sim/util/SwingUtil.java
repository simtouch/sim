/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sim.util;

import java.awt.Component;
import java.awt.Cursor;
import javax.swing.RootPaneContainer;

/**
 *
 * @author Franky Villadiego
 */
public class SwingUtil {

    private SwingUtil(){}

    public static void setWaitCursor(RootPaneContainer rpc){
        rpc.getGlassPane().setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
    }

    public static void setDefaultCursor(RootPaneContainer rpc){
        rpc.getGlassPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    public static void setVisible(Component c, boolean value){
        c.setVisible(value);
    }

}
