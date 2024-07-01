import java.util.Scanner;
import Estructuras.MyLinkedList;

class MyStack<T>{
  private MyLinkedList<T> lista;
  public MyStack(){
    lista = new MyLinkedList<>();
  }
  public void push(T dato){
    lista.agregarAlFinal(dato);
  }
  public T pop(){
    T dato = lista.getTail();
    lista.eliminarNodo(dato);
    return dato;
  }
  public T peek(){
    return lista.getHead();
  }
  public boolean isEmpty(){
    return lista.cabeza == null;
  }
  static MyStack<Character> strStack (String s){
    MyStack<Character> stack = new MyStack<>();
    for (int i = 0; i < s.length(); i++) {
      stack.push(s.charAt(i));
    }
    return stack;
  }
}

public class lab8Ejer1 {

  public static void main(String[] args) {
    System.out.println("Hola, ingrese el String a invertir:");
    Scanner scanner = new Scanner(System.in);
    String userString = scanner.nextLine();
    MyStack<Character> stack = MyStack.strStack(userString);
    String invertedString = swapString(stack, userString);
    System.out.println("El String invertido es: " + invertedString);
  }
  private static String swapString(MyStack<Character> stack, String s){
    String invertedString = "";
    while(!stack.isEmpty()){
      invertedString += stack.pop();
    }
    return invertedString;
  }
}
