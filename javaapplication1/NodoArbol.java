/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

public class NodoArbol extends Nodo {
    private NodoArbol nodoIzquierdo;
    private NodoArbol nodoDerecho;
    private Color color;

    public NodoArbol(int valor) {
        super(valor);
    }

    public NodoArbol getNodoIzquierdo() {
        return nodoIzquierdo;
    }

    public void setNodoIzquierdo(NodoArbol nodoIzquierdo) {
        this.nodoIzquierdo = nodoIzquierdo;
    }

    public NodoArbol getNodoDerecho() {
        return nodoDerecho;
    }

    public void setNodoDerecho(NodoArbol nodoDerecho) {
        this.nodoDerecho = nodoDerecho;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void insertarNodo(int valor) {
        if (valor < this.valor) {
            if (this.nodoIzquierdo == null) {
                this.nodoIzquierdo = new NodoArbol(valor);
            } else {
                this.nodoIzquierdo.insertarNodo(valor);
            }
        } else {
            if (this.nodoDerecho == null) {
                this.nodoDerecho = new NodoArbol(valor);
            } else {
                this.nodoDerecho.insertarNodo(valor);
            }
        }
    }

    public NodoArbol delete(NodoArbol root, int valor) {
        if (root == null) {
            return root;
        }

        if (valor < root.getValor()) {
            root.setNodoIzquierdo(delete(root.getNodoIzquierdo(), valor));
        } else if (valor > root.getValor()) {
            root.setNodoDerecho(delete(root.getNodoDerecho(), valor));
        } else {
            return null;
        }

        return root;
    }
}
