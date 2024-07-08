/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.util.ArrayList;
import java.util.HashMap;

class Grafo {
    private HashMap<Integer, ArrayList<Integer>> adyacencias;

    public Grafo() {
        adyacencias = new HashMap<>();
    }

    public void agregarNodo(int valor) {
        adyacencias.putIfAbsent(valor, new ArrayList<>());
    }

    public void agregarArista(int origen, int destino) {
        adyacencias.get(origen).add(destino);
        adyacencias.get(destino).add(origen); // Grafo no dirigido
    }

    public void recorrer() {
        for (int nodo : adyacencias.keySet()) {
            System.out.print("Nodo " + nodo + ": ");
            for (int adyacente : adyacencias.get(nodo)) {
                System.out.print(adyacente + " ");
            }
            System.out.println();
        }
    }
}

