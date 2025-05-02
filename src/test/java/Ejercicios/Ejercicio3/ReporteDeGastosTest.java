package Ejercicios.Ejercicio3;

import Ejercicios.ejercicio3.AlquilerAuto;
import Ejercicios.ejercicio3.Desayuno;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReporteDeGastosTest {

    @Test
    public void Test01(){

        var g1 = new Desayuno(2000);
        var g2 = new Desayuno(1000);
        var g3 = new AlquilerAuto(1000);

        var reporte = new ReporteGastosFake(List.of(g1, g2, g3));

        reporte.imprimir();

        assertEquals(4000, reporte.gastoTotal());
        assertEquals(3000, reporte.gastoEnComidas());
        assertEquals( "Alquiler de Autos" + "\t" + 1000 + "\t" + " ", reporte.formatoGasto());


    }

}