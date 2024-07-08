/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;

public class VistaArbol extends JPanel {
    private ArbolBinario arbol;

    public VistaArbol(ArbolBinario arbol) {
        this.arbol = arbol;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (arbol.raiz != null) {
            dibujarNodo(g, arbol.raiz, getWidth() / 2, 30, getWidth() / 4);
        }
    }

    private void dibujarNodo(Graphics g, Nodo nodo, int x, int y, int xOffset) {
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.setColor(Color.BLACK);
        g.drawOval(x - 15, y - 15, 30, 30);
        g.drawString(Integer.toString(nodo.valor), x - 6, y + 4);

        if (nodo.izquierdo != null) {
            g.drawLine(x - 5, y + 5, x - xOffset + 5, y + 50 - 5);
            dibujarNodo(g, nodo.izquierdo, x - xOffset, y + 50, xOffset / 2);
        }

        if (nodo.derecho != null) {
            g.drawLine(x + 5, y + 5, x + xOffset - 5, y + 50 - 5);
            dibujarNodo(g, nodo.derecho, x + xOffset, y + 50, xOffset / 2);
        }
    }
}

