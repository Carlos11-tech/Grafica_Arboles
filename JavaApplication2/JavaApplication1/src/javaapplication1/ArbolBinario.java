/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;
import java.util.ArrayList;
import java.util.List;

public class ArbolBinario {
    Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public void agregarNodo(int valor) {
        raiz = agregarRecursivo(raiz, valor);
    }

    private Nodo agregarRecursivo(Nodo actual, int valor) {
        if (actual == null) {
            return new Nodo(valor);
        }

        if (valor < actual.valor) {
            actual.izquierdo = agregarRecursivo(actual.izquierdo, valor);
        } else if (valor > actual.valor) {
            actual.derecho = agregarRecursivo(actual.derecho, valor);
        }

        return actual;
    }

    public void borrarNodo(int valor) {
        raiz = borrarRecursivo(raiz, valor);
    }

    private Nodo borrarRecursivo(Nodo actual, int valor) {
        if (actual == null) {
            return null;
        }

        if (valor == actual.valor) {
            if (actual.izquierdo == null && actual.derecho == null) {
                return null;
            }

            if (actual.derecho == null) {
                return actual.izquierdo;
            }

            if (actual.izquierdo == null) {
                return actual.derecho;
            }

            int menorValor = encontrarMenorValor(actual.derecho);
            actual.valor = menorValor;
            actual.derecho = borrarRecursivo(actual.derecho, menorValor);
            return actual;

        }
        if (valor < actual.valor) {
            actual.izquierdo = borrarRecursivo(actual.izquierdo, valor);
            return actual;
        }

        actual.derecho = borrarRecursivo(actual.derecho, valor);
        return actual;
    }

    private int encontrarMenorValor(Nodo raiz) {
        return raiz.izquierdo == null ? raiz.valor : encontrarMenorValor(raiz.izquierdo);
    }

    public String recorrerPreOrden() {
        return recorrerPreOrdenRecursivo(raiz);
    }

    private String recorrerPreOrdenRecursivo(Nodo nodo) {
        if (nodo == null) {
            return "";
        }
        return nodo.valor + " " + recorrerPreOrdenRecursivo(nodo.izquierdo) + recorrerPreOrdenRecursivo(nodo.derecho);
    }

    public String recorrerInOrden() {
        return recorrerInOrdenRecursivo(raiz);
    }

    private String recorrerInOrdenRecursivo(Nodo nodo) {
        if (nodo == null) {
            return "";
        }
        return recorrerInOrdenRecursivo(nodo.izquierdo) + nodo.valor + " " + recorrerInOrdenRecursivo(nodo.derecho);
    }

    public String recorrerPostOrden() {
        return recorrerPostOrdenRecursivo(raiz);
    }

    private String recorrerPostOrdenRecursivo(Nodo nodo) {
        if (nodo == null) {
            return "";
        }
        return recorrerPostOrdenRecursivo(nodo.izquierdo) + recorrerPostOrdenRecursivo(nodo.derecho) + nodo.valor + " ";
    }
}
