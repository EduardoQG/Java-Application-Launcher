package es.studium.practicaT1;

import java.io.File;
import java.io.IOException;

public class Modelo {

	File [] archivosCarpeta; 
	
	public void buscarEjecutables (File directorio) {
		
		// Se le pasa un directorio y se saca un array con los archivos que contiene.
		archivosCarpeta = directorio.listFiles();
		
		// Se itera este array: en los directorios se vuelve a realizar la misma acción.
		// Por otra parte, los ficheros ejecutables se ejecutan.
		for (File archivo: archivosCarpeta) {

			if(archivo.isDirectory()) {
				buscarEjecutables(archivo);
			} else {
				if(archivo.getName().endsWith(".exe")) {
					ejecutar(archivo);
				}
			}	
		}
	}

	public void ejecutar(File archivo) {
		Runtime r = Runtime.getRuntime();
		try {
			r.exec(archivo.getPath());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
