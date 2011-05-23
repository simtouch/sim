
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
        System.out.println(">>> Cargando departamento");
        final Departamento dep = Departamento.cargar("11");

        System.out.println(">>> Listando municipios");
        List<Municipio> lst = dep.getMunicipios();
        
        int recordAmount = lst.size();

        System.out.println("Cantidad de Registros ----> "+recordAmount);
        imprimirLista(lst);

//        Municipio m = new Municipio("AAA",dep,"A PRUEBA MUN");
//        m.guardar();


//        System.out.println(">>> Listando municipios");
//        lst = dep.getMunicipios();
//
//        recordAmount = lst.size();
//
//        System.out.println("Cantidad de Registros ----> "+recordAmount);
//        imprimirLista(lst);
        

    }


    private void imprimirLista(List<Municipio> lst){
        System.out.println("///////////         LISTANDO         //////////////////");

        for(Municipio m: lst){
           System.out.println(m.getIdentificador() + " - " + m.getNombre());
           System.out.println("-----------------------------------------");
        }

    }

}
