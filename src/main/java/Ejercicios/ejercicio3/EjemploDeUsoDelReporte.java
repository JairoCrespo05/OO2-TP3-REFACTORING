package Ejercicios.ejercicio3;

import java.util.List;

public class EjemploDeUsoDelReporte {
    public static void main(String[] args) {

        var g1 = new Desayuno(2000);
        var g2 = new Desayuno(1000);

        var reporte = new ReporteDeGastos(List.of(g1, g2));

        reporte.imprimir();

    }
}
