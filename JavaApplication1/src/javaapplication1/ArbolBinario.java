/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

public class ArbolBinario {

    Nodo raiz;

    public void agregarNodo(int valor) {
        raiz = agregarNodoRecursivo(raiz, valor);
    }

    private Nodo agregarNodoRecursivo(Nodo actual, int valor) {
        if (actual == null) {
            return new Nodo(valor);
        }

        if (valor < actual.valor) {
            actual.izquierdo = agregarNodoRecursivo(actual.izquierdo, valor);
        } else if (valor > actual.valor) {
            actual.derecho = agregarNodoRecursivo(actual.derecho, valor);
        } else {
            return actual; // valor ya existe
        }

        return actual;
    }

    public void borrarNodo(int valor) {
        raiz = borrarNodoRecursivo(raiz, valor);
    }

    private Nodo borrarNodoRecursivo(Nodo actual, int valor) {
        if (actual == null) {
            return null;
        }

        if (valor == actual.valor) {
            // Nodo a eliminar encontrado
            if (actual.izquierdo == null && actual.derecho == null) {
                return null;
            }
            if (actual.derecho == null) {
                return actual.izquierdo;
            }
            if (actual.izquierdo == null) {
                return actual.derecho;
            }

            int valorMenor = encontrarValorMenor(actual.derecho);
            actual.valor = valorMenor;
            actual.derecho = borrarNodoRecursivo(actual.derecho, valorMenor);
            return actual;
        }

        if (valor < actual.valor) {
            actual.izquierdo = borrarNodoRecursivo(actual.izquierdo, valor);
            return actual;
        }

        actual.derecho = borrarNodoRecursivo(actual.derecho, valor);
        return actual;
    }

    private int encontrarValorMenor(Nodo nodo) {
        return nodo.izquierdo == null ? nodo.valor : encontrarValorMenor(nodo.izquierdo);
    }

    public String recorrerPreOrden() {
        StringBuilder recorrido = new StringBuilder();
        recorrerPreOrdenRecursivo(raiz, recorrido);
        return recorrido.toString();
    }

    private void recorrerPreOrdenRecursivo(Nodo nodo, StringBuilder recorrido) {
        if (nodo != null) {
            recorrido.append(nodo.valor).append(" ");
            recorrerPreOrdenRecursivo(nodo.izquierdo, recorrido);
            recorrerPreOrdenRecursivo(nodo.derecho, recorrido);
        }
    }

    public String recorrerInOrden() {
        StringBuilder recorrido = new StringBuilder();
        recorrerInOrdenRecursivo(raiz, recorrido);
        return recorrido.toString();
    }

    private void recorrerInOrdenRecursivo(Nodo nodo, StringBuilder recorrido) {
        if (nodo != null) {
            recorrerInOrdenRecursivo(nodo.izquierdo, recorrido);
            recorrido.append(nodo.valor).append(" ");
            recorrerInOrdenRecursivo(nodo.derecho, recorrido);
        }
    }

    public String recorrerPostOrden() {
        StringBuilder recorrido = new StringBuilder();
        recorrerPostOrdenRecursivo(raiz, recorrido);
        return recorrido.toString();
    }

    private void recorrerPostOrdenRecursivo(Nodo nodo, StringBuilder recorrido) {
        if (nodo != null) {
            recorrerPostOrdenRecursivo(nodo.izquierdo, recorrido);
            recorrerPostOrdenRecursivo(nodo.derecho, recorrido);
            recorrido.append(nodo.valor).append(" ");
        }
    }
}
