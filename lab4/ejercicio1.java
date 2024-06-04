
import java.util.*;
public class ejercicio1 {
    //Primero tenemos un arreglo de numero que representan las ciudades, tienen un valor que representa
    //el valor maximo de skippeos que pueden realizar a la derecha, el objetivo es llegar al final sin estar en el
    //"mundo al reves" el cual es representado por un nuevo arreglo de ciudades que es el arreglo original
    //pero con las valores de las ciudades volteadas
    public static void main(String[] args) {
        System.out.println("Ingresa el mundo normal(numeros enteros hasta que ingreses un negativo): ");
        ArrayList<Integer> ciudad = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int city;
        do{
            city = sc.nextInt();
            if(city >= 0){
                ciudad.add(city);
            }
        }while(city >= 0);
        System.out.print("La ciudad al reves se ve así: ");
        ArrayList<Integer> daduic = new ArrayList<>();
        for(int i = 1; i <= ciudad.size(); i++){
            daduic.add(ciudad.get(ciudad.size() - i));
        }
        System.out.println(daduic);
        System.out.println("Agente Jim Hooper reportandose: ");
        System.out.println("La forma de salir del problema con la menor cantidad de pasos es: ");

    }

    //Definimos recursivamente la solucion
    //En un arreglo de tamaño len, debemos tomar pasos que modifican nuestra posicion p hasta que sea igual a len
    //Mientras nos encontramos en el mundo normal, debido a que hay ciudades con valor cero que hacen que el arreglo
    //cambie a un reflejo de lo que era originalmente
    //Usamos una definicion obvia: la lista eficiente esta formada por el primer paso en la posicion 0 más la lista 
    //eficiente para esa ciudad en la posicion actualizada
    private List<Integer> mundoAlRevez(ArrayList<Integer> ciudad, boolean alrevez, HashMap<Integer, SolucionOptima> recorridos, int posicion){
        if(posicion == ciudad.size()){
            if(alrevez) return null;
            return new ArrayList<Integer>();
        }
        List<List<Integer>> contenders = new ArrayList<>();
        if(alrevez){
            List<Integer> ciudadAlrevez = new ArrayList<>();
            for(int i = 1; i <= ciudad.size(); i++){
                ciudadAlrevez.add(ciudad.get(ciudad.size() - i));
            }
        }
        int lastCity= ciudad.size();
        for(int i = 1; i <= lastCity; i++){
            int nuevapos = posicion + i;
            if(recorridos.containsKey(nuevapos)){
                if(recorridos.get(nuevapos) != null)
                    contenders.add(trackOptimal.get(diff).addCoin(coinValue));
            }else{
                trackOptimal.put(diff, algoritmoB(coinTypeList, diff, trackOptimal));
                if(trackOptimal.get(diff) != null)
                    contenders.add(trackOptimal.get(diff).addCoin(coinValue));
            }
        }
        if(contenders.size() == 0)
            return null;
        Collections.sort(contenders);
        return contenders.get(0);
    }
}
