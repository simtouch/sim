package org.sim.repository.dao;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.sim.domain.Entidad;
import org.sim.repository.EntidadRepository;
import org.sim.repository.dao.GenericDaoImpl;
import org.sim.util.exceptions.RepositoryException;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Franky Villadiego
 */
//@Repository
public class EntidadDao extends GenericDaoImpl implements EntidadRepository{

    private static final Logger log = Logger.getLogger(EntidadDao.class.getName());

    @Transactional
    public void guardar(Entidad entidad) throws RepositoryException {
        try{
            insert(entidad);
        }catch(DataAccessException ex){
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
        }
    }

    @Transactional
    public void actualizar(Entidad entidad) throws RepositoryException {
        try{
            update(entidad);
        }catch(DataAccessException ex){
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
        }
    }

    @Transactional(readOnly=true)
    public Entidad cargar(String codigo) throws RepositoryException {
        Entidad entidad=null;
        try{
            entidad = getById(Entidad.class, codigo);
        }catch(DataAccessException ex){
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
        }
        return entidad;
    }

    

}
