package Ejercicios.ejercicio4;

import org.jdbi.v3.core.Jdbi;

public class Main {

    public static void main(String[] args) {

        Jdbi jdbi = Jdbi.create("jdbc:hsqldb:mem;create=true");

        new SetUpDatabase(jdbi).setUp();

        var repo = new PersonaRepository(jdbi);
//        var personas = repo.buscarPorNombre("Vla");
        var personas = repo.buscarPorNombre("J");


        personas.ifPresent( person -> System.out.println(person));

        var persona = repo.buscarId(1L);

        System.out.println(persona);

    }
}
