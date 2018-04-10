package ejerciciopractico_layouts;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class LaminaBotones extends JPanel{
	public LaminaBotones(String titulo, String[] opciones){
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		//creamos un grupo e instanciamos los botones
		grupo = new ButtonGroup();
		for(int i=0; i<opciones.length; i++){
			JRadioButton boton = new JRadioButton(opciones[i]);
			//el método setActionCommand establece el tipo de botón
			boton.setActionCommand(opciones[i]);
			add(boton);
			grupo.add(boton);
			//el botón seleccionado será el que cumpla la condición
			boton.setSelected(i==0);
		}
	}
	public String dameSeleccion(){
		//el método getSelection me devuelve el botón seleccionado
		//el método getActionCommand me devuelve el String de ese botón
		return grupo.getSelection().getActionCommand();
	}
	private ButtonGroup grupo;
}
