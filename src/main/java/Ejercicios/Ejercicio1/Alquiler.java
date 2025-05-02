package Ejercicios.Ejercicio1;

public class Alquiler {
    private CopiaLibro copia;
    private int diasAlquilados;

    public Alquiler(CopiaLibro copia, int diasAlquilados) {
        this.copia = copia;
        this.diasAlquilados = diasAlquilados;
    }

    public int diasAlquilados() {
        return this.diasAlquilados;
    }

    public CopiaLibro copia() {
        return this.copia;
    }

    public Double deudaAlquilerLibro(){ return this.copia.laDeudaCopiaEs(this.diasAlquilados); }


    public int bonus2diasYNuevoLanzamiento() {
        return copia.isNuevoLanzamiento(this.diasAlquilados) ;
    }

}
