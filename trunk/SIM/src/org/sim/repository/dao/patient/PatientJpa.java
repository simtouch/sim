
package org.sim.repository.dao.patient;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.sim.domain.Paciente;

/**
 *
 * @author Franky Villadiego
 */
@Entity
@Table(name="patients")
public class PatientJpa implements Serializable{

    @Id
    //@SequenceGenerator(name="secuencia",sequenceName="patients_seq",allocationSize=1)
    //@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="secuencia")
    private int cedula;

    private String name;

    private String apellido;

        
    public PatientJpa() {
        // Llenar el Domain Model

    }

    public PatientJpa(Paciente paciente) {
        this.name = paciente.getNombre();
        this.apellido = paciente.getApellido();
        this.cedula = paciente.getCedula();
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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



    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PatientJpa other = (PatientJpa) obj;
        if (this.cedula != other.cedula) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.cedula;
        return hash;
    }


   public Paciente getPaciente(){
       Paciente p = new Paciente();
       p.setNombre(this.name);
       p.setApellido(this.apellido);
       p.setCedula(this.cedula);
       return p;
   }

   public void setPaciente(Paciente paciente){
       this.setName(paciente.getNombre());
       this.setApellido(paciente.getApellido());
   }


}
