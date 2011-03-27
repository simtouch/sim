/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sim.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import org.sim.repository.EntidadRepository;
import org.sim.util.exceptions.BusinessException;
import org.sim.util.exceptions.RepositoryException;

/**
 *
 * @author Franky Villadiego
 * @author Lerkis Causado Epitia
 */
@Entity
@Table(name = "entidades")
public class Entidad implements Serializable {

    public static final String ACTIVO = "A";
    public static final String INACTIVO = "I";
    private static transient EntidadRepository entidadRepository = EntidadRepository.Impl.getInstance();

    /* Atributos de la Entidad */

    @Id
    @Column(name = "codigo_entidad")
    private String codigo;
    @Column(name = "nombre_entidad")
    private String nombre;
    @Column(name = "nit_entidad")
    private String nit;
    //@Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private String estado = ACTIVO;

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

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }



    public void guardar() throws RepositoryException, BusinessException{
        if (validar()) {
            entidadRepository.guardarOrActualizar(this);
        }
    }

    public void actualizar() throws RepositoryException, BusinessException{
        entidadRepository.actualizar(this);
    }

    public boolean validar() {
        if (codigo == null) {
            return false;
        }
        return true;
    }

    public static Entidad cargar(String codigo) {
        Entidad entidad = entidadRepository.cargar(codigo);
        return entidad;
    }

    public static List<Entidad> listar(boolean soloActivas){
        List<Entidad> lst = EntidadRepository.Impl.getInstance().listar(true);
        return lst;
    }
}
