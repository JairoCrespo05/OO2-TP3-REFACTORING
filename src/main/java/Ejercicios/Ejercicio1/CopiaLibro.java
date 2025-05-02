package Ejercicios.Ejercicio1;

public class CopiaLibro {
    private Libro libro;

    public CopiaLibro(Libro libro) {
        this.libro = libro;
    }

    public Libro libro() {
        return libro;
    }

    public int isNuevoLanzamiento(int diasAlquilados){
        return this.libro.nuevoLanzamientoY2Dias(diasAlquilados);
    }

    public Double laDeudaCopiaEs(int diasAlquilado){

        return this.libro.calcularDeudaLibro(diasAlquilado);
    }

}