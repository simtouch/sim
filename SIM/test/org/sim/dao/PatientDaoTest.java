
package org.sim.dao;

import java.util.List;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sim.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import junit.framework.Assert;

/**
 *
 * @author Franky Villadiego
 */
@ContextConfiguration(locations = {"classpath:applicationContextTest.xml"})
public class PatientDaoTest extends AbstractJUnit4SpringContextTests{


    private static final Logger log=Logger.getLogger(PatientDaoTest.class.getName());

    @Autowired
    private PatientDao patientDao;


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void testBasico(){
        List<Patient> lst=patientDao.listAll(Patient.class);
        int recordAmount = lst.size();

        System.out.println("Cantidad de Registros ----> "+recordAmount);
        Patient p=createPatient("PRUEBA");
        patientDao.insert(p);
        
        lst=patientDao.listAll(Patient.class);
        System.out.println("***********************************");
       for(Patient o: lst){
           System.out.println(o.getId() + " - " + o.getName());
           System.out.println("-----------------------------------------");
       }

       p.setName("NUEVA PREUBA");
       patientDao.update(p);

       lst=patientDao.listAll(Patient.class);
       System.out.println("***********************************");
       for(Patient o: lst){
           System.out.println(o.getId() + " - " + o.getName());
           System.out.println("-----------------------------------------");
       }
       patientDao.delete(p);

        List<Patient> lst2=patientDao.listAll(Patient.class);
        Assert.assertEquals(recordAmount, lst2.size());
    }


    private Patient createPatient(String name){
        Patient p=new Patient();
        p.setName(name);
        return p;
    }

}
