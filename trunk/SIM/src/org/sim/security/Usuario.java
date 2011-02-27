/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sim.security;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.sim.util.exceptions.BusinessException;
import org.sim.util.exceptions.RepositoryException;

/**
 *
 * @author Franky Villadiego
 */
@Entity
@Table(name="users")
public class Usuario implements Serializable{

    private static transient UsuarioRepository usuarioRepository = UsuarioRepository.Impl.getInstance();

    @Id
    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if ((this.login == null) ? (other.login != null) : !this.login.equals(other.login)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (this.login != null ? this.login.hashCode() : 0);
        return hash;
    }

    public static Usuario cargar(String login) throws RepositoryException, BusinessException{
        return usuarioRepository.cargar(login);
    }


    
}
