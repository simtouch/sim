
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

    /*
     * Inicializaciones basicas como rutas(de imagenes, reportes, etc)
     * y parametros de configuracion por archivo
     */
    static{
        File f=new File(".");
        String canonicalPath=null;
        try{
            canonicalPath=f.getCanonicalPath();
            System.out.println("[[  CanonicalPath()="+canonicalPath+ "  ]]");
        }catch(IOException ex){
            ex.printStackTrace();
        }
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


                MainWindow mainWindow = new MainWindow();
                mainWindow.setExtendedState(mainWindow.getExtendedState() | mainWindow.MAXIMIZED_BOTH);
                mainWindow.setVisible(true);
                
            }
        });

    }
}
