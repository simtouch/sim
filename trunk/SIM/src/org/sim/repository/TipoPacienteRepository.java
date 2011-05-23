

package org.sim.repository;

import java.io.Serializable;
import java.util.List;
import org.sim.domain.TipoPaciente;
import org.sim.util.BeanContainer;
import org.sim.util.exceptions.RepositoryException;

/**
 *
 * @author Franky Villadiego
 */
public interface TipoPacienteRepository /*extends GenericDao*/ {


    public TipoPaciente cargar(Serializable codigo)throws RepositoryException;
    public List<TipoPaciente> listar()throws RepositoryException;

    public static class Impl{
        public static TipoPacienteRepository getInstance(){
            return (TipoPacienteRepository)BeanContainer.getBean(TipoPacienteRepository.class);
        }
    }
}
