
package org.sim.domain;

import java.util.List;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sim.repository.DepartamentoRepository;

/**
 *
 * @author Franky Villadiego
 */

public class DepartamentoTest{


    private static final Logger log=Logger.getLogger(DepartamentoTest.class.getName());

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void testBasico(){
        DepartamentoRepository dr = DepartamentoRepository.Impl.getInstance();
        List<Departamento> lst = dr.listar(Departamento.Orden.NOMBRE);

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


    private void imprimirLista(List<Departamento> lst){
        System.out.println("///////////         LISTANDO         //////////////////");

        for(Departamento dep: lst){
           System.out.println(dep.getCodigo() + " - " + dep.getNombre());
           System.out.println("-----------------------------------------");
        }

    }

}
