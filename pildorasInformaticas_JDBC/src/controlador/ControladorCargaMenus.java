package controlador;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import modelo.CargaMenus;
import vista.MarcoAplicacion;

public class ControladorCargaMenus extends WindowAdapter{
	public ControladorCargaMenus(MarcoAplicacion elMarco){
		this.elMarco = elMarco;
	}
	public void windowOpened(WindowEvent e){
		obj.ejecutaConsultas();
		try{
			while(obj.rs.next()){
				elMarco.secciones.addItem(obj.rs.getString(1));
			}
			while(obj.rs2.next()){
				elMarco.paises.addItem(obj.rs2.getString(1));
			}
			obj.rs.close();
			obj.rs2.close();
		}catch(Exception ex){
			System.out.println("ERROR en CONTROLADOR CARGA MENUS");
			ex.printStackTrace();
		}
	}
	CargaMenus obj = new CargaMenus();
	private MarcoAplicacion elMarco;
}
