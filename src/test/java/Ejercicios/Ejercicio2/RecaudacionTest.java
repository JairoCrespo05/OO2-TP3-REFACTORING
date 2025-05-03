package Ejercicios.Ejercicio2;


import Ejercicios.ejercicio2.LectorCSV;
import Ejercicios.ejercicio2.Recaudacion;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RecaudacionTest {

    @Test
    public void testEjecutarQueryGivenCompany() throws IOException {
//        Map<String, String> options = new HashMap<String, String>();
//        options.put("company_name", "Facebook");
        var r1 = new Recaudacion(new LectorCSV("src/main/resources/data.csv"));

        var resultado = r1
                            .filtrarPor(Recaudacion.COMPANY_NAME, "Facebook")
                            .ejecutarQuery();


        assertEquals(resultado.size(), 7);
    }

    @Test
    public void testEjecutarQueryGivenCity() throws IOException {
//        Map<String, String> options = new HashMap<String, String>();
//        options.put("city", "Tempe");
        var r1 = new Recaudacion(new LectorCSV("src/main/resources/data.csv"));

        var resultado = r1
                        .filtrarPor(Recaudacion.CITY, "Tempe")
                        .ejecutarQuery();

        assertEquals(resultado.size(), 3);
    }

    @Test
    public void testEjecutarQueryGivenState() throws IOException {
//        Map<String, String> options = new HashMap<String, String>();
//        options.put("state", "CA");
        var r1 = new Recaudacion(new LectorCSV("src/main/resources/data.csv"));

        var resultado = r1
                            .filtrarPor(Recaudacion.STATE, "CA")
                            .ejecutarQuery();

        assertEquals(resultado.size(), 873);
    }

    @Test
    public void testEjecutarQueryGivenRound() throws IOException {
//        Map<String, String> options = new HashMap<String, String>();
////        options.put("round", "a");
        var r1 = new Recaudacion(new LectorCSV("src/main/resources/data.csv"));

        var resultado = r1
                        .filtrarPor(Recaudacion.ROUND, "a")
                        .ejecutarQuery();

        assertEquals(resultado.size(), 582);
    }

//EJEMPLO CLARO DE LOS CAMBIOS APLICADOS
    @Test
    public void testMultipleOptions() throws IOException {
        Map<String, String> options = new HashMap<String, String>();
        var r1 = new Recaudacion(new LectorCSV("src/main/resources/data.csv"));

//        options.put("round", "a");
//        options.put("company_name", "Facebook");

        //Fluent API - Interfaces Fluidas

        var resultado = r1
                            .filtrarPor(Recaudacion.ROUND, "a")
                            .filtrarPor(Recaudacion.COMPANY_NAME, "Facebook")
                            .ejecutarQuery();

        assertEquals(resultado.size(), 1);
//        assertEquals(r1.where(options).size(), 1);
    }

    @Test
    public void testEjecutarQueryNotExists() throws IOException {
//        Map<String, String> options = new HashMap<String, String>();
//        options.put("company_name", "NotFacebook");
        var r1 = new Recaudacion(new LectorCSV("src/main/resources/data.csv"));

        var resultado = r1
                            .filtrarPor(Recaudacion.COMPANY_NAME, "NotFacebook")
                            .ejecutarQuery();

        assertEquals(resultado.size(), 0);
    }

    @Test
    public void testEjecutarQueryCorrectKeys() throws IOException {
//        Map<String, String> options = new HashMap<String, String>();
//        options.put("company_name", "Facebook");
        var r1 = new Recaudacion(new LectorCSV("src/main/resources/data.csv"));

        Map<String, String> row = r1
                                    .filtrarPor(Recaudacion.COMPANY_NAME, "Facebook")
                                    .ejecutarQuery().get(0);

        assertEquals(row.get("permalink"), "facebook");
        assertEquals(row.get("company_name"), "Facebook");
        assertEquals(row.get("number_employees"), "450");
        assertEquals(row.get("category"), "web");
        assertEquals(row.get("city"), "Palo Alto");
        assertEquals(row.get("state"), "CA");
        assertEquals(row.get("funded_date"), "1-Sep-04");
        assertEquals(row.get("raised_amount"), "500000");
        assertEquals(row.get("round"), "angel");

    }
}
