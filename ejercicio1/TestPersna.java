package ejercicio1;

public class TestPersna {
    public static void main(String[] args) {
        Persona p1,p2,p3;
        p1 = new Persona("Frenn", 12, 'H', 51.7, 1.59);
        p2 = new Persona("Martha", 17, 'M', 49.12, 1.64);
        p3 = new Persona("Sophia", 18, 'M', 58.33, 1.71);
        System.out.println("La primera Persona es: ");
        System.out.println(p1.toString());
        System.out.println((p1.esMayorDeEdad())? "Es mayor de edad": "No es mayor de edad");
        if(p1.calcularIMC()==0){
            System.out.println("Tiene un peso ideal");
        }
        else
            System.out.println((p1.calcularIMC()==1)? "Presenta sobrepeso": "Presenta desnutricion");
        System.out.println("La segunda Persona es: ");
        System.out.println(p2.toString());
        System.out.println((p2.esMayorDeEdad())? "Es mayor de edad": "No es mayor de edad");
        if(p2.calcularIMC()==0){
            System.out.println("Tiene un peso ideal");
        }
        else
            System.out.println((p2.calcularIMC()==1)? "Presenta sobrepeso": "Presenta desnutricion");
        System.out.println("La tercera Persona es: ");
        System.out.println(p3.toString());
        System.out.println((p3.esMayorDeEdad())? "Es mayor de edad": "No es mayor de edad");
        if(p3.calcularIMC()==0){
            System.out.println("Tiene un peso ideal");
        }
        else
            System.out.println((p3.calcularIMC()==1)? "Presenta sobrepeso": "Presenta desnutricion");
    }
}
