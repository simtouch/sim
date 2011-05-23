
package org.sim.domain;

import java.util.List;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Assert;
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

        System.out.println("Cantidad de Departamentos ----> "+recordAmount);
        imprimirDepartamentos(lst);

        System.out.println(">>>> Cargando el Departamento");
        Departamento d = Departamento.cargar("11");
        Assert.assertNotNull("El departamento cargado es nulo", d);

        System.out.println(">>>> Listando municipios del departamento");
        final List<Municipio> municipios = d.getMunicipios();
        System.out.println("Cantidad de Municipios ----> " + municipios.size());
        imprimirMunicipios(municipios);
        
        //Departamento d1= new Departamento("AA", "A PRUEBA");
        //d1.guardar();
        //        dr.guardar(d);

//        lst = dr.listar();
       

       
 //       d.setNombre("NUEVA PREUBA");
 //       dr.actualizar(d);
       

 //     lst = dr.listar();
       
 //     imprimirLista(lst);
       
 //      //dr.eliminar(d);

//        List<Departamento> lst2=dr.listar();
//        Assert.assertEquals(recordAmount, lst2.size());
    }


    private void imprimirDepartamentos(List<Departamento> lst){
        System.out.println("///////////         LISTANDO         //////////////////");

        for(Departamento dep: lst){
           System.out.println(dep.getCodigo() + " - " + dep.getNombre());
           System.out.println("-----------------------------------------");
        }

    }

    private void imprimirMunicipios(List<Municipio> lst){
        System.out.println("///////////         LISTANDO         //////////////////");

        for(Municipio m: lst){
           System.out.println(m + " - " + m.getNombre());
           System.out.println("-----------------------------------------");
        }

    }

}
