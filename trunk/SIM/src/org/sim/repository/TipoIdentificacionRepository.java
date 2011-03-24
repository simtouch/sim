/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sim.repository;

import java.util.List;
import org.sim.domain.TipoIdentificacion;
import org.sim.util.BeanContainer;
import org.sim.util.exceptions.RepositoryException;

/**
 *
 * @author Franky Villadiego
 */
public interface TipoIdentificacionRepository /*extends GenericDao*/ {


    public TipoIdentificacion cargar(String codigo)throws RepositoryException;
    public List<TipoIdentificacion> listar()throws RepositoryException;

    public static class Impl{
        public static TipoIdentificacionRepository getInstance(){
            return (TipoIdentificacionRepository)BeanContainer.getBean(TipoIdentificacionRepository.class);
        }
    }
}
