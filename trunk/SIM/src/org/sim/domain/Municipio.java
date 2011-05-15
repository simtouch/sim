

package org.sim.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.sim.repository.MunicipioRepository;
import org.sim.util.exceptions.BusinessException;
import org.sim.util.exceptions.RepositoryException;

/**
 *
 * @author Franky Villadiego
 * @author Lerkis Causado
 */

@Entity
@Table(name = "municipios")
public class Municipio implements Serializable{

    public enum Orden {CODIGO, NOMBRE}
    //@Id
    //@Column(name = "codigo_municipio")
    //private String codigo;
    @EmbeddedId
    private MunicipioKey identificador;


    @Column(name = "nombre_municipio")
    private String nombre;


//    @ManyToOne
//    @JoinColumn(name="codigo_departamento")
//    private Departamento departamento;

    public MunicipioKey getIdentificador() {
        return identificador;
    }

    public void setIdentificador(MunicipioKey identificador) {
        this.identificador = identificador;
    }

    

//    public String getCodigo() {
//        return codigo;
//    }
//
//    public void setCodigo(String codigo) {
//        this.codigo = codigo;
//    }

//    public Departamento getDepartamento() {
//        return departamento;
//    }
//
//    public void setDepartamento(Departamento departamento) {
//        this.departamento = departamento;
//    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Municipio other = (Municipio) obj;
        if (this.identificador != other.identificador && (this.identificador == null || !this.identificador.equals(other.identificador))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (this.identificador != null ? this.identificador.hashCode() : 0);
        return hash;
    }


    @Override
    public String toString() {
        return this.nombre;
    }


    public void guardar() throws RepositoryException, BusinessException{
    }

    public static Municipio cargar(String codigo) throws RepositoryException, BusinessException{
        Municipio m = MunicipioRepository.Impl.getInstance().cargar(codigo);
        return m;
    }




}
