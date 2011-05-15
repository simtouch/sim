package org.sim.repository.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.sim.domain.Departamento;
import org.sim.domain.Municipio;
import static org.sim.domain.Municipio.Orden;
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

    public List<Municipio> listarPorDepartamento(Departamento departamento) throws RepositoryException {
        return listarPorDepartamento(departamento, null);
    }

    public List<Municipio> listarPorDepartamento(Departamento departamento, Orden orden) throws RepositoryException {
        if(departamento == null){
            throw new RepositoryException("El Departamento debe ser un objeto valido");
        }
        List<Municipio> lst = null;

        try{
            DetachedCriteria criteria = DetachedCriteria.forClass(Municipio.class);
            if(orden != null){
                switch(orden){
                    case CODIGO:
                        criteria.addOrder(Order.asc("identificador"));
                        break;
                    case NOMBRE:
                        criteria.addOrder(Order.asc("nombre"));
                        break;
                }
            }
            criteria.add(Restrictions.like("identificador.codigoDepartamento", departamento.getCodigo()));
            lst = getHibernateTemplate().findByCriteria(criteria);
        }catch(DataAccessException ex){
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
            throw new RepositoryException("Error al listar los municipios por departamento");
        }

        return lst;
    }
    

}
