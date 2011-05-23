/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sim.repository;

import java.io.Serializable;
import org.sim.domain.Medicamento;
import org.sim.util.BeanContainer;
import org.sim.util.exceptions.RepositoryException;

/**
 *
 * @author Franky Villadiego
 */
public interface MedicamentoRepository /*extends GenericDao*/ {


    public void guardar(Medicamento medicamentos)throws RepositoryException;
    public void actualizar(Medicamento medicamentos)throws RepositoryException;
    public void guardarOrActualizar(Medicamento medicamentos)throws RepositoryException;
    public Medicamento cargar(Serializable codigo)throws RepositoryException;

    public static class Impl{
        public static MedicamentoRepository getInstance(){
            return (MedicamentoRepository)BeanContainer.getBean(MedicamentoRepository.class);
        }
    }
}
