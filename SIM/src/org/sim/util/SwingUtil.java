/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sim.util;

import java.awt.Component;
import java.awt.Cursor;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
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

    public static DefaultComboBoxModel getComboModel(List list, boolean x){

        class ComboItem{
            @Override
            public String toString() {
                return "--";
            }

        }
        int index=0, tama = list.size();

        Object[] array = null;
        if(x){
            tama++;
            index=1;
            array = new Object[tama];
            array[0]= new ComboItem();
        }else{
            array = new Object[tama];
        }

        for(Object o: list){
            array[index]=o;
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel(array);
        return model;

    }

}
