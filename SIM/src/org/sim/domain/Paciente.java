/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sim.domain;

import org.sim.repository.PacienteRepository;
import org.sim.util.exceptions.BusinessException;
import org.sim.util.exceptions.RepositoryException;

/**
 *
 * @author Franky Villadiego
 */
public class Paciente {

    PacienteRepository pacienteRepository = PacienteRepository.Impl.getInstance();


    private int cedula;
    private String nombre;
    private String apellido;

    public Paciente(int cedula, String nombre, String apellido) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Paciente() {}


    /* Getters y Setters */

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    /* Metodos basicos */

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Paciente other = (Paciente) obj;
        if (this.cedula != other.cedula) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.cedula;
        return hash;
    }


    /* Metodos de negocio */

    public void guardar() throws RepositoryException, BusinessException{
        // Reglas de negocio antes de guardar
        pacienteRepository.guardar(this);
    }

    public void actualizar() throws RepositoryException, BusinessException{
        // Reglas de negocio antes de actualizar
        pacienteRepository.actualizar(this);
    }

    public void eliminar() throws RepositoryException, BusinessException{
        // Reglas de negocio antes de eliminar
        pacienteRepository.eliminar(this);
    }



}
