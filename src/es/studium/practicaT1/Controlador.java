package es.studium.practicaT1;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JFrame;

public class Controlador {

	Vista vista;
	Modelo modelo;

	File carpeta32;
	String[] listado32;
	File carpeta64;
	String[] listado64;

	File carpetaSeleccionada;

	public Controlador (Vista v, Modelo m)  {

		this.vista = v;
		this.modelo = m;

		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Rellenamos los JList con los nombres de las carpetas que se hallan dentro de las dos carpetas
		// de archivos de programa.
		carpeta32 = new File("C:\\Program Files (x86)\\");
		listado32 = carpeta32.list();
		vista.programas32List.setListData(listado32);

		carpeta64 = new File("C:\\Program Files \\");
		listado64 = carpeta64.list();
		vista.programas64List.setListData(listado64);

		// LISTA DE 32 BITS:
		vista.programas32List.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (e.getClickCount() == 2) {

					// Le decimos que coja el nombre del elemento de la lista en el que se haya hecho doble click,
					String selectedValue = vista.programas32List.getSelectedValue();

					if (selectedValue != null) {

						// ... para luego construir la ruta de la carpeta seleccionada.
						carpetaSeleccionada = new File("C:\\Program Files (x86)\\" + selectedValue);
						// La siguiente función ejecuta los archivos .exe de dicha carpeta y de las subcarpetas.
						modelo.buscarEjecutables(carpetaSeleccionada);
						
						
					}
				}
			}
		});
		
		// LISTA DE 64 BITS:
		vista.programas64List.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (e.getClickCount() == 2) {

					String selectedValue = vista.programas64List.getSelectedValue();

					if (selectedValue != null) {
						
						carpetaSeleccionada = new File("C:\\Program Files\\" + selectedValue);
						
						modelo.buscarEjecutables(carpetaSeleccionada);
						
						
					}
				}
			}
		});
		
		
	}

}
