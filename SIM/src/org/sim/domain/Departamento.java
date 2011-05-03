

package org.sim.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.sim.repository.DepartamentoRepository;
import org.sim.util.exceptions.BusinessException;
import org.sim.util.exceptions.RepositoryException;

/**
 *
 * @author Franky Villadiego
 * @author Lerkis Causado
 */
@Entity
@Table(name = "departamentos")
public class Departamento implements Serializable{

    @Id
    @Column(name = "codigo_departamento")
    private String codigo;

    @Column(name = "nombre_departamento")
    private String nombre;

    @OneToMany(mappedBy = "departamento")
    private List<Municipio> municipios;

    public Departamento() {
    }

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
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Departamento other = (Departamento) obj;
        if ((this.codigo == null) ? (other.codigo != null) : !this.codigo.equals(other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return this.nombre;
    }


    public void guardar() throws RepositoryException, BusinessException{
        DepartamentoRepository.Impl.getInstance().guardarOrActualizar(this);
    }

    public static Departamento cargar(String codigo) throws RepositoryException, BusinessException{
        Departamento d = DepartamentoRepository.Impl.getInstance().cargar(codigo);
        return d;
    }

}
