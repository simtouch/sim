/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sim.view.actions;

import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JInternalFrame.JDesktopIcon;

/**
 *
 * @author Franky Villadiego
 */
public class MostrarFormEntidad extends FormShowAction {

    public MostrarFormEntidad(JDesktopPane contenedor, JInternalFrame frame) {
        super(MostrarFormEntidad.class);
        setDesktopPane(contenedor);
        setFrame(frame);
        setEnabled(true);
    }


    public void actionPerformed(ActionEvent e) {
        mostrarFrame();
    }

}
