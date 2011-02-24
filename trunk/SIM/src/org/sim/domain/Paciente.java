/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sim.domain;

import org.sim.repository.PacienteRepository;
import org.sim.util.exceptions.BusinessException;
import org.sim.util.exceptions.ObjectNotFoundException;
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

    public Paciente() {
    }

    public Paciente(int cedula) throws BusinessException {
        if (cedula <= 0) {
            throw new BusinessException("La cedula para cargar el Paciente debe ser un dato válido");
        }
        Paciente p = pacienteRepository.cargar(cedula);
        if (p == null) {
            this.cedula = cedula;
            throw new ObjectNotFoundException("El paciente con cedula " + cedula + " no existe");
        }
        this.cedula = p.getCedula();
        this.apellido = p.getApellido();
        this.nombre = p.getNombre();
    }
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


}
