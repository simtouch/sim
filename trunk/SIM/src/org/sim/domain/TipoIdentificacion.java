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

/**
 *
 * @author Franky Villadiego
 * @author Lerkis Causado Epitia
 */
@Entity
@Table(name = "tipo_identificacion")
public class TipoIdentificacion implements Serializable {

    /* Atributos de la tipo de identificaicon */

    @Id
    @Column(name = "codigo_tipo_identificacion")
    private String codigo;
    
    @Column(name = "nombre_tipo_identificacion")
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
        return this.codigo + "-" + this.nombre;
    }
    public static List<TipoIdentificacion> listar(){
        return TipoIdentificacionRepository.Impl.getInstance().listar();

    }
    public static TipoIdentificacion cargar(String codigo) {
        TipoIdentificacion tipoidentificacion = TipoIdentificacionRepository.Impl.getInstance().cargar(codigo);
        return tipoidentificacion;
    }
}
