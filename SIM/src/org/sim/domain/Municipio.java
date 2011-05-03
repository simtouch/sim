

package org.sim.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Franky Villadiego
 * @author Lerkis Causado
 */

@Entity
@Table(name = "municipios")
public class Municipio implements Serializable{

    @Id
    @Column(name = "codigo_municipio")
    private String codigo;

    @Column(name = "nombre_municipio")
    private String nombre;


    @ManyToOne

    private Departamento departamento;

}
