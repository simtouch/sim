
package org.sim.domain;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.framework.Assert;
import org.sim.repository.PacienteRepository;

/**
 *
 * @author Franky Villadiego
 */

public class PacienteTest{


    private static final Logger log=Logger.getLogger(PacienteTest.class.getName());

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void testBasico(){
        PacienteRepository rep = PacienteRepository.Impl.getInstance();
        List<Paciente> lst=rep.listarPacientes();
        int recordAmount = lst.size();

        System.out.println("Cantidad de Registros ----> "+recordAmount);
        final TipoIdentificacion ti = TipoIdentificacion.cargar("CC");
        CodigoPaciente cp = new  CodigoPaciente();
        cp.setIdentificacion("123456");
        cp.setTipoIdentificacion(ti);
        final Entidad e = Entidad.cargar("EPS001");
        final Departamento dep = Departamento.cargar("05");
        final Municipio mun = Municipio.cargar("001", dep);
        final TipoPaciente tp = TipoPaciente.cargar("1");
        Assert.assertNotNull(ti);
        Assert.assertNotNull(e);
        Assert.assertNotNull(dep);
        Assert.assertNotNull(mun);
        Assert.assertNotNull(tp);
        Paciente p = crear(cp, e, mun, tp);
        Antecedente a1 = new Antecedente();
        a1.setDescripcion("GRIPE SENCILLA");
        a1.setFecha(new Date());
        a1.setTipo(TipoAntecedente.PERSONAL);
        p.addAntecedente(a1);
        rep.guardar(p);

        lst = rep.listarPacientes();

        System.out.println("***********************************");
        for(Paciente o: lst){
           System.out.println(o.getCodigo() + " - " + o.getPrimerApellido() + " - " + o.getPrimerNombre());
           System.out.println("-----------------------------------------");
        }

        //rep.eliminar(p);

        List<Paciente> lst2=rep.listarPacientes();
        Assert.assertEquals(recordAmount+1, lst2.size());
    }


    private Paciente crear(CodigoPaciente cod, Entidad ent, Municipio mun, TipoPaciente tp){

        Paciente p = new Paciente();
        p.setCodigo(cod);

        p.setCorreoElectronico("frankyjose@hotmail.com");
        p.setDireccion("Caracas, Brisas de Propatria");
        p.setEntidad(ent);
        p.setFechaNacimiento(new Date());
        p.setMunicipio(mun);
        p.setPrimerApellido("VILLADIEGO");
        p.setPrimerNombre("FRANKY");
        p.setSegundoApellido("NARVAEZ");
        p.setSegundoNombre("JOSE");
        p.setSexo(Sexo.M);
        p.setTelefonoFijo("6190518");
        p.setTelefonoMovil("04148077886");
        p.setTipoPaciente(tp);
        p.setZona(Zona.U);

        return p;
    }

}
