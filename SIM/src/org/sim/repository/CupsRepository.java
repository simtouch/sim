/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sim.repository;

import org.sim.domain.Cups;
import org.sim.util.BeanContainer;
import org.sim.util.exceptions.RepositoryException;

/**
 *
 * @author Franky Villadiego
 */
public interface CupsRepository /*extends GenericDao*/ {


    public void guardar(Cups cups)throws RepositoryException;
    public void actualizar(Cups cups)throws RepositoryException;
    public void guardarOrActualizar(Cups cups)throws RepositoryException;
    public Cups cargar(String codigo)throws RepositoryException;

    public static class Impl{
        public static CupsRepository getInstance(){
            return (CupsRepository)BeanContainer.getBean(CupsRepository.class);
        }
    }
}
