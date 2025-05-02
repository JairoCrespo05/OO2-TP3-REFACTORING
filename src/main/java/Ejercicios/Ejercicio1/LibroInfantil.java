package Ejercicios.Ejercicio1;

public class LibroInfantil extends Libro{

    public static final int INFANTILES = 2;

    public LibroInfantil(String nombre){
        super(nombre, INFANTILES);
    }

    @Override
    public Double calcularDeudaLibro(int diasAlquilado) {
        double monto = 1.5;
        if (diasAlquilado > 3)
            monto += (diasAlquilado - 3) * 1.5;

        return monto;
    }

    @Override
    public int calcularPuntos() {
        return 0;
    }

    @Override
    public int nuevoLanzamientoY2Dias(int diasAlquilados) { return 0; }
}
