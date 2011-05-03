package org.sim.repository.dao;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.sim.domain.Municipio;
import org.sim.repository.MunicipioRepository;
import org.sim.util.exceptions.RepositoryException;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Franky Villadiego
 */
//@Repository
public class MunicipioDao extends GenericDaoImpl implements MunicipioRepository{

    private static final Logger log = Logger.getLogger(MunicipioDao.class.getName());

    @Transactional
    public void guardar(Municipio municipio) throws RepositoryException {
        try{
            insert(municipio);
        }catch(DataAccessException ex){
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
        }
    }

    @Transactional
    public void actualizar(Municipio municipio) throws RepositoryException {
        try{
            update(municipio);
        }catch(DataAccessException ex){
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
        }
    }

    @Transactional(readOnly=true)
    public Municipio cargar(String codigo) throws RepositoryException {
        Municipio municipio=null;
        try{
            municipio = getById(Municipio.class, codigo);
        }catch(DataAccessException ex){
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
        }
        return municipio;
    }

    @Transactional
    public void guardarOrActualizar(Municipio municipio) throws RepositoryException {
        try{
            saveOrUpdate(municipio);
        }catch(DataAccessException ex){
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
        }
    }

    

}
