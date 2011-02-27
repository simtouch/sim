/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sim.security;

import org.sim.repository.*;
import org.sim.domain.Entidad;
import org.sim.util.BeanContainer;
import org.sim.util.exceptions.RepositoryException;

/**
 *
 * @author Franky Villadiego
 */
public interface UsuarioRepository /*extends GenericDao*/ {


    public void guardar(Usuario usuario)throws RepositoryException;
    public void actualizar(Usuario usuario)throws RepositoryException;
    public Usuario cargar(String login)throws RepositoryException;

    public static class Impl{
        public static UsuarioRepository getInstance(){
            return (UsuarioRepository)BeanContainer.getBean(UsuarioRepository.class);
        }
    }
}
