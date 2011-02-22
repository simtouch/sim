/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sim.view.actions;

import java.awt.event.ActionEvent;
import org.sim.view.PatientDialog;

/**
 *
 * @author Franky Villadiego
 */
public class CreatePatient extends GenericAction{

    public CreatePatient() {
        super("CreatePatient");
    }





    public void actionPerformed(ActionEvent e) {

        new PatientDialog(null, true);
    }



}
