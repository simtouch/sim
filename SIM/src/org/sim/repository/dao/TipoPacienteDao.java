package org.sim.repository.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sim.domain.TipoPaciente;
import org.sim.repository.TipoPacienteRepository;
import org.sim.util.exceptions.RepositoryException;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Franky Villadiego
 */
//@Repository
public class TipoPacienteDao extends GenericDaoImpl implements TipoPacienteRepository{

    private static final Logger log = Logger.getLogger(TipoPacienteDao.class.getName());

    @Transactional(readOnly=true)
    public TipoPaciente cargar(Serializable codigo) throws RepositoryException {
        TipoPaciente tipoPaciente = null;
        try{
            tipoPaciente = getById(TipoPaciente.class, codigo);
        }catch(DataAccessException ex){
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
        }
        return tipoPaciente;
    }

    public List<TipoPaciente> listar() throws RepositoryException {

        List<TipoPaciente> lst=null;

        try{
            lst = listAll(TipoPaciente.class);
        }catch(DataAccessException ex){
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
        }
        if(lst==null){
            return new ArrayList<TipoPaciente>();
        }else{
            return lst;
        }
    }

       

}
