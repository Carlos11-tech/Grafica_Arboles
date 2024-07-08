/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;

public class ejemplo {

    public static void main(String[] args) {
        // Crear instancias de las estructuras de datos
        ArbolBinario arbolBinario = new ArbolBinario();
        ArbolAVL arbolAVL = new ArbolAVL();
        ArbolRojoNegro arbolRojoNegro = new ArbolRojoNegro();

        // Agregar valores iniciales a los árboles
        int[] valoresIniciales = {50, 30, 70, 20, 40, 60, 80};
        for (int valor : valoresIniciales) {
            arbolBinario.agregarNodo(valor);
            arbolAVL.agregarNodo(valor);
            arbolRojoNegro.agregarNodo(valor);
        }
        arbolAVL.equilibrar();

        // Configuración de la interfaz gráfica
        JFrame frame = new JFrame("Estructuras de Datos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        VistaArbol panel = new VistaArbol(arbolBinario);
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

        String[] estructuras = {"Arbol Binario", "Arbol AVL", "Arbol Rojo-Negro"};
        JComboBox<String> estructurasComboBox = new JComboBox<>(estructuras);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int valor = Integer.parseInt(valorField.getText());
                String seleccion = (String) estructurasComboBox.getSelectedItem();

                switch (seleccion) {
                    case "Arbol Binario":
                        arbolBinario.agregarNodo(valor);
                        break;
                    case "Arbol AVL":
                        arbolAVL.agregarNodo(valor);
                        arbolAVL.equilibrar();
                        break;
                    case "Arbol Rojo-Negro":
                        arbolRojoNegro.agregarNodo(valor);
                        break;
                }

                valorField.setText("");
                panel.repaint();
                actualizarRecorrido(recorridoArea, arbolBinario, preOrdenButton, inOrdenButton, postOrdenButton);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int valor = Integer.parseInt(valorEliminarField.getText());
                String seleccion = (String) estructurasComboBox.getSelectedItem();

                switch (seleccion) {
                    case "Arbol Binario":
                        arbolBinario.borrarNodo(valor);
                        break;
                    case "Arbol AVL":
                        arbolAVL.borrarNodo(valor);
                        arbolAVL.equilibrar();
                        break;
                    case "Arbol Rojo-Negro":
                        arbolRojoNegro.borrarNodo(valor);
                        break;
                }

                valorEliminarField.setText("");
                panel.repaint();
                actualizarRecorrido(recorridoArea, arbolBinario, preOrdenButton, inOrdenButton, postOrdenButton);
            }
        });

        ActionListener recorridoListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarRecorrido(recorridoArea, arbolBinario, preOrdenButton, inOrdenButton, postOrdenButton);
            }
        };

        preOrdenButton.addActionListener(recorridoListener);
        inOrdenButton.addActionListener(recorridoListener);
        postOrdenButton.addActionListener(recorridoListener);

        controlPanel.add(new JLabel("Estructura:"));
        controlPanel.add(estructurasComboBox);
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

        // Inicializar el área de recorrido con el árbol binario
        actualizarRecorrido(recorridoArea, arbolBinario, preOrdenButton, inOrdenButton, postOrdenButton);
    }

    private static void actualizarRecorrido(JTextArea recorridoArea, ArbolBinario arbol, JRadioButton preOrdenButton, JRadioButton inOrdenButton, JRadioButton postOrdenButton) {
        String recorrido = "";
        if (preOrdenButton.isSelected()) {
            recorrido = obtenerRecorridoConFlechas(arbol.recorrerPreOrden());
        } else if (inOrdenButton.isSelected()) {
            recorrido = obtenerRecorridoConFlechas(arbol.recorrerInOrden());
        } else if (postOrdenButton.isSelected()) {
            recorrido = obtenerRecorridoConFlechas(arbol.recorrerPostOrden());
        }
        recorridoArea.setText(recorrido);
    }

    private static String obtenerRecorridoConFlechas(String recorrido) {
        return recorrido.trim().replace(" ", " → ");
    }
}

