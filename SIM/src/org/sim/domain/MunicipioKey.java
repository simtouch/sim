/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class MunicipioKey implements Serializable{

    @ManyToOne
    @JoinColumn(name="codigo_departamento")
    private Departamento departamento;

    @Column(name="codigo_municipio")
    private String codigoMunicipio;
    
//    @Column(name="codigo_departamento")
//    private String codigoDepartamento;

    public MunicipioKey() {
    }

    public MunicipioKey(Departamento departamento, String codigoMunicipio) {
        this.departamento = departamento;
        this.codigoMunicipio = codigoMunicipio;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }



//    public MunicipioKey(String codigoMunicipio, String codigoDepartamento) {
//        this.codigoMunicipio = codigoMunicipio;
//        this.codigoDepartamento = codigoDepartamento;
//    }
//
//    public String getCodigoDepartamento() {
//        return codigoDepartamento;
//    }
//
//    public void setCodigoDepartamento(String codigoDepartamento) {
//        this.codigoDepartamento = codigoDepartamento;
//    }

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
        if (this.departamento != other.departamento && (this.departamento == null || !this.departamento.equals(other.departamento))) {
            return false;
        }
        if ((this.codigoMunicipio == null) ? (other.codigoMunicipio != null) : !this.codigoMunicipio.equals(other.codigoMunicipio)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + (this.departamento != null ? this.departamento.hashCode() : 0);
        hash = 43 * hash + (this.codigoMunicipio != null ? this.codigoMunicipio.hashCode() : 0);
        return hash;
    }


    @Override
    public String toString() {
        return this.departamento.getCodigo() + this.codigoMunicipio;
    }

   

}
