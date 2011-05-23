
package org.sim.view;

import java.io.File;
import java.io.IOException;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Franky Villadiego
 */
public class Main {

    public static final String path;
    public static final String imagePath;
    public static final String reportPath;

    private static final String NIMBUS_LOOK_AND_FEEL = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
    private static final String WINDOWS_LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";

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
                boolean nimbus=false, windows=false;;

                try {
                    final LookAndFeelInfo[] feels = UIManager.getInstalledLookAndFeels();
                    for(LookAndFeelInfo lf : feels){
                        if(lf.getClassName().equals(NIMBUS_LOOK_AND_FEEL)){
                            nimbus=true;
                        }
                        if(lf.getClassName().equals(WINDOWS_LOOK_AND_FEEL)){
                            windows=true;
                        }

                    }
                    if(nimbus){
                        UIManager.setLookAndFeel(NIMBUS_LOOK_AND_FEEL);
                    }else{
                        if(windows){
                            UIManager.setLookAndFeel(WINDOWS_LOOK_AND_FEEL);
                        }else{
                            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                        }
                    }
                    
                  
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
