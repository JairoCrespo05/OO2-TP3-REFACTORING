package Ejercicios.Ejercicio1;

public class LibroNuevoLanzamiento extends Libro{

    public static final int NUEVO_LANZAMIENTO = 1;

    public LibroNuevoLanzamiento(String nombre){
        super(nombre, NUEVO_LANZAMIENTO);
    }



    @Override
    public Double calcularDeudaLibro(int diasAlquilado) {

        return diasAlquilado * 3.0;
    }

    @Override
    public int calcularPuntos() {
        return 0;
    }

    @Override
    public int nuevoLanzamientoY2Dias(int diasAlquilados) {
        int puntosAlquiler = 0;
        if (diasAlquilados > 1){
            puntosAlquiler++;
        }

        return puntosAlquiler;
    }
}
