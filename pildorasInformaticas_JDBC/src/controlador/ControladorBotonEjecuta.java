package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.*;
import vista.*;
public class ControladorBotonEjecuta implements ActionListener{
	public ControladorBotonEjecuta(MarcoAplicacion elMarco){
		this.elMarco = elMarco;
	}
	public void actionPerformed(ActionEvent e) {
		elMarco.resultado.setText("");
		String seleccionSeccion = (String) elMarco.secciones.getSelectedItem();
		String seleccionPais = (String) elMarco.paises.getSelectedItem();
		resultadoConsulta = obj.filtraBBDD(seleccionSeccion, seleccionPais);
		try {
			while(resultadoConsulta.next()){
				elMarco.resultado.append(resultadoConsulta.getString(1) + ", ");
				elMarco.resultado.append(resultadoConsulta.getString(2) + ", ");
				elMarco.resultado.append(resultadoConsulta.getString(3) + ", ");
				elMarco.resultado.append(resultadoConsulta.getString(4) + "\n");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	private MarcoAplicacion elMarco;
	EjecutaConsultas obj = new EjecutaConsultas();
	private ResultSet resultadoConsulta; 
}
