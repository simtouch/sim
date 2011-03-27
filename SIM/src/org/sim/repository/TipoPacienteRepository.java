/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sim.repository;

import java.util.List;
import org.sim.domain.TipoIdentificacion;
import org.sim.domain.TipoPaciente;
import org.sim.util.BeanContainer;
import org.sim.util.exceptions.RepositoryException;

/**
 *
 * @author Franky Villadiego
 */
public interface TipoPacienteRepository /*extends GenericDao*/ {


    public TipoPaciente cargar(String codigo)throws RepositoryException;
    public List<TipoPaciente> listar()throws RepositoryException;

    public static class Impl{
        public static TipoPacienteRepository getInstance(){
            return (TipoPacienteRepository)BeanContainer.getBean(TipoPacienteRepository.class);
        }
    }
}
