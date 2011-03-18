/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sim.view.actions;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

/**
 *
 * @author Franky Villadiego
 */
public abstract class GenericAction extends AbstractAction{

    

    public GenericAction(Class child) {

        //TODO: Cargar el sistema de seguridad y las acciones que un usuario tiene permiso
        
        String name = child.getName();
        System.out.println("**********************");
        System.out.println(name);
        System.out.println("**********************");
        System.out.println("Implementar seguridad asi ????");
        System.out.println("**********************");
        setEnabled(false);
    }


}
