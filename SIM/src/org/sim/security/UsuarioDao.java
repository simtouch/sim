package org.sim.security;

import org.sim.repository.dao.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sim.domain.Entidad;
import org.sim.repository.EntidadRepository;
import org.sim.repository.dao.GenericDaoImpl;
import org.sim.util.exceptions.RepositoryException;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Franky Villadiego
 */
//@Repository
public class UsuarioDao extends GenericDaoImpl implements UsuarioRepository {

    private static final Logger log = Logger.getLogger(UsuarioDao.class.getName());

    @Transactional
    public void guardar(Usuario usuario) throws RepositoryException {
        try {
            insert(usuario);
        } catch (DataAccessException ex) {
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
        }
    }

    @Transactional
    public void actualizar(Usuario usuario) throws RepositoryException {
        try {
            update(usuario);
        } catch (DataAccessException ex) {
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
        }
    }

    @Transactional(readOnly = true)
    public Usuario cargar(String login) throws RepositoryException {
        Usuario usuario = null;
        try {
            usuario = getById(Usuario.class, login);
        } catch (DataAccessException ex) {
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
        }
        return usuario;
    }
}
