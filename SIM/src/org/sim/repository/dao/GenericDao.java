
package org.sim.repository.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.hibernate.criterion.MatchMode;
import org.springframework.dao.DataAccessException;

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
    public <T> void insert(T entity) throws DataAccessException;

    /**
     * Permite eliminar la Entidad.
     * 
     * @param <T>
     * @param entity
     * @throws DaoLayerException
     */
    public <T> void delete(T entity) throws DataAccessException;

    /**
     * Permite actualizar la Entidad.
     * @param <T>
     * @param entity
     * @throws DaoLayerException
     */
    public <T> void update(T entity) throws DataAccessException;

    /**
     * Permite guardar o actualizar dependiendo el estado del objeto.
     * @param <T>
     * @param entity
     * @throws DataAccessException
     */
    public <T> void saveOrUpdate(T entity) throws DataAccessException;

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
    public <T> List<T> listAll(Class<T> entityClass) throws DataAccessException;

    /**
     * Carga una Entidad por su ID.
     * 
     * @param <T>
     * @param entityClass
     * @param id
     * @return
     * @throws DaoLayerException
     */
    public <T> T getById(Class<T> entityClass, Serializable id) throws DataAccessException;

    /**
     * <p>Permite ejecutar una consulta en SQL natural (UPDATE, DELETE).
     * 
     * @param query
     * @return La cantidad de registros afectados.
     * @throws DaoLayerException
     */
    public int executeSqlQuery(final String query) throws DataAccessException;

    /**
     * <p>Devuelve el total de registros que existen para una determinada clase de modelo.
     * <p>Util para implementar la paginacion por demanda en las busquedas.
     *  
     * @param clazz
     * @return cantidad de registros
     * @throws DaoLayerException
     */
    public <T> Integer countRecords(Class<T> clazz) throws DataAccessException;

    /**
     * Retorna el total de registros de una clase modelo segun unos criterios.
     * 
     * @param <T>
     * @param clazz
     * @param criterios
     * @return
     * @throws DaoLayerException
     */
    public <T> Integer countRecords(Class<T> clazz, Map criterios) throws DataAccessException;

    /**
     * Realiza una busqueda de una clase modelo segun unos criterios especificados en el mapa.
     * 
     * @param <T>
     * @param clazz
     * @param criterios
     * @param fila
     * @param pagina
     * @return
     * @throws DaoLayerException
     */
    public <T> List<T> findByCriteria(Class<T> clazz, Map criterios, int fila, int pagina) throws DataAccessException;

    /**
     * Realiza una busqueda por un mapa de criterios, los criterios en el mapa son
     * los nombres de Propiedad(key) y valor
     * 
     * @param <T>
     * @param clazz
     * @param criterios
     * @return
     * @throws DataAccessException
     */
    public <T> List<T> findByCriteria(Class<T> clazz, Map criterios) throws DataAccessException;

    /**
     * Retorna el tipo de coincidencia para la generacion de criterios
     * 
     * @param matchType
     * @return
     */
    public MatchMode getMatchMode(int matchType);
}
