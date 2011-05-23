
package org.sim.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Franky Villadiego
 */
@Embeddable
public class CodigoPaciente implements Serializable{

    @ManyToOne
    @JoinColumn(name="TIPO_IDENTIFICACION", nullable=false, columnDefinition="VARCHAR(2)")
    private TipoIdentificacion tipoIdentificacion;
    @Column(name="IDENTIFICACION", nullable=false, length=50)
    private String identificacion;

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public TipoIdentificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CodigoPaciente other = (CodigoPaciente) obj;
        if (this.tipoIdentificacion != other.tipoIdentificacion && (this.tipoIdentificacion == null || !this.tipoIdentificacion.equals(other.tipoIdentificacion))) {
            return false;
        }
        if ((this.identificacion == null) ? (other.identificacion != null) : !this.identificacion.equals(other.identificacion)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + (this.tipoIdentificacion != null ? this.tipoIdentificacion.hashCode() : 0);
        hash = 17 * hash + (this.identificacion != null ? this.identificacion.hashCode() : 0);
        return hash;
    }



}
