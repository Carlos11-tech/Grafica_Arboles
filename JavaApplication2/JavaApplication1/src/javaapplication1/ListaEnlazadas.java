/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

class NodoLista {
    int valor;
    NodoLista siguiente;

    public NodoLista(int valor) {
        this.valor = valor;
        this.siguiente = null;
    }
}

class ListaEnlazada {
    NodoLista cabeza;

    public void agregarNodo(int valor) {
        NodoLista nuevoNodo = new NodoLista(valor);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoLista temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevoNodo;
        }
    }

    public void recorrer() {
        NodoLista temp = cabeza;
        while (temp != null) {
            System.out.print(temp.valor + " ");
            temp = temp.siguiente;
        }
        System.out.println();
    }
}
