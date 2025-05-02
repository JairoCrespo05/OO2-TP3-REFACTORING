package Ejercicios.ejercicio3;

public class Cena implements Gasto{

    public static String CENA = "Cena";
    private int monto;

    public Cena(int monto) {
        this.monto = monto;
    }

    @Override
    public int montoGastado() {return this.monto;}

    @Override
    public int gastoEnComidaEs() {
        return this.monto;
    }

    @Override
    public String elNombreDelGastoEs() {return CENA;}

    @Override
    public String marcaExcesoEnComida() {return this.monto > 5000 ? "X" : " ";}
}
