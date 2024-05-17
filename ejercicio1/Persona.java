package ejercicio1;

public class Persona{
    private String nombre = "";
    private int edad = 0;
    private char sexo = 'M';
    private double peso = 0;
    private double altura = 0;
    public Persona(){

    }
    public Persona(String nombre, int edad, char sexo){
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }
    public Persona(String nombre, int edad, char sexo, double peso, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }
    public int calcularIMC(){
        if(peso/(altura*altura) >= 18.5 && peso/(altura*altura) <= 25){
            return 0;
        }
        return (peso/(altura*altura) < 18.5)? -1: 1;
    }
    public boolean esMayorDeEdad(){
        return edad >=18;
    }
    private boolean comprobarSexo(char s){
        return sexo == s;
    }
    public String toString(){
        String resume = nombre + ":\n";
        resume += "edad: " + edad + "\n";
        resume += "sexo: " + sexo + "\n";
        resume += "peso: " + peso + "\n";
        resume += "altura: " + altura + "\n";
        return resume;
    }
    public String getNombre() {
        return nombre;
    }
    public int getEdad() {
        return edad;
    }
    public char getSexo() {
        return sexo;
    }
    public double getPeso() {
        return peso;
    }
    public double getAltura() {
        return altura;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    
}