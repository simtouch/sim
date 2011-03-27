/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sim.repository;

import java.util.List;
import org.sim.domain.Entidad;
import org.sim.util.BeanContainer;
import org.sim.util.exceptions.RepositoryException;

/**
 *
 * @author Franky Villadiego
 */
public interface EntidadRepository /*extends GenericDao*/ {


    public void guardar(Entidad entidad)throws RepositoryException;
    public void actualizar(Entidad entidad)throws RepositoryException;
    public void guardarOrActualizar(Entidad entidad)throws RepositoryException;
    public Entidad cargar(String codigo)throws RepositoryException;
    public List<Entidad> listar(boolean soloActivas) throws RepositoryException;

    public static class Impl{
        public static EntidadRepository getInstance(){
            return (EntidadRepository)BeanContainer.getBean(EntidadRepository.class);
        }
    }
}
