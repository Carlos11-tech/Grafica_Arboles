/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;

public class ejemplo {

    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        arbol.agregarNodo(18);
        arbol.agregarNodo(12);
        arbol.agregarNodo(25);
        arbol.agregarNodo(17);
        arbol.agregarNodo(54);
        arbol.agregarNodo(23);
        arbol.agregarNodo(92);
        arbol.agregarNodo(78);
        arbol.agregarNodo(1);
        arbol.agregarNodo(7);
        arbol.agregarNodo(2);
        arbol.agregarNodo(9);

        JFrame frame = new JFrame("Árbol Binario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        VistaArbol panel = new VistaArbol(arbol);
        frame.add(panel, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        JTextField valorField = new JTextField(5);
        JTextField valorEliminarField = new JTextField(5);
        JButton addButton = new JButton("Añadir Nodo");
        JButton deleteButton = new JButton("Eliminar Nodo");

        JRadioButton preOrdenButton = new JRadioButton("PreOrden");
        JRadioButton inOrdenButton = new JRadioButton("InOrden");
        JRadioButton postOrdenButton = new JRadioButton("PostOrden");

        ButtonGroup recorridoGroup = new ButtonGroup();
        recorridoGroup.add(preOrdenButton);
        recorridoGroup.add(inOrdenButton);
        recorridoGroup.add(postOrdenButton);

        JTextArea recorridoArea = new JTextArea(5, 40);
        recorridoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(recorridoArea);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int valor = Integer.parseInt(valorField.getText());
                arbol.agregarNodo(valor);
                valorField.setText("");
                panel.repaint();
                actualizarRecorrido(recorridoArea, arbol, preOrdenButton, inOrdenButton, postOrdenButton);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int valor = Integer.parseInt(valorEliminarField.getText());
                arbol.borrarNodo(valor);
                valorEliminarField.setText("");
                panel.repaint();
                actualizarRecorrido(recorridoArea, arbol, preOrdenButton, inOrdenButton, postOrdenButton);
            }
        });

        ActionListener recorridoListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarRecorrido(recorridoArea, arbol, preOrdenButton, inOrdenButton, postOrdenButton);
            }
        };

        preOrdenButton.addActionListener(recorridoListener);
        inOrdenButton.addActionListener(recorridoListener);
        postOrdenButton.addActionListener(recorridoListener);

        controlPanel.add(new JLabel("Valor:"));
        controlPanel.add(valorField);
        controlPanel.add(addButton);
        controlPanel.add(new JLabel("Valor a eliminar:"));
        controlPanel.add(valorEliminarField);
        controlPanel.add(deleteButton);
        controlPanel.add(preOrdenButton);
        controlPanel.add(inOrdenButton);
        controlPanel.add(postOrdenButton);

        frame.add(controlPanel, BorderLayout.SOUTH);
        frame.add(scrollPane, BorderLayout.NORTH);
        frame.setVisible(true);
    }

    private static void actualizarRecorrido(JTextArea recorridoArea, ArbolBinario arbol, JRadioButton preOrdenButton, JRadioButton inOrdenButton, JRadioButton postOrdenButton) {
        String recorrido = "";
        if (preOrdenButton.isSelected()) {
            recorrido = arbol.recorrerPreOrden();
        } else if (inOrdenButton.isSelected()) {
            recorrido = arbol.recorrerInOrden();
        } else if (postOrdenButton.isSelected()) {
            recorrido = arbol.recorrerPostOrden();
        }
        recorridoArea.setText(recorrido);
    }
}

