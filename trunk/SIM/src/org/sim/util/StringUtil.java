
package org.sim.util;

/**
 * Clase de utilidad para manipular cadenas.
 *
 * @author Franky Villadiego
 * @since 1.0
 */
public class StringUtil {

    private StringUtil() {
    }

    /**
     * Verfica si una cadena es nula.
     * 
     * @param str
     * @return true o false
     */
    public static boolean isNull(String str){
        return str==null?true:false;
    }

    /**
     * Retorna un falso o verdadero si la cadena en el parametro es
     * nula o vacia.
     *
     * @param cadena
     * @return boolean
     */
    public static boolean isNullOrEmpty(String cadena){
        return (isNull(cadena) || cadena.length()==0)?true:false;
    }

    public static boolean isLessThat(String str, int value){
        if (str.length()<value){
            return true;
        }else{
            return false;
        }
    }

}
