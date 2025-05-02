package Ejercicios.ejercicio3;

import java.time.LocalDate;
import java.util.List;

public class ReporteDeGastos {

    private List<Gasto> gastos;

    public ReporteDeGastos(List<Gasto> gastos) {
        this.gastos = gastos;
    }

    public void imprimir() {
        int total = 0;
        int gastosDeComida = 0;

        System.out.println("Expenses " + LocalDate.now());

        for (Gasto gasto : gastos) {
            gastosDeComida += gasto.gastoEnComidaEs();

            String nombreGasto = gasto.elNombreDelGastoEs();

            String marcaExcesoComidas = gasto.marcaExcesoEnComida();

            System.out.println(formatoReporte(gasto, nombreGasto, marcaExcesoComidas));

            total += gasto.montoGastado();
        }

        System.out.println("Gastos de comida: " + gastosDeComida);
        System.out.println("Total de gastos: " + total);
    }


    private String formatoReporte(Gasto gasto, String nombreGasto, String marcaExcesoComidas) {
        return nombreGasto + "\t" + gasto.montoGastado() + "\t" + marcaExcesoComidas;
    }

}
