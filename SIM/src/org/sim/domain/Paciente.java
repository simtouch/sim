
package org.sim.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.sim.repository.PacienteRepository;
import org.sim.util.exceptions.BusinessException;
import org.sim.util.exceptions.ObjectNotFoundException;
import org.sim.util.exceptions.RepositoryException;

/**
 *
 * @author Franky Villadiego
 */

@Entity
@Table(name="pacientes")
public class Paciente implements Serializable{

    public enum Orden{APELLIDO, CODIGO};

    @EmbeddedId
    private CodigoPaciente codigo;

    @ManyToOne
    @JoinColumn(name="TIPO_USUARIO", nullable=false, columnDefinition="VARCHAR(1)")
    private TipoPaciente tipoPaciente;
    
    @Column(name="PRIMER_NOMBRE", nullable=false, length=30)
    private String primerNombre;

    @Column(name="SEGUNDO_NOMBRE", length=30)
    private String segundoNombre;

    @Column(name="PRIMER_APELLIDO", nullable=false, length=30)
    private String primerApellido;

    @Column(name="SEGUNDO_APELLIDO", length=30)
    private String segundoApellido;

    @Enumerated(EnumType.STRING) @Column(name="SEXO", nullable=false, length=1)
    private Sexo sexo;

    @Temporal(javax.persistence.TemporalType.DATE) @Column(name="FECHA_NACIMIENTO", nullable=false)
    private Date fechaNacimiento;

    @Column(name="DIRECCION")
    private String direccion;

    @Column(name="TELEFONO_FIJO", length=50)
    private String telefonoFijo;

    @Column(name="TELEFONO_MOVIL", length=50)
    private String telefonoMovil;

    @Column(name="CORREO_ELECTRONICO", length=100)
    private String correoElectronico;

    @Enumerated(EnumType.STRING) @Column(name="ZONA",  nullable=false, length=1)
    private Zona zona;

    @ManyToOne
    @JoinColumns({@JoinColumn(name="MUNICIPIO_ID", referencedColumnName="codigo_municipio", nullable=false, columnDefinition="VARCHAR(3)"),
                  @JoinColumn(name="DEPARTAMENTO_ID", referencedColumnName="codigo_departamento", nullable=false, columnDefinition="VARCHAR(2)")})
    private Municipio municipio;

    @ManyToOne
    @JoinColumn(name="ENTIDAD_ID", nullable=false, columnDefinition="VARCHAR(6)")
    private Entidad entidad;

    @OneToMany(cascade=CascadeType.ALL,mappedBy="paciente")
    private Collection<Antecedente> antecedentes;// = new ArrayList<Antecedente>();



    public Paciente() {
    }

    public Collection<Antecedente> getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(Collection<Antecedente> antecedentes) {
        this.antecedentes = antecedentes;
    }

    public CodigoPaciente getCodigo() {
        return codigo;
    }

    public void setCodigo(CodigoPaciente codigo) {
        this.codigo = codigo;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Entidad getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidad entidad) {
        this.entidad = entidad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public TipoPaciente getTipoPaciente() {
        return tipoPaciente;
    }

    public void setTipoPaciente(TipoPaciente tipoPaciente) {
        this.tipoPaciente = tipoPaciente;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Paciente other = (Paciente) obj;
        if (this.codigo != other.codigo && (this.codigo == null || !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        return hash;
    }


    public void addAntecedente(Antecedente antecedente){
        antecedente.setPaciente(this);
        if(antecedentes == null) antecedentes = new ArrayList<Antecedente>();
        antecedentes.add(antecedente);
    }

    public static Paciente cargar(String codigo) throws BusinessException {
//        if (cedula <= 0) {
//            throw new BusinessException("La cedula para cargar el Paciente debe ser un dato válido");
//        }
//        Paciente p = pacienteRepository.cargar(cedula);
//        if (p == null) {
//            this.cedula = cedula;
//            throw new ObjectNotFoundException("El paciente con cedula " + cedula + " no existe");
//        }
//        this.cedula = p.getCedula();
//        this.apellido = p.getApellido();
//        this.nombre = p.getNombre();
        return null;
    }

    /* Metodos de negocio */



    public void guardar() throws BusinessException, RepositoryException{
        PacienteRepository rep = PacienteRepository.Impl.getInstance();
        rep.guardar(this);
    }


}
