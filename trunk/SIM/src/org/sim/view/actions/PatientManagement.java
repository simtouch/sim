/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sim.view.actions;

import java.awt.event.ActionEvent;
import org.sim.view.PatientDialog;
import org.sim.view.PacientesFrm;

/**
 *
 * @author Franky Villadiego
 */
public class PatientManagement extends FormShowAction{

    public PatientManagement() {
        super(PatientManagement.class);
        setEnabled(true);
    }


    public void actionPerformed(ActionEvent e) {
        //TODO: Verificar los permisos de un usuario antes de realizar alguna accion
        mostrarFrame();
    }



}