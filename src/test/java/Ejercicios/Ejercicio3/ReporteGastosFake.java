package Ejercicios.Ejercicio3;

import Ejercicios.ejercicio3.Gasto;

import java.util.List;

public class ReporteGastosFake {

    private List<Gasto> gastos;
    private int gastoEnComidas;
    private int gastoTotal;
    private String formatoImpresion;

    public ReporteGastosFake(List<Gasto> gastos) {
        this.gastos = gastos;
        this.gastoEnComidas = 0;
        this.gastoTotal = 0;
    }

    public void imprimir(){
        for (Gasto gasto : gastos){
            gastoEnComidas += gasto.gastoEnComidaEs();

            String nombreGasto = gasto.elNombreDelGastoEs();

            String marcaExcesoComidas = gasto.marcaExcesoEnComida();

            formatoImpresion = formatoReporte(gasto, nombreGasto, marcaExcesoComidas);

            gastoTotal += gasto.montoGastado();
        }
    }

    private String formatoReporte(Gasto gasto, String nombreGasto, String marcaExcesoComidas) {
        return nombreGasto + "\t" + gasto.montoGastado() + "\t" + marcaExcesoComidas;
    }

    public int gastoEnComidas(){return this.gastoEnComidas;}

    public int gastoTotal(){return this.gastoTotal;}

    public String formatoGasto(){return this.formatoImpresion;}

}
