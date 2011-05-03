
package org.sim.repository;

import org.sim.domain.Municipio;
import org.sim.util.BeanContainer;
import org.sim.util.exceptions.RepositoryException;

/**
 *
 * @author Franky Villadiego
 */
public interface MunicipioRepository /*extends GenericDao*/ {


    public void guardar(Municipio municipio)throws RepositoryException;
    public void actualizar(Municipio municipio)throws RepositoryException;
    public void guardarOrActualizar(Municipio municipio)throws RepositoryException;
    public Municipio cargar(String codigo)throws RepositoryException;

    public static class Impl{
        public static MunicipioRepository getInstance(){
            return (MunicipioRepository)BeanContainer.getBean(MunicipioRepository.class);
        }
    }
}
