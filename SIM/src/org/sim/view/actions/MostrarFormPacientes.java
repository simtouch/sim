/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sim.view.actions;

import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author Franky Villadiego
 */
public class MostrarFormPacientes extends FormShowAction {

    public MostrarFormPacientes(JDesktopPane contenedor, JInternalFrame frame) {
        super(MostrarFormPacientes.class);
        setDesktopPane(contenedor);
        setFrame(frame);
        setEnabled(true);
    }


    public void actionPerformed(ActionEvent e) {
        mostrarFrame();
    }

}
