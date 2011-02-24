package org.sim.repository.dao.patient;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sim.domain.Paciente;
import org.sim.repository.PacienteRepository;
import org.sim.repository.dao.GenericDaoImpl;
import org.sim.util.exceptions.RepositoryException;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Franky Villadiego
 */
//@Repository
public class PacienteDao extends GenericDaoImpl implements PacienteRepository {

    private static final Logger log = Logger.getLogger(PacienteDao.class.getName());

    @Transactional
    public void guardar(Paciente paciente) throws RepositoryException {
        if (paciente == null) {
            throw new RepositoryException("El paciente no se puede ser null");
        }
        PatientJpa patientJpa = new PatientJpa(paciente);
        try {
            super.insert(patientJpa);
        } catch (DataAccessException ex) {
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
            throw new RepositoryException(ex);
        }
    }

    @Transactional
    public void actualizar(Paciente paciente) throws RepositoryException {
        if (paciente == null) {
            throw new RepositoryException("El paciente no se puede ser null");
        }
        try {
            PatientJpa patientJpa = getById(PatientJpa.class, paciente.getCedula());
            if (patientJpa == null) {
                throw new RepositoryException("El paciente con cedula " + paciente.getCedula() + " no se puede encontrar para actualizar");
            }
            patientJpa.setPaciente(paciente);
            super.update(patientJpa);
        } catch (DataAccessException ex) {
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
            throw new RepositoryException(ex);
        }
    }

    @Transactional
    public void eliminar(Paciente paciente) throws RepositoryException {
        if (paciente == null) {
            throw new RepositoryException("El paciente no se puede ser null");
        }
        try {
            PatientJpa patientJpa = getById(PatientJpa.class, paciente.getCedula());
            if (patientJpa == null) {
                throw new RepositoryException("El paciente con cedula " + paciente.getCedula() + " no se puede encontrar para eliminar");
            }
            patientJpa.setPaciente(paciente);
            super.delete(patientJpa);
        } catch (DataAccessException ex) {
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
            throw new RepositoryException(ex);
        }
    }

    @Transactional(readOnly = true)
    public List<Paciente> listarPacientes() throws RepositoryException {
        List<PatientJpa> lst = null;
        List<Paciente> lstPacientes = new ArrayList<Paciente>();
        try {
            lst = listAll(PatientJpa.class);
        } catch (DataAccessException ex) {
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
            throw new RepositoryException(ex);
        }
        for (PatientJpa p : lst) {
            lstPacientes.add(p.getPaciente());
        }
        return lstPacientes;
    }

    @Transactional(readOnly = true)
    public Paciente cargar(int cedula) throws RepositoryException {
        try {
            PatientJpa patientJpa = getById(PatientJpa.class, cedula);
            Paciente paciente = patientJpa.getPaciente();
            return paciente;
        } catch (DataAccessException ex) {
            log.log(Level.WARNING, ex.getClass().getName() + "={0}", ex.getMessage());
            throw new RepositoryException(ex);
        }
    }
}
