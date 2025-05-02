package Ejercicios.ejercicio3;

public class AlquilerAuto implements Gasto {

    public static String ALQUILER_AUTO = "Alquiler de Autos";
    private int monto;

    public AlquilerAuto(int monto) {
        this.monto = monto;
    }

    @Override
    public String elNombreDelGastoEs(){return ALQUILER_AUTO;}

    @Override
    public String marcaExcesoEnComida() {return " ";}

    @Override
    public int montoGastado() {return this.monto;}

    @Override
    public int gastoEnComidaEs() {
        return 0;
    }
}
