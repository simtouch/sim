
package org.sim.repository;

import java.io.Serializable;
import java.util.List;
import org.sim.domain.Departamento;
import static org.sim.domain.Departamento.Orden;
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
    public Departamento cargar(Serializable codigo) throws RepositoryException;
    public List<Departamento> listar() throws RepositoryException;
    public List<Departamento> listar(Orden orden) throws RepositoryException;

    public static class Impl{
        public static DepartamentoRepository getInstance(){
            return (DepartamentoRepository)BeanContainer.getBean(DepartamentoRepository.class);
        }
    }
}
