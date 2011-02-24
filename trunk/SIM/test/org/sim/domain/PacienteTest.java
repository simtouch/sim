
package org.sim.domain;

import java.util.List;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sim.repository.dao.patient.PatientJpa;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import junit.framework.Assert;
import org.sim.repository.PacienteRepository;

/**
 *
 * @author Franky Villadiego
 */
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class PacienteTest extends AbstractJUnit4SpringContextTests{


    private static final Logger log=Logger.getLogger(PacienteTest.class.getName());

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void testBasico(){
        PacienteRepository pacienteRepository = PacienteRepository.Impl.getInstance();
        List<Paciente> lst=pacienteRepository.listarPacientes();
        //List<PatientJpa> lst=patientDao.listAll(PatientJpa.class);
        int recordAmount = lst.size();

        System.out.println("Cantidad de Registros ----> "+recordAmount);
        Paciente p = new Paciente(123456789, "JULANO", "DE TAL");
        pacienteRepository.guardar(p);
        //PatientJpa p=createPatient("PRUEBA");
        //patientDao.insert(p);
        lst = pacienteRepository.listarPacientes();
        //lst=patientDao.listAll(PatientJpa.class);
        System.out.println("***********************************");
       for(Paciente o: lst){
           System.out.println(o.getCedula() + " - " + o.getNombre() + " - " + o.getApellido());
           System.out.println("-----------------------------------------");
       }

       p.setNombre("NUEVA PREUBA");
       pacienteRepository.actualizar(p);
       //patientDao.update(p);

       lst = pacienteRepository.listarPacientes();
       //lst=patientDao.listAll(PatientJpa.class);
       System.out.println("***********************************");
       
       for(Paciente o: lst){
           System.out.println(o.getCedula() + " - " + o.getNombre() + " - " + o.getApellido());
           System.out.println("-----------------------------------------");
       }
       //p.eliminar();
       //patientDao.delete(p);
       pacienteRepository.eliminar(p);

        List<Paciente> lst2=pacienteRepository.listarPacientes();
        Assert.assertEquals(recordAmount, lst2.size());
    }


    private PatientJpa createPatient(String name){
        PatientJpa p=new PatientJpa();
        p.setName(name);
        return p;
    }

}
