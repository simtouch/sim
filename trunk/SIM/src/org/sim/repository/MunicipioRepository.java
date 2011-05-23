
package org.sim.repository;

import java.io.Serializable;
import java.util.List;
import org.sim.domain.Departamento;
import org.sim.domain.Municipio;
import static org.sim.domain.Municipio.Orden;
import org.sim.util.BeanContainer;
import org.sim.util.exceptions.RepositoryException;

/**
 *
 * @author Franky Villadiego
 */
public interface MunicipioRepository /*extends GenericDao*/ {


    public void guardar(Municipio municipio) throws RepositoryException;
    public void actualizar(Municipio municipio) throws RepositoryException;
    public void guardarOrActualizar(Municipio municipio) throws RepositoryException;
    public Municipio cargar(Serializable codigo) throws RepositoryException;
    public List<Municipio> listarPorDepartamento(Departamento departamento) throws RepositoryException;
    public List<Municipio> listarPorDepartamento(Departamento departamento, Orden orden) throws RepositoryException;

    public static class Impl{
        public static MunicipioRepository getInstance(){
            return (MunicipioRepository)BeanContainer.getBean(MunicipioRepository.class);
        }
    }
}
