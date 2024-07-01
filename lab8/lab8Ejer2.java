import java.util.Scanner;

class MyQueueWithStacks<T>{
  private MyStack<T> stack1;
  private MyStack<T> stack2;

  public MyQueueWithStacks(){
    stack1 = new MyStack<>(); //principal
    stack2 = new MyStack<>(); //secundario
  }

  public void enqueue(T dato){
    stack1.push(dato); 
  }

  public T dequeue(){
    //Para simular una cola con dos pilas, pasamos los elementos de la pila principal a la secundaria
    while(!stack1.isEmpty())
      stack2.push(stack1.pop());
    //sacamos el valor en la cola secundaria
    T dato = stack2.pop();
    //y devolvemos los valores a la pila principal
    while(!stack2.isEmpty()){
      stack1.push(stack2.pop());
    }
    return dato;
  }
}

public class lab8Ejer2 {
  
  public static void main(String[] args) {
    MyQueueWithStacks<Integer> queue = new MyQueueWithStacks<>();
    System.out.println("Hola, ingrese valores a la cola de Enteros, hasta que ingrese cualquier cosa que no sea un entero:");
    Scanner scanner = new Scanner(System.in);
    boolean flag = true;
    do{
      try{
        int dato = scanner.nextInt();
        queue.enqueue(dato);
      }catch(Exception e){
        flag = false;
        //scanner.close();
      }
    }while(flag);
    System.out.println("Cuantos elementos desea desencolar: ");
    scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    for(int i = 0; i < n; i++){
      System.out.println("Quitando tope: "+ queue.dequeue());
    }
  }
}
