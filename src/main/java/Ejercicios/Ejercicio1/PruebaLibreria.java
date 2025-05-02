package Ejercicios.Ejercicio1;

public class PruebaLibreria {
    public static void main(String args[]) {
        Libro elTunel = new LibroRegular("El Túnel");
        Libro antesDelFin = new LibroRegular("Antes del Fin");

        CopiaLibro elTunelCopia = new CopiaLibro(elTunel);
        CopiaLibro antesDelFinCopia = new CopiaLibro(antesDelFin);

        Alquiler alquilerElTunel = new Alquiler(elTunelCopia, 5);
        Alquiler alquilerAntesDelFin = new Alquiler(antesDelFinCopia, 3);

        Cliente yo = new Cliente("Javier");

        yo.alquilar(alquilerElTunel);
        yo.alquilar(alquilerAntesDelFin);

        Double precioTotal = yo.calcularDeudaAlquileres();
        var puntosObtenidos = yo.losPuntosObtenidosSon();

        System.out.println(precioTotal);
        System.out.println(puntosObtenidos);
    }
}