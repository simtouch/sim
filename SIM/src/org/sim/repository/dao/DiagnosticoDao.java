package org.sim.repository.dao;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sim.domain.Cups;
import org.sim.domain.Diagnostico;
import org.sim.repository.DiagnosticoRepository;
import org.sim.util.exceptions.RepositoryException;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Franky Villadiego
 */
//@Repository
public class DiagnosticoDao extends GenericDaoImpl implements DiagnosticoRepository{

    private static final Logger log = Logger.getLogger(DiagnosticoDao.class.getName());

    @Transactional
    public void guardar(Diagnostico diagnostico) throws RepositoryException {
        try{
            insert(diagnostico);
        }catch(DataAccessException ex){
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
        }
    }

    @Transactional
    public void actualizar(Diagnostico diagnostico) throws RepositoryException {
        try{
            update(diagnostico);
        }catch(DataAccessException ex){
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
        }
    }

    @Transactional(readOnly=true)
    public Diagnostico cargar(Serializable codigo) throws RepositoryException {
        Diagnostico diagnostico=null;
        try{
            diagnostico = getById(Diagnostico.class, codigo);
        }catch(DataAccessException ex){
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
        }
        return diagnostico;
    }

    @Transactional
    public void guardarOrActualizar(Diagnostico diagnostico) throws RepositoryException {
        try{
            saveOrUpdate(diagnostico);
        }catch(DataAccessException ex){
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
        }
    }

    

}
