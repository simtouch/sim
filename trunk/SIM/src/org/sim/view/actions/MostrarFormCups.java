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
public class MostrarFormCups extends FormShowAction {

    public MostrarFormCups(JDesktopPane contenedor, JInternalFrame frame) {
        super(MostrarFormCups.class);
        setDesktopPane(contenedor);
        setFrame(frame);
        setEnabled(true);
    }

    public MostrarFormCups(JDesktopPane contenedor, JInternalFrame frame, boolean centrado) {
        super(MostrarFormCups.class);
        setDesktopPane(contenedor);
        setFrame(frame);
        setCentrado(centrado);
        setEnabled(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(isCentrado()) centrarFrame();
        mostrarFrame();
    }

}
