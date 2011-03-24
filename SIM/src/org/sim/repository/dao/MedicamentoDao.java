package org.sim.repository.dao;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.sim.domain.Medicamento;
import org.sim.repository.MedicamentoRepository;
import org.sim.util.exceptions.RepositoryException;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Franky Villadiego
 */
//@Repository
public class MedicamentoDao extends GenericDaoImpl implements MedicamentoRepository{

    private static final Logger log = Logger.getLogger(MedicamentoDao.class.getName());

    @Transactional
    public void guardar(Medicamento medicamentos) throws RepositoryException {
        try{
            insert(medicamentos);
        }catch(DataAccessException ex){
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
        }
    }

    @Transactional
    public void actualizar(Medicamento medicamentos) throws RepositoryException {
        try{
            update(medicamentos);
        }catch(DataAccessException ex){
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
        }
    }

    @Transactional(readOnly=true)
    public Medicamento cargar(String codigo) throws RepositoryException {
        Medicamento medicamentos=null;
        try{
            medicamentos = getById(Medicamento.class, codigo);
        }catch(DataAccessException ex){
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
        }
        return medicamentos;
    }

    @Transactional
    public void guardarOrActualizar(Medicamento medicamentos) throws RepositoryException {
        try{
            saveOrUpdate(medicamentos);
        }catch(DataAccessException ex){
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
        }
    }

    

}
