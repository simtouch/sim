/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sim.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.sim.repository.TipoIdentificacionRepository;
import org.sim.repository.TipoPacienteRepository;

/**
 *
 * @author Franky Villadiego
 * @author Lerkis Causado Epitia
 */
@Entity
@Table(name = "tipo_usuario")
public class TipoPaciente implements Serializable {

    /* Atributos de la tipo de identificaicon */

    @Id
    @Column(name = "codigo_tipo_usuario")
    private String codigo;
    
    @Column(name = "nombre_tipo_usuario")
    private String nombre;
    
    //@Enumerated(EnumType.STRING)
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
   
       
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.codigo + " - " + this.nombre;
    }
    public static List<TipoPaciente> listar(){
        return TipoPacienteRepository.Impl.getInstance().listar();

    }
    public static TipoPaciente cargar(String codigo) {
        TipoPaciente tipoPaciente = TipoPacienteRepository.Impl.getInstance().cargar(codigo);
        return tipoPaciente;
    }
}
