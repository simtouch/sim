/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sim.view;

import java.io.File;
import java.io.IOException;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Franky Villadiego
 */
public class Main {

    public static final String path;
    public static final String imagePath;
    public static final String reportPath;
    static{
        File f=new File(".");
        String canonicalPath=null;
        try{
            canonicalPath=f.getCanonicalPath();
            System.out.println("[[  CanonicalPath()="+canonicalPath+ "  ]]");
        }catch(IOException ex){ex.printStackTrace();}
        path=canonicalPath;
        imagePath=path+File.separator+"imagenes";
        reportPath=path+File.separator+"reportes";

    }
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                   UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                } catch (IllegalAccessException ex){
                    ex.printStackTrace();
                }catch (InstantiationException ex) {
                    ex.printStackTrace();
                }catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }


//                Principal miPrincipal =Principal.getInstance();
//                miPrincipal.setExtendedState(miPrincipal.getExtendedState() | miPrincipal.MAXIMIZED_BOTH);
//                miPrincipal.getContentPane().setBackground(new java.awt.Color(195, 218, 249));
//                miPrincipal.setVisible(true);
            }
        });

    }
}
