/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udemy.poo.codigo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Sou Akiyama
 */
public class Lamina extends JPanel implements ActionListener{
    private JPanel panel = new JPanel();
    private JButton button = new JButton("Agregar");
    private JTextField cajaTexto = new JTextField(30);
    private JTextArea areaTexto = new JTextArea(10, 20);
    private JScrollPane scroll;

    public Lamina() {
        // Añadir el scroll al área de texto
        this.scroll = new JScrollPane(this.areaTexto);
        
        // Agregar evento al oyente del botón
        this.button.addActionListener(this);
        
        // Agregar los componentes al panel
        panel.add(button);
        panel.add(cajaTexto);
        
        // Crear el BorderLayout
        JPanel borderPanel = new JPanel(new BorderLayout());
        borderPanel.setBorder(new TitledBorder("Componentes de Swing"));
        borderPanel.add(panel, BorderLayout.CENTER);
        this.add(borderPanel);
        this.add(scroll);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object origen = e.getSource();
        
        // Si el botón genera el evento...
        if (origen == this.button) {
            // Tomar el texto de caja de Texto
            this.areaTexto.append(this.cajaTexto.getText() + "\n");
            
            // Limpiar la caja de texto
            this.cajaTexto.setText("");
            
            // Transferir el focus
            this.button.transferFocus();
        }
    }
    
}
