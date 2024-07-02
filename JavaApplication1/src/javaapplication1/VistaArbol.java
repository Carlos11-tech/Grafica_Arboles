/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class VistaArbol extends JPanel {

    private ArbolBinario arbol;

    public VistaArbol(ArbolBinario arbol) {
        this.arbol = arbol;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        pintarArbol(g, getWidth() / 2, 30, arbol.raiz, getWidth() / 4);
    }

    private void pintarArbol(Graphics g, int x, int y, Nodo nodo, int xOffset) {
        if (nodo == null) {
            return;
        }

        g.setColor(Color.BLACK);
        g.fillOval(x - 15, y - 15, 30, 30);
        g.setColor(Color.GREEN);
        g.drawString(Integer.toString(nodo.valor), x - 7, y + 5);

        if (nodo.izquierdo != null) {
            g.drawLine(x, y, x - xOffset, y + 50);
            pintarArbol(g, x - xOffset, y + 50, nodo.izquierdo, xOffset / 2);
        }

        if (nodo.derecho != null) {
            g.drawLine(x, y, x + xOffset, y + 50);
            pintarArbol(g, x + xOffset, y + 50, nodo.derecho, xOffset / 2);
        }
    }
}
