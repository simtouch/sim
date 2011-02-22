/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sim.view.actions;

import java.awt.event.ActionEvent;
import org.sim.view.PatientDialog;
import org.sim.view.Patients;

/**
 *
 * @author Franky Villadiego
 */
public class PatientManagement extends GenericAction{

    public PatientManagement() {
        super("PatientManagement");
        setEnabled(true);
    }





    public void actionPerformed(ActionEvent e) {

        
        if(getDesktopPane()!=null){
            Patients p=new Patients();
            getDesktopPane().add(p);
            p.setVisible(true);
        }
        
    }



}
