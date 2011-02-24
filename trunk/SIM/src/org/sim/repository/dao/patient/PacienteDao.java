
package org.sim.repository.dao.patient;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sim.domain.Paciente;
import org.sim.repository.PacienteRepository;
import org.sim.repository.dao.GenericDaoImpl;
import org.sim.util.exceptions.DaoException;
import org.sim.util.exceptions.RepositoryException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Franky Villadiego
 */
//@Repository
public class PacienteDao extends GenericDaoImpl implements PacienteRepository{

    private static final Logger log=Logger.getLogger(PacienteDao.class.getName());

    @Transactional
    public void guardar(Paciente paciente) throws RepositoryException {
        PatientJpa patientJpa = new PatientJpa(paciente);
        try{
            super.insert(patientJpa);
        }catch(DaoException ex){
            log.log(Level.WARNING, "DaoException={0}", ex.getMessage());
            throw new RepositoryException(ex);
        }
    }

    @Transactional
    public void actualizar(Paciente paciente) throws RepositoryException {

        try{
            PatientJpa patientJpa = getById(PatientJpa.class, paciente.getCedula());
            patientJpa.setPaciente(paciente);
            super.update(patientJpa);
        }catch(DaoException ex){
            log.log(Level.WARNING, "DaoException={0}", ex.getMessage());
            throw new RepositoryException(ex);
        }
    }

    @Transactional
    public void eliminar(Paciente paciente) throws RepositoryException {
        try{
            PatientJpa patientJpa = getById(PatientJpa.class, paciente.getCedula());
            patientJpa.setPaciente(paciente);
            super.delete(patientJpa);
        }catch(DaoException ex){
            log.log(Level.WARNING, "DaoException={0}", ex.getMessage());
            throw new RepositoryException(ex);
        }
    }

    @Transactional(readOnly=true)
    public List<Paciente> listarPacientes() throws RepositoryException {
        List<PatientJpa> lst=null;
        List<Paciente> lstPacientes=new ArrayList<Paciente>();
        try{
            lst=listAll(PatientJpa.class);
        }catch(DaoException ex){
            log.log(Level.WARNING, "DaoException={0}", ex.getMessage());
            throw new RepositoryException(ex);
        }
        for(PatientJpa p:lst){
            lstPacientes.add(p.getPaciente());
        }
        return lstPacientes;
    }



}
