/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sim.repository;

import java.io.Serializable;
import org.sim.domain.Cups;
import org.sim.domain.Diagnostico;
import org.sim.util.BeanContainer;
import org.sim.util.exceptions.RepositoryException;

/**
 *
 * @author Franky Villadiego
 * @author Lerkis Causado
 */
public interface DiagnosticoRepository /*extends GenericDao*/ {


    public void guardar(Diagnostico diagnostico)throws RepositoryException;
    public void actualizar(Diagnostico diagnostico)throws RepositoryException;
    public void guardarOrActualizar(Diagnostico diagnostico)throws RepositoryException;
    public Diagnostico cargar(Serializable codigo)throws RepositoryException;

    public static class Impl{
        public static DiagnosticoRepository getInstance(){
            return (DiagnosticoRepository)BeanContainer.getBean(DiagnosticoRepository.class);
        }
    }
}
