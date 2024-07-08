/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

class NodoDoble {
    int valor;
    NodoDoble siguiente, anterior;

    public NodoDoble(int valor) {
        this.valor = valor;
        this.siguiente = this.anterior = null;
    }
}

class ListaDobleEnlazada {
    NodoDoble cabeza;

    public void agregarNodo(int valor) {
        NodoDoble nuevoNodo = new NodoDoble(valor);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoDoble temp = cabeza;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevoNodo;
            nuevoNodo.anterior = temp;
        }
    }

    public void recorrer() {
        NodoDoble temp = cabeza;
        while (temp != null) {
            System.out.print(temp.valor + " ");
            temp = temp.siguiente;
        }
        System.out.println();
    }
}
