package Ejercicios.Ejercicio4;

import Ejercicios.ejercicio4.PersonaRepository;
import Ejercicios.ejercicio4.SetUpDatabase;
import org.jdbi.v3.core.Jdbi;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestRepo {
    @Test
    public void Test01(){
        Jdbi jdbi = Jdbi.create("jdbc:hsqldb:mem;create=true");

        new SetUpDatabase(jdbi).setUp();

        var repo = new PersonaRepository(jdbi);
//        var personas = repo.buscarPorNombre("Vla");
        var personas = repo.buscarPorNombre("J");

        var persona = repo.buscarId(1L);





        assertEquals( "Optional[José Laurenti]", persona.toString());
//        assertEquals("[Vladimir Varkov]", personas.toString());
        assertEquals("Optional[[José Laurenti, Jairo Crespo]]", personas.toString());


    }
}
