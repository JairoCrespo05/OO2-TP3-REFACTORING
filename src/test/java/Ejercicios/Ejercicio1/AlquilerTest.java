package Ejercicios.Ejercicio1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlquilerTest {

    @Test
    public void Test01(){
        Libro elTunel = new LibroRegular("El Túnel");
        CopiaLibro elTunelCopia = new CopiaLibro(elTunel);
        Alquiler alquilerElTunel = new Alquiler(elTunelCopia, 5);
        Cliente yo = new Cliente("Javier");

        yo.alquilar(alquilerElTunel);

        Double precioTotal = yo.calcularDeudaAlquileres();
        var puntosObtenidos = yo.losPuntosObtenidosSon();

        assertEquals(6.5, precioTotal);
        assertEquals(1, puntosObtenidos);

    }

}