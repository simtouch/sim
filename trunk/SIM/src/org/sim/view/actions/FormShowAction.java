
package org.sim.view.actions;

import java.awt.Dimension;
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
    private boolean centrado;

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

    protected boolean isCentrado() {
        return centrado;
    }

    protected void setCentrado(boolean centrado) {
        this.centrado = centrado;
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

    protected void centrarFrame(){
        final Dimension containerSize = getDesktopPane().getSize();
        final Dimension frameSize = getFrame().getSize();
        int x = (containerSize.width - frameSize.width) / 2;
        int y = (containerSize.height - frameSize.height) / 2;
        getFrame().setLocation(x, y);
    }


}
