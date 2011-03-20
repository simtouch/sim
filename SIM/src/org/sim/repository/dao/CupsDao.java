package org.sim.repository.dao;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.sim.domain.Cups;
import org.sim.repository.CupsRepository;
import org.sim.util.exceptions.RepositoryException;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Franky Villadiego
 */
//@Repository
public class CupsDao extends GenericDaoImpl implements CupsRepository{

    private static final Logger log = Logger.getLogger(CupsDao.class.getName());

    @Transactional
    public void guardar(Cups cups) throws RepositoryException {
        try{
            insert(cups);
        }catch(DataAccessException ex){
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
        }
    }

    @Transactional
    public void actualizar(Cups cups) throws RepositoryException {
        try{
            update(cups);
        }catch(DataAccessException ex){
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
        }
    }

    @Transactional(readOnly=true)
    public Cups cargar(String codigo) throws RepositoryException {
        Cups cups=null;
        try{
            cups = getById(Cups.class, codigo);
        }catch(DataAccessException ex){
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
        }
        return cups;
    }

    @Transactional
    public void guardarOrActualizar(Cups cups) throws RepositoryException {
        try{
            saveOrUpdate(cups);
        }catch(DataAccessException ex){
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
        }
    }

    

}
