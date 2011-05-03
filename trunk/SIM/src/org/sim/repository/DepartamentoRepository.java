
package org.sim.repository;

import org.sim.domain.Departamento;
import org.sim.util.BeanContainer;
import org.sim.util.exceptions.RepositoryException;

/**
 *
 * @author Franky Villadiego
 */
public interface DepartamentoRepository /*extends GenericDao*/ {


    public void guardar(Departamento departamento)throws RepositoryException;
    public void actualizar(Departamento departamento)throws RepositoryException;
    public void guardarOrActualizar(Departamento departamento)throws RepositoryException;
    public Departamento cargar(String codigo)throws RepositoryException;

    public static class Impl{
        public static DepartamentoRepository getInstance(){
            return (DepartamentoRepository)BeanContainer.getBean(DepartamentoRepository.class);
        }
    }
}
