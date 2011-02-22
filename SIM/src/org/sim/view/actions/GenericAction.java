/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sim.view.actions;

import javax.swing.AbstractAction;
import javax.swing.JDesktopPane;

/**
 *
 * @author Franky Villadiego
 */
public abstract class GenericAction extends AbstractAction{

    private JDesktopPane desktopPane;

    public GenericAction(String child) {

        String name = child;
        System.out.println("**********************");
        System.out.println(name);
        System.out.println("**********************");
        System.out.println("Implementar seguridad asi ????");
        System.out.println("**********************");
        setEnabled(false);
    }

    public JDesktopPane getDesktopPane() {
        return desktopPane;
    }

    public void setDesktopPane(JDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
    }

}
