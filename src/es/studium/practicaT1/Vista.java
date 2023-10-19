package es.studium.practicaT1;

import javax.swing.*;
import java.awt.*;

public class Vista extends JFrame {

	/* DUDAS:
	 *  - Si hay archivos ejecutables dentro de subcarpetas, accedo también a estas o paso?
	 *  - Debería pasar al modelo el cuerpo de los mouselistener (lo que hacen)?
	 *  
	 *  
	 */ 
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JList<String> programas64List;
    JList<String> programas32List;

    public Vista() {
        setTitle("Lanzador de Aplicaciones");
        setSize(600, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        
        JLabel lblProgramas64 = new JLabel("Arquitectura de 64 bits:");
        JLabel lblProgramas32 = new JLabel("Arquitectura de 32 bits:");

        // Se crean las listas para guardar los nombres de los archivos y se les da un tamaño visible.
        programas64List = new JList<String>();
        programas32List = new JList<String>();
        programas64List.setVisibleRowCount(15);
        programas32List.setVisibleRowCount(15);

        // Se añaden a los JScrollPane para que se vean en paneles scrolleables.
        JScrollPane scrollPane64 = new JScrollPane(programas32List);
        scrollPane64.setPreferredSize(new Dimension(240, 300));
        JScrollPane scrollPane32 = new JScrollPane(programas64List);
        scrollPane32.setPreferredSize(new Dimension(240, 300));

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 20));

        JPanel panel64 = new JPanel();
        panel64.setLayout(new BorderLayout());
        panel64.add(lblProgramas32, BorderLayout.NORTH);
        panel64.add(scrollPane64, BorderLayout.CENTER);

        JPanel panel32 = new JPanel();
        panel32.setLayout(new BorderLayout());
        panel32.add(lblProgramas64, BorderLayout.NORTH);
        panel32.add(scrollPane32, BorderLayout.CENTER);

        panel.add(panel64);
        panel.add(panel32);

        add(panel);

        setVisible(true);
    }

}