package graficos;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AreaTexto {

	public static void main(String[] args) {
		MarcoAreaTexto miMarco = new MarcoAreaTexto();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		miMarco.setVisible(true);
	}

}
@SuppressWarnings("serial")
class MarcoAreaTexto extends JFrame{
	public MarcoAreaTexto(){
		setTitle("Ejemplo de área de texto");
		setBounds(400, 200, 450, 300);
		
		setLayout(new BorderLayout());
		laminaBotones = new JPanel();
		
		botonInsertar = new JButton("Insertar");		
		botonInsertar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				areaTexto.append("En un lugar de la Mancha cuyo nombre no quiero acordarme... ");
			}
			
		});
		laminaBotones.add(botonInsertar);
		
		botonSaltoLinea = new JButton("Agregar Salto de Línea");
		botonSaltoLinea.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				boolean saltar = !areaTexto.getLineWrap();
				areaTexto.setLineWrap(saltar);
				/*if(saltar){
					botonSaltoLinea.setText("Quitar Salto de Línea");
				}else{
					botonSaltoLinea.setText("Agregar Salto de Línea");
				}*/
				//podemos usar un operador ternario para evaluar
				botonSaltoLinea.setText(saltar ? "Quitar Salto de Línea" : "Agregar Salto de Línea");
			}
		});
		laminaBotones.add(botonSaltoLinea);
		
		add(laminaBotones, BorderLayout.SOUTH);
		
		areaTexto = new JTextArea(8, 20);
		laminaConBarras = new JScrollPane(areaTexto);
		add(laminaConBarras, BorderLayout.CENTER);
	}
	private JPanel laminaBotones;
	private JButton botonInsertar, botonSaltoLinea;
	private JTextArea areaTexto;
	private JScrollPane laminaConBarras;
}
