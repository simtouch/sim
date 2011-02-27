
package org.sim.util;


/**
 *
 * @author Franky Villadiego
 */
public class UserInfo {
    /* Variables Miembro */
    private static UserInfo usuario;
    private static String elnombre;
    //private static UserJpa user;
    /* Constructor */
    private UserInfo() {
        //elnombre=nombre;
    }
    
    public static UserInfo getUsuario(){
        if(usuario==null){
            usuario=new UserInfo();
        }
         return usuario;   
    }

}
