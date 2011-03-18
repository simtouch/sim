
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
        }catch(IOException ex){
            ex.printStackTrace();
        }
        path=canonicalPath;
        imagePath=path+File.separator+"imagenes";
        reportPath=path+File.separator+"reportes";

        System.out.println(">>  Iniciando propiedades basicas del sistema   <<");
        System.out.println(">>  Ruta base del sistema ...........: " + path);
        System.out.println(">>  Ruta de imagenes externas .......: " + imagePath);
        System.out.println(">>  Ruta para reportes ..............: " + reportPath);

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

                LoginFrm loginFrm = new LoginFrm(null, true);
                loginFrm.mostrar(true);
                
            }
        });

    }
}
