
package org.sim.domain;

import java.util.List;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sim.repository.DepartamentoRepository;
import org.sim.repository.MunicipioRepository;
import org.sim.domain.Municipio.Orden;

/**
 *
 * @author Franky Villadiego
 */

public class MunicipioTest{


    private static final Logger log=Logger.getLogger(MunicipioTest.class.getName());

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void testBasico(){
        MunicipioRepository mr = MunicipioRepository.Impl.getInstance();
        final Departamento dep = Departamento.cargar("11");
        List<Municipio> lst = dep.getMunicipios();
        //List<Municipio> lst = mr.listarPorDepartamento(dep, Orden.NOMBRE);

        int recordAmount = lst.size();

        System.out.println("Cantidad de Registros ----> "+recordAmount);

//        Departamento d = new Departamento();
//        dr.guardar(d);

//        lst = dr.listar();
       
        imprimirLista(lst);
       
 //       d.setNombre("NUEVA PREUBA");
 //       dr.actualizar(d);
       

 //     lst = dr.listar();
       
 //     imprimirLista(lst);
       
 //      //dr.eliminar(d);

//        List<Departamento> lst2=dr.listar();
//        Assert.assertEquals(recordAmount, lst2.size());
    }


    private void imprimirLista(List<Municipio> lst){
        System.out.println("///////////         LISTANDO         //////////////////");

        for(Municipio m: lst){
           System.out.println(m.getIdentificador() + " - " + m.getNombre());
           System.out.println("-----------------------------------------");
        }

    }

}
