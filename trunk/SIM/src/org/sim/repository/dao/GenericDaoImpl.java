
package org.sim.repository.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 *
 * @author Franky Villadiego
 */
public abstract class GenericDaoImpl implements GenericDao{

    private static final Logger log=Logger.getLogger(GenericDaoImpl.class.getName());
    private HibernateTemplate hibernateTemplate;

    public GenericDaoImpl() {
    }


    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }


    public <T> void insert(T entity) throws DataAccessException{
        getHibernateTemplate().save(entity);
    }

    public <T> void delete(T entity) throws DataAccessException {
        getHibernateTemplate().delete(entity);
    }

    public <T> void update(T entity) throws DataAccessException {
        getHibernateTemplate().update(entity);
    }

    public <T> void saveOrUpdate(T entity) throws DataAccessException {
        getHibernateTemplate().saveOrUpdate(entity);
    }

    public <T> List<T> listAll(Class<T> entityClass) throws DataAccessException {
        List<T> lst=null;
        lst = getHibernateTemplate().loadAll(entityClass);
	return lst;
    }


    public <T> T getById(Class<T> entityClass, Serializable id) throws DataAccessException {
        T o = (T) getHibernateTemplate().get(entityClass, id);
        return o;
    }

    public int executeSqlQuery(final String query) throws DataAccessException{
        //TODO: Capturar HibernateException y SQLException para lanzar el DataAccessException adecuado
        Integer registrosAfectados=(Integer) getHibernateTemplate().execute(new HibernateCallback() {
            public Integer doInHibernate(Session sn) throws HibernateException, SQLException {
                SQLQuery sqlQ=sn.createSQLQuery(query);
                int rowsAfectadas=sqlQ.executeUpdate();
                if(rowsAfectadas==0){
                    log.log(Level.INFO, "La consulta [{0}] no afecto ningun registro", query);
                }
                return new Integer(rowsAfectadas);
            }
        });
        if(registrosAfectados==null){
            return 0;
        }else{
            return registrosAfectados.intValue();
        }
    }

    public <T> Integer countRecords(Class<T> clazz) throws DataAccessException {
        Integer can=0;
        List lst=null;
        DetachedCriteria cr=DetachedCriteria.forClass(clazz);
        cr.setProjection(Projections.rowCount());
        lst=getHibernateTemplate().findByCriteria(cr);
        if(lst==null || lst.isEmpty()){
            return 0;
        }else{
            can=Integer.valueOf(lst.get(0).toString());
        }
        return can;
    }

    public <T> Integer countRecords(Class<T> clazz, Map criterios) throws DataAccessException {
        Integer can=0;
        List lst=null;

        DetachedCriteria cr=DetachedCriteria.forClass(clazz);
        cr.setProjection(Projections.rowCount());
        Iterator it=criterios.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry entry=(Map.Entry)it.next();
            if(entry.getValue()!=null && !entry.getValue().toString().isEmpty()){
                cr.add(Restrictions.like(entry.getKey().toString(), entry.getValue()));
            }
        }
        lst=getHibernateTemplate().findByCriteria(cr);
        if(lst==null || lst.isEmpty()){
            return 0;
        }else{
            can=Integer.valueOf(lst.get(0).toString());
        }
        return can;
    }

    public <T> List<T> findByCriteria(Class<T> clazz, Map criterios, int fila, int pagina) throws DataAccessException{
        List<T> lst=null;

        DetachedCriteria cr=DetachedCriteria.forClass(clazz);
        Iterator it=criterios.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry entry=(Map.Entry)it.next();
            if(entry.getValue()!=null && !entry.getValue().toString().isEmpty()){
                cr.add(Restrictions.like(entry.getKey().toString(), entry.getValue().toString(),MatchMode.ANYWHERE));
            }
        }
        lst = getHibernateTemplate().findByCriteria(cr,fila,pagina);

	return lst;
    }

    public MatchMode getMatchMode(int matchType){
            MatchMode coincide=null;
            if(matchType<=1 || matchType>4){
                coincide=MatchMode.EXACT;
            }else if(matchType==2){
                coincide=MatchMode.START;
            }else if(matchType==3){
                coincide=MatchMode.ANYWHERE;
            }else if(matchType==4){
                coincide=MatchMode.END;
            }
            return coincide;
    }

    public <T> T load(Class<T> clazz, Map criterios) throws DataAccessException {
        List<T> lst=null;

        DetachedCriteria cr=DetachedCriteria.forClass(clazz);
        Iterator it=criterios.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry entry=(Map.Entry)it.next();
            if(entry.getValue()!=null && !entry.getValue().toString().isEmpty()){
                cr.add(Restrictions.like(entry.getKey().toString(), entry.getValue().toString(),MatchMode.ANYWHERE));
            }
        }
        lst = getHibernateTemplate().findByCriteria(cr);

        if(lst!=null && lst.size()==1){
            return lst.get(0);
        }else{
            return null;
        }

    }


}
