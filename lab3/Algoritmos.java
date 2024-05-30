import java.util.*;

class Algoritmos{

    public static void main(String[] args) {
        System.out.println("La lista de numeros: ");
        List<Double> list = new ArrayList<>();
        list.add(1.0);
        list.add(2.0);
        list.add(3.0);
        list.add(4.0);
        list.add(5.0);
        System.out.println(list);
        System.out.println("Ahora veamos su multiplicacion: " + multiplicaArrayDV(list, 0, 4));
        System.out.println("Ahora su promedio: " + mediaAritmeticaDV(list, 0, 4, 5));
        List<Double> list2 = new ArrayList<>();
        list2.add(1.0);
        list2.add(2.0);
        list2.add(3.0);
        list2.add(4.0);
        list2.add(5.0);
        System.out.println("Creando un nuevo arreglo: " + list2);
        System.out.println("Es este arreglo igual que el primero?: " + areSameDV(list, list2));
        Double[] listaArr = new Double[]{1.0, 2.0, 3.0, 4.0, 5.0};
        System.out.println("Ahora vamos a buscar el minimo y el maximo de este arreglo de numeros: " + findMinMax(listaArr, 0, list.size()-1));
    }
    private static Double multiplicaArrayDV(List<Double> l, int start, int end){
        //vamos a dividir si es que la lista es mayor que 2 vamos a dividir entre 2 la cantidad de elementos en la lista
        //y multiplicaremos cada estas primero antes de multiplicarlas por si mismo
        if(start == end){
            return l.get(start);
            }
        int mitad = (start+end)/2;
        Double x = multiplicaArrayDV(l, start, mitad);
        Double y = multiplicaArrayDV(l, mitad+1, end);
        return x * y;
    }
    //Why isnt it properly giving me the promedy?

    private static Double mediaAritmeticaDV(List<Double> l, int start, int end, int n){
        if(start == end){
            return l.get(start)/n;
            }
            int mitad = (start+end)/2;
            Double x = mediaAritmeticaDV(l, start, mitad, n);
            Double y = mediaAritmeticaDV(l, mitad+1, end, n);
            return x + y;
    }
    
    private static boolean areSameDV(List<Double> l1, List<Double> l2){
        int len1 = l1.size();
        int len2 = l2.size();
        if(len1 != len2) return false;
        if(len1 == 1){
            return l1.get(0).compareTo(l2.get(0)) == 0;
        }
        List<Double> first1 = l1.subList(0, len1/2);
        List<Double> last1 = l1.subList(len1/2, len1);
        List<Double> first2 = l2.subList(0, len2/2);
        List<Double> last2 = l2.subList(len2/2, len2);
        System.out.println("Divido los arreglos:");
        System.out.println("Compararemos " + first1 + " con " + first2);
        System.out.println("Compararemos " + last1 + " con " + last2);
        return areSameDV(first1, first2) && areSameDV(last1, last2);
    }
    static class MinMax {
        double min;
        double max;

        MinMax(double min, double max) {
            this.min = min;
            this.max = max;
        }
        public String toString() {
            return "Min: " + min + ", Max: " + max;
        }
    }

    // Método principal para encontrar el mínimo y máximo utilizando divide y vencerás
    public static MinMax findMinMax(Double[] array, int izq, int der) {
        // Si el array tiene solo un elemento
        if (izq == der) {
            return new MinMax(array[izq], array[izq]);
        }

        // Si el array tiene dos elementos
        if (der == izq + 1) {
            if (array[izq] < array[der]) {
                return new MinMax(array[izq], array[der]);
            } else {
                return new MinMax(array[der], array[izq]);
            }
        }

        // Si el array tiene más de dos elementos
        int mid = (izq + der) / 2;
        MinMax leftPair = findMinMax(array, izq, mid);
        MinMax rightPair = findMinMax(array, mid + 1, der);

        // Combinar los resultados de los subarrays
        double min = Math.min(leftPair.min, rightPair.min);
        double max = Math.max(leftPair.max, rightPair.max);

        return new MinMax(min, max);
    }
}