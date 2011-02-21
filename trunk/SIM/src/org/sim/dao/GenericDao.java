
package org.sim.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.hibernate.criterion.MatchMode;
import org.sim.util.exceptions.DaoLayerException;

/**
 *
 * @author Franky Villadiego
 */
public interface GenericDao{

    /**
     * Permite guardar la Entidad.
     * 
     * @param <T>
     * @param entity
     * @throws DaoLayerException
     */
    public <T> void insert(T entity) throws DaoLayerException;

    /**
     * Permite eliminar la Entidad.
     * 
     * @param <T>
     * @param entity
     * @throws DaoLayerException
     */
    public <T> void delete(T entity) throws DaoLayerException;

    /**
     * Permite actualizar la Entidad.
     * @param <T>
     * @param entity
     * @throws DaoLayerException
     */
    public <T> void update(T entity) throws DaoLayerException;

    /**
     * <p>Permite traer todos los registros del tipo de Entidad en el parametro.
     * <p>No se recomienda este metodo para traer grandes cantidades de registro ya
     * que degrada el rendimiento.
     * 
     * @param <T>
     * @param entityClass
     * @return
     * @throws DaoLayerException
     */
    public <T> List<T> listAll(Class<T> entityClass) throws DaoLayerException;

    /**
     * Carga una Entidad por su ID.
     * 
     * @param <T>
     * @param entityClass
     * @param id
     * @return
     * @throws DaoLayerException
     */
    public <T> T getById(Class<T> entityClass, Serializable id) throws DaoLayerException;

    /**
     * <p>Permite ejecutar una consulta en SQL natural (UPDATE, DELETE).
     * 
     * @param query
     * @return La cantidad de registros afectados.
     * @throws DaoLayerException
     */
    public int executeSqlQuery(final String query) throws DaoLayerException;

    /**
     * <p>Devuelve el total de registros que existen para una determinada clase de modelo.
     * <p>Util para implementar la paginacion por demanda en las busquedas.
     *  
     * @param clazz
     * @return cantidad de registros
     * @throws DaoLayerException
     */
    public <T> Integer countRecords(Class<T> clazz) throws DaoLayerException;

    public <T> Integer countRecords(Class<T> clazz, Map criterios) throws DaoLayerException;

    public <T> List<T> findByCriteria(Class<T> clazz, Map criterios, int fila, int pagina) throws DaoLayerException;

    public MatchMode getMatchMode(int coincidencia);
}
