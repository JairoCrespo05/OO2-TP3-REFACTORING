package Ejercicios.ejercicio3;

public class Desayuno implements Gasto{

    public static String DESAYUNO = "Desayuno";
    private int monto;

    public Desayuno(int monto) {
        this.monto = monto;
    }

    @Override
    public int montoGastado() {return this.monto;}

    @Override
    public int gastoEnComidaEs() {return this.monto;}

    @Override
    public String elNombreDelGastoEs() {return DESAYUNO;}

    @Override
    public String marcaExcesoEnComida() {return this.monto > 1000 ? "X" : " ";}
}
