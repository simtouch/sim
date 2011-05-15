package org.sim.repository.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.sim.domain.Departamento;
import static org.sim.domain.Departamento.Orden;
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

    public List<Departamento> listar() throws RepositoryException {
        return listar(null);
    }

    public List<Departamento> listar(Orden ordenamiento) throws RepositoryException {
        try{
            DetachedCriteria dr = DetachedCriteria.forClass(Departamento.class);
            if(ordenamiento != null){
                switch(ordenamiento){
                    case CODIGO:
                        dr.addOrder(Order.asc("codigo"));
                        break;
                    case NOMBRE:
                        dr.addOrder(Order.asc("nombre"));
                        break;
                }
            }
            return getHibernateTemplate().findByCriteria(dr);
        }catch(DataAccessException ex){
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
            throw new RepositoryException("Excepción listando Departamentos");
        }
    }

    

}
