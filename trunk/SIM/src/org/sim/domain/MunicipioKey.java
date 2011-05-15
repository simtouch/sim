/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sim.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Franky Villadiego
 */
@Embeddable
public class MunicipioKey implements Serializable{

    @Column(name="codigo_municipio")
    private String codigoMunicipio;
    
    @Column(name="codigo_departamento")
    private String codigoDepartamento;

    public String getCodigoDepartamento() {
        return codigoDepartamento;
    }

    public void setCodigoDepartamento(String codigoDepartamento) {
        this.codigoDepartamento = codigoDepartamento;
    }

    public String getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(String codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MunicipioKey other = (MunicipioKey) obj;
        if ((this.codigoMunicipio == null) ? (other.codigoMunicipio != null) : !this.codigoMunicipio.equals(other.codigoMunicipio)) {
            return false;
        }
        if ((this.codigoDepartamento == null) ? (other.codigoDepartamento != null) : !this.codigoDepartamento.equals(other.codigoDepartamento)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + (this.codigoMunicipio != null ? this.codigoMunicipio.hashCode() : 0);
        hash = 11 * hash + (this.codigoDepartamento != null ? this.codigoDepartamento.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return this.codigoMunicipio+this.codigoDepartamento;
    }



    

}
