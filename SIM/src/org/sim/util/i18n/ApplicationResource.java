
package org.sim.util.i18n;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sim.util.StringUtil;



/**
 *
 * @author Franky Villadiego
 */
public class ApplicationResource {

    private static final ApplicationResource translation=new ApplicationResource();
    private static Logger log=Logger.getLogger(ApplicationResource.class.getName());
    private static ResourceBundle resource;
    private static String recurso="label";

    static{
        try{
            resource=ResourceBundle.getBundle(recurso,Locale.getDefault());
            //log=Logger.getLogger(Translation.class.getName());
        }catch(MissingResourceException ex){
            resource=null;
        }


    }


    private static ApplicationResource getCurrentInstance(){
        if(translation==null){
            return new ApplicationResource();
        }
        return translation;
    }

    /**
     * Retorna la traduccion correspondiente al key pasasdo en
     * el parametro. La traducción sera de acuerdo al idioma
     * correspiente establecido en la configuración regional del
     * usuario.
     *
     * @param key
     * @return
     */
    public static String getString(String key){
        log.log(Level.INFO, "init translation getString, locale="+Locale.getDefault().getLanguage());
        //ResourceBundle rb=getCurrentInstance().getResource();
        String label=null;
        /*if (rb==null){
            return "[No se encuentra el recurso: "+recurso;
        }*/
        if (key==null){
            return "[Key Null]";
        }
        try{
            //label=rb.getString(key);
            label=resource.getString(key);
            if(StringUtil.isNullOrEmpty(label)){
                return "[ "+key+" ]";
            }
        }catch(MissingResourceException ex){
            return "[ "+key+" ]";
        }

        return label;
    }


}
