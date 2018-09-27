package controlador;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import modelo.CargaSecciones;
import vista.Marco_Aplicacion2;

public class ControladorCargaSecciones extends WindowAdapter{
	
	public ControladorCargaSecciones(Marco_Aplicacion2 elMarco) {
		
		this.elMarco = elMarco;
		
	}
	
	public void windowOpened(WindowEvent evento) {
		
		obj.ejecutaConsulta();
		
		try {
			
			while(obj.rs.next()) {
				
				elMarco.secciones.addItem(obj.rs.getString(1));
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	CargaSecciones obj = new CargaSecciones();
	
	private Marco_Aplicacion2 elMarco;

}
