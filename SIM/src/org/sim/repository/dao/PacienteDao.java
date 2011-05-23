package org.sim.repository.dao;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.sim.domain.Paciente;
import org.sim.repository.PacienteRepository;
import org.sim.util.exceptions.RepositoryException;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Franky Villadiego
 */
//@Repository
public class PacienteDao extends GenericDaoImpl implements PacienteRepository{

    private static final Logger log = Logger.getLogger(PacienteDao.class.getName());

    @Transactional
    public void guardar(Paciente paciente) throws RepositoryException {
        try{
            insert(paciente);
        }catch(DataAccessException ex){
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
        }
    }

    @Transactional
    public void actualizar(Paciente paciente) throws RepositoryException {
        try{
            update(paciente);
        }catch(DataAccessException ex){
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
        }
    }

    @Transactional
    public void eliminar(Paciente paciente) throws RepositoryException {
        try{
            eliminar(paciente);
        }catch(DataAccessException ex){
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
        }
    }

    @Transactional(readOnly=true)
    public Paciente cargar(Serializable codigo) throws RepositoryException {
        Paciente paciente=null;
        try{
            paciente = getById(Paciente.class, codigo);
        }catch(DataAccessException ex){
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
        }
        return paciente;
    }

    @Transactional
    public void guardarOrActualizar(Paciente paciente) throws RepositoryException {
        try{
            saveOrUpdate(paciente);
        }catch(DataAccessException ex){
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
        }
    }

    public List<Paciente> listarPacientes() throws RepositoryException {
        return listar(null);
    }

    public List<Paciente> listar(Paciente.Orden ordenamiento) throws RepositoryException {
        try{
            DetachedCriteria dr = DetachedCriteria.forClass(Paciente.class);
            if(ordenamiento != null){
                switch(ordenamiento){
                    case CODIGO:
                        dr.addOrder(Order.asc("codigo"));
                        break;
                    case APELLIDO:
                        dr.addOrder(Order.asc("nombre"));
                        break;
                }
            }
            return getHibernateTemplate().findByCriteria(dr);
        }catch(DataAccessException ex){
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
            throw new RepositoryException("Excepción listando Pacientes");
        }
    }

    

}
