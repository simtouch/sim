/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sim.repository;

import java.util.List;
import org.sim.domain.Paciente;
import org.sim.util.BeanContainer;
import org.sim.util.exceptions.RepositoryException;

/**
 *
 * @author Franky Villadiego
 */
public interface PacienteRepository {


    public void guardar(Paciente paciente) throws RepositoryException;

    public void actualizar(Paciente paciente) throws RepositoryException;

    public void eliminar(Paciente paciente) throws RepositoryException;

    public List<Paciente> listarPacientes() throws RepositoryException;

    public static class Impl{
        public static PacienteRepository getInstance(){
            return (PacienteRepository)BeanContainer.getBean(PacienteRepository.class);
        }
    }
}
