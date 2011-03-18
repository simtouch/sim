
package org.sim.view.actions;

import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;



/**
 *
 * @author Franky Villadiego
 */

public abstract class FormShowAction extends GenericAction{

    private JDesktopPane desktopPane;
    private JInternalFrame frame;

    protected FormShowAction(Class child) {
        super(child);
    }

    protected JDesktopPane getDesktopPane() {
        return desktopPane;
    }

    protected void setDesktopPane(JDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
    }

    protected JInternalFrame getFrame() {
        return frame;
    }

    protected void setFrame(JInternalFrame frame) {
        this.frame = frame;
    }

    protected void mostrarFrame(){
        if(desktopPane != null && frame != null){
            final JInternalFrame[] frames = desktopPane.getAllFrames();
            boolean existe=false;
            for (JInternalFrame jIntFrm : frames) {
                if(jIntFrm == frame){
                    existe = true;
                    break;
                }
            }
            if(frames.length==0 || !existe)desktopPane.add(frame);
            frame.show();
            try {
                frame.setSelected(true);
            } catch (PropertyVetoException ex) {
                Logger.getLogger(FormShowAction.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }


}
