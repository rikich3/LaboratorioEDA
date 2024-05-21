import java.util.*;

class Solucion{
    public static void main(String[] args) {
        System.out.println("Ingrese un numero: ");
        Scanner sc = new Scanner(System.in);
        int prueba = sc.nextInt();
        System.out.print("Su inverso seria: ");
        System.out.println(invertNumber(prueba));
        System.out.println("Ahora ingrese un numero y comprobaremos si sus digitos estan en forma decreciente");
        int b = sc.nextInt();
        System.out.println(isSortedTopBottom(b, true));
        System.out.println("Ingrese la cantidad de fichas en la torre de Hanoi: ");
        int altura = sc.nextInt();
        System.out.println("Ahora ingrese la torre inicial: (A, B, C): ");
        char ti = sc.next().charAt(0);
        System.out.println("Ahora ingrese la torre final: (A, B, C): ");
        char tf = sc.next().charAt(0);
        hanoiTowers(altura, ti, tf, (ti == 'A' || tf == 'A')? (ti == 'B' || tf == 'B')? 'C' : 'B': 'A');
        System.out.println("Ingrese 10 numeros: ");
        ArrayList<Double> list = new ArrayList<>();

        for(int i  = 0; i < 10; i++){
            try{
            list.add(sc.nextDouble());}
            catch(Exception e) {break;}
        }
        Collections.sort(list);
        System.out.println("Tu lista ordenada se ve asi: " + list.toString());
        System.out.println("Indique un elemento a buscar e imprimiremos el indice si lo encontramos o -1: ");
        int obj = sc.nextInt();
        System.out.println("Buscando el " + obj);
        System.out.println(binarySearch(obj, list, 0, list.size()-1));
    }

    private static int invertNumber(int num){
        if(num < 10){
            return num;
        }
        //inv(4321) = 1000 + inv(432) // inv.432 = 200 + 
        int pow10 = 0;
        int firstDigit = num;
        int lastDigit = num % 10;
        while (firstDigit >= 10){
            firstDigit /= 10;
            lastDigit *= 10;
            pow10++;
        }
        for(int i  = 0; i < pow10; i++){
            firstDigit *= 10;
        }
        return lastDigit + invertNumber(num/10);
    }

    private static boolean isSortedTopBottom(int num ,boolean t){
        if(num < 10){
            return true;
        }
        return (t)? num % 10 <= ((num/10) % 10) && isSortedTopBottom(num/10, t) : num % 10 >= ((num/10) % 10) && isSortedTopBottom(num/10, t);
    }
    private static void hanoiTowers(int altura, char torreInicial, char torreFinal, char torrePivote){
        //caso base: altura es 1
        //de otra manera mover una lista de elementos de altura n de una torre A a B es lo mismo que mover la lista de elementos
        //n - 1 que esta encima de nuestro elemento n a la torre C, mover este elemento n a la torre B y volver a mover esta
        //lista n-1 encima del elemento n en la torre C
        //ya tenemos definicion recursiva
        if(altura <= 1){
            System.out.println("Mover de " + torreInicial + " a " + torreFinal);
            return;
        }
        hanoiTowers(altura-1, torreInicial, torrePivote, torreFinal);
        System.out.println("Mover de " + torreInicial + " a " + torreFinal);
        hanoiTowers(altura-1, torrePivote, torreFinal, torreInicial);
    }
    private static int binarySearch(int num, List<Double> lista, int left, int right){
        //Estamos buscando el indice del elemento encontrado si es que existe o -1 si no existe
        if(right < left) return -1;
        int middle = (right + left)/2;
        // System.out.println("El centro es " + middle);
        if(lista.get(middle) == num) return middle;
        if(lista.get(middle) > num) return binarySearch(num, lista, left, middle-1);
        return binarySearch(num, lista, middle + 1, right);
    }
}