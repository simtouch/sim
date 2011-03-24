package org.sim.repository.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sim.domain.Cups;
import org.sim.domain.TipoIdentificacion;
import org.sim.repository.TipoIdentificacionRepository;
import org.sim.util.exceptions.RepositoryException;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Franky Villadiego
 */
//@Repository
public class TipoIdentificacionDao extends GenericDaoImpl implements TipoIdentificacionRepository{

    private static final Logger log = Logger.getLogger(TipoIdentificacionDao.class.getName());

    @Transactional(readOnly=true)
    public TipoIdentificacion cargar(String codigo) throws RepositoryException {
        TipoIdentificacion tipoidentificacion=null;
        try{
            tipoidentificacion = getById(TipoIdentificacion.class, codigo);
        }catch(DataAccessException ex){
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
        }
        return tipoidentificacion;
    }

    public List<TipoIdentificacion> listar() throws RepositoryException {

        List<TipoIdentificacion> lst=null;

        try{
            lst = listAll(TipoIdentificacion.class);
        }catch(DataAccessException ex){
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
        }
        if(lst==null){
            return new ArrayList<TipoIdentificacion>();
        }else{
            return lst;
        }
    }

       

}
