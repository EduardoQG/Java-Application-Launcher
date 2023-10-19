package es.studium.practicaT1;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Vista vista = new Vista();
		Modelo modelo = new Modelo();
		
		new Controlador(vista, modelo);
	}

}
