package ejercicio2;
import ejercicio1.*;
import java.util.*;;

public class Coleccion {
    private Persona[] arrPersona;
    private int contador = 0;
    Coleccion(){
        arrPersona = new Persona[10];
    }
    Coleccion(int n){
        arrPersona = new Persona[n];
    }
    public boolean agregarPersona(Persona p){
        if(contador < arrPersona.length){
            arrPersona[contador] = p;
            contador++;
            return true;
        }
        return false;
    }
    public int buscarPersona(Persona p){
        for(int i = 0; i < arrPersona.length; i++){
            if(arrPersona[i].getNombre().equals(p.getNombre())&& arrPersona[i].getEdad() == p.getEdad() && arrPersona[i].getSexo() == p.getSexo())
                return i;
        }
        return -1;
    }
    public boolean eliminarPersona(Persona p){
        for(int i = 0; i < arrPersona.length; i++){
            if(arrPersona[i].getNombre().equals(p.getNombre())){
                arrPersona[i] = arrPersona[contador-1];
                arrPersona[contador-1] = null;
                contador--;
                return true;
            }
        }
        return false;
    }
    public Coleccion mayoresDeEdad(){
        Coleccion newArray = new Coleccion(arrPersona.length);
        for(Persona p : arrPersona){
            if(p.esMayorDeEdad()) newArray.agregarPersona(p);
        }
        return newArray;
    }
    public Coleccion pesoIdeal(){
        Coleccion newArray = new Coleccion(arrPersona.length);
        for(Persona p : arrPersona){
            if(p.calcularIMC() == 0) newArray.agregarPersona(p);
        }
        return newArray;
    }
    public String toString(){
        String s = "";
        for(Persona p : arrPersona){
            if(p != null)
                s += p.toString();
        }
        return s;
    }
    public Coleccion condicionPeso(String s){
        Coleccion newArray = new Coleccion(arrPersona.length);
        switch (s) {
            case "Ideal":
                return pesoIdeal();
            case "Desnutricion":
                newArray = new Coleccion(arrPersona.length);
                for(Persona p : arrPersona){
                    if(p.calcularIMC() == -1) newArray.agregarPersona(p);
                }
                return newArray;
            case "Sobrepeso":
                newArray = new Coleccion(arrPersona.length);
                for(Persona p : arrPersona){
                    if(p.calcularIMC() == 1) newArray.agregarPersona(p);
                }
                return newArray;
            default:
                System.out.println("Ingrese una condicion aceptada: Ideal, Desnutricion, Sobrepeso");
                break;
        }
        return new Coleccion();
    }
    public int longitud(){
        return contador;
    }
    public Coleccion regionAlerta(ArrayList<Coleccion> regiones, String condicion){
        //int cndcn = (condicion.equals("Ideal"))? 0: (condicion.equals("Sobrepeso"))? 1 : -1;
        Coleccion optimo = regiones.get(0);
        for(Coleccion r : regiones){
            if (optimo.longitud() < r.condicionPeso(condicion).longitud())
                optimo = r;
        }
        return optimo;
    }
}
