package Estructuras;

class Nodo<T> {
  protected T dato;
  protected Nodo<T> siguiente;

  public Nodo(T dato) {
    this.dato = dato;
    this.siguiente = null;
  }

  public T getDato() {
    return dato;
  }

  public void setDato(T dato) {
    this.dato = dato;
  }

  public Nodo<T> getSiguiente() {
    return siguiente;
  }

  public void setSiguiente(Nodo<T> siguiente) {
    this.siguiente = siguiente;
  }
}

public class MyLinkedList<T>{
  public Nodo<T> cabeza, tail;

  public MyLinkedList() {
    this.cabeza = null;
  }

  public T getHead(){
    return cabeza.getDato();
  }
  public T getTail(){
    return tail.getDato();
  }

  public void agregarAlFinal(T dato) {
    Nodo<T> nuevoNodo = new Nodo<>(dato);
    if (cabeza == null) {
      cabeza = nuevoNodo;
    } else {
      Nodo<T> actual = cabeza;
      while (actual.siguiente != null) {
        actual = actual.getSiguiente();
      }
      actual.siguiente = nuevoNodo;
    }
    tail = nuevoNodo;
  }

  public void mostrarLista() {
    Nodo<T> actual = cabeza;
    while (actual != null) {
      System.out.print(actual.dato + " ");
      actual = actual.siguiente;
    }
    System.out.println();
  }

  public void eliminarNodo(T valor) {
    if (cabeza == null) {
      return;
    }
    if (cabeza.dato == valor) {
      cabeza = cabeza.siguiente;
      return;
    }
    Nodo<T> actual = cabeza;
    while (actual.siguiente != null) {
      if (actual.siguiente.dato == valor) {
        if(actual.siguiente == tail)
          tail = actual;
        actual.siguiente = actual.siguiente.siguiente;
        return;
      }
      actual = actual.siguiente;
    }
  }

  public Nodo<T> buscarNodo(T valor) {
    Nodo<T> actual = cabeza;
    while (actual != null) {
      if (actual.dato == valor) {
        return actual;
      }
      actual = actual.siguiente;
    }
    return null;
  }
}