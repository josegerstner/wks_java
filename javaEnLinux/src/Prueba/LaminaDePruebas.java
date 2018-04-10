package Prueba;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class LaminaDePruebas extends JPanel{
	public LaminaDePruebas(){
		setLayout(new BorderLayout());
		JLabel miEtiqueta = new JLabel("RUperto murió");
		add(miEtiqueta, BorderLayout.NORTH);
	}
}