/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sim.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.sim.repository.CupsRepository;
import org.sim.util.exceptions.BusinessException;
import org.sim.util.exceptions.RepositoryException;

/**
 *
 * @author Franky Villadiego
 * @author Lerkis Causado Epitia
 */
@Entity
@Table(name = "cups")
public class Cups implements Serializable {

    public static final String ACTIVO = "A";
    public static final String INACTIVO = "I";
    

    /* Atributos de la Entidad */

    @Id
    @Column(name = "codigo_cups")
    private String codigo;
    
    @Column(name = "nombre_cups")
    private String nombre;
    
    //@Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private String estado = ACTIVO;

    @Column(name="codigo_tipo_especialidad")
    private String especialidad="VAR";

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
       
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }


    public void guardar() throws RepositoryException, BusinessException{
        if (validar()) {
            CupsRepository.Impl.getInstance().guardarOrActualizar(this);
        }
    }

    public void actualizar() throws RepositoryException, BusinessException{
        // TODO: pendiente por revisar implementar cambiado por guardaractualizar
    }

    public boolean validar() {
        if (codigo == null) {
            return false;
        }
        return true;
    }

    public static Cups cargar(String codigo) {
        Cups cups = CupsRepository.Impl.getInstance().cargar(codigo);
        return cups;
    }
}
