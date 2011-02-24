
package org.sim.util;

import org.sim.repository.dao.security.UserJpa;

/**
 *
 * @author Franky Villadiego
 */
public class UserInfo {
    /* Variables Miembro */
    private static UserInfo usuario;
    private static String elnombre;
    private static UserJpa user;
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
    public static String getLog(){
        return user.getLogin();
    }
/*    public void setNombre(String nombre){
        if(elnombre==null){
            elnombre=nombre;    
        }
    }*/
    public void setUser(UserJpa usuario){
        if(user==null){
            user=usuario;
        }
    }
    public String getLogin(){
        return user.getLogin();
    }
    public String toString(){
        return user.getNombre().trim()+" "+ user.getApellido().trim();
    }
}
