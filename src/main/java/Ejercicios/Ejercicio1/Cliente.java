package Ejercicios.Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private List<Alquiler> alquileres = new ArrayList<Alquiler>();
    private String name;
    private int puntosObtenidos;


    public Cliente(String nombre) {
        this.name = nombre;
        puntosObtenidos = 0;
    }

    public Double calcularDeudaAlquileres() {
        double total = 0;
        int puntosAlquilerFrecuente = 0;

        for (Alquiler alquiler : alquileres) {
            total += alquiler.deudaAlquilerLibro();
//            // sumo puntos por alquiler
            puntosAlquilerFrecuente++;
//            // bonus por dos días de alquiler de un nuevo lanzamiento
            puntosAlquilerFrecuente += alquiler.bonus2diasYNuevoLanzamiento();
        }

        this.puntosObtenidos = puntosAlquilerFrecuente;
        return total;
    }

    public int losPuntosObtenidosSon(){return puntosObtenidos;}

    public void alquilar(Alquiler rental) {
        alquileres.add(rental);
    }

}