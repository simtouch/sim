package org.sim.repository.dao;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.sim.domain.Departamento;
import org.sim.repository.DepartamentoRepository;
import org.sim.util.exceptions.RepositoryException;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Franky Villadiego
 */
//@Repository
public class DepartamentoDao extends GenericDaoImpl implements DepartamentoRepository{

    private static final Logger log = Logger.getLogger(DepartamentoDao.class.getName());

    @Transactional
    public void guardar(Departamento departamento) throws RepositoryException {
        try{
            insert(departamento);
        }catch(DataAccessException ex){
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
        }
    }

    @Transactional
    public void actualizar(Departamento departamento) throws RepositoryException {
        try{
            update(departamento);
        }catch(DataAccessException ex){
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
        }
    }

    @Transactional(readOnly=true)
    public Departamento cargar(String codigo) throws RepositoryException {
        Departamento departamento=null;
        try{
            departamento = getById(Departamento.class, codigo);
        }catch(DataAccessException ex){
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
        }
        return departamento;
    }

    @Transactional
    public void guardarOrActualizar(Departamento departamento) throws RepositoryException {
        try{
            saveOrUpdate(departamento);
        }catch(DataAccessException ex){
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
        }
    }

    

}
