
package org.sim.util;

/**
 *
 * @author Franky Villadiego
 */
public class DateUtil {

    private DateUtil() {
    }

    /**
     * Retorna un falso o verdadero si la cadena en el parametro es
     * nula o vacia.
     *
     * @param cadena
     * @return boolean
     */
    public static boolean isNullOrEmpty(String cadena){
        return (cadena==null || cadena.length()==0)?true:false;
    }

}
