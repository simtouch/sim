/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sim.repository.dao.security;

import java.io.Serializable;

/**
 *
 * @author Franky Villadiego
 */
public class UserJpa implements Serializable{


    private String login;
    private String nombre;
    private String apellido;

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }




}
