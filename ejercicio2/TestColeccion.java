package ejercicio2;
import ejercicio1.*;

public class TestColeccion {
    public static void main(String[] args) {
        Coleccion coleccion = new Coleccion();
        Persona pepe = new Persona("Pepe",20,'H', 79.6, 1.8);
        coleccion.agregarPersona(pepe);
        coleccion.agregarPersona(new Persona("Maria", 22,'M', 70.6, 1.72));
        coleccion.agregarPersona(new Persona("Rick", 22,'H', 72.6, 1.75));
        System.out.println(coleccion.toString());
        if(coleccion.buscarPersona(pepe) != -1){
            System.out.println("Encontramos a Pepe, ahora lo sacaremos de la coleccion");
            coleccion.eliminarPersona(pepe);
        }
        System.out.println("La nueva Coleccion se ve ahora:");
        System.out.println(coleccion.toString());
    }
}
