package graficos;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class PruebaAcciones {
	public static void main(String[] args) {
		MarcoAccion mimarco = new MarcoAccion();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
@SuppressWarnings("serial")
class MarcoAccion extends JFrame{
	public MarcoAccion(){
		setTitle("Prueba acciones");
		setBounds(450, 200, 500, 350);
		add(new PanelAccion());
	}
}
@SuppressWarnings("serial")
class PanelAccion extends JPanel{
	public PanelAccion(){
		ActionColor actionAmarillo = new ActionColor("Amarillo", new ImageIcon("src/graficos/imagenes/zapdos.png"), Color.YELLOW);
		ActionColor actionAzul = new ActionColor("Azul", new ImageIcon("src/graficos/imagenes/articuno.png"), Color.BLUE);
		ActionColor actionRojo = new ActionColor("Rojo", new ImageIcon("src/graficos/imagenes/moltres.png"), Color.RED);
		//los JButton también permiten instanciarse con una acción en el constructor 
		add(new JButton(actionAmarillo));
		add(new JButton(actionAzul));
		add(new JButton(actionRojo));
		//creamos el mapa de entrada
		InputMap mapaEntrada = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		//Creamos las combinaciones de teclas
		KeyStroke teclaAmarillo = KeyStroke.getKeyStroke("ctrl A");
		KeyStroke teclaAzul = KeyStroke.getKeyStroke("ctrl B");
		KeyStroke teclaRojo = KeyStroke.getKeyStroke("ctrl R");
		//Asignamos las combinaciones de teclas a objetos
		mapaEntrada.put(teclaAmarillo, "fondoAmarillo");
		mapaEntrada.put(teclaAzul, "fondoAzul");
		mapaEntrada.put(teclaRojo, "fondoRojo");
		//asignar combinación de teclas a objeto
		ActionMap mapaAccion = getActionMap();
		//asignar objeto a acción
		mapaAccion.put("fondoAmarillo", actionAmarillo);
		mapaAccion.put("fondoAzul", actionAzul);
		mapaAccion.put("fondoRojo", actionRojo);
	}
	private class ActionColor extends AbstractAction{
		public ActionColor(String nombre, Icon icono, Color colorBoton){
			putValue(Action.NAME, nombre);
			putValue(Action.SMALL_ICON, icono);
			putValue(Action.SHORT_DESCRIPTION, "Poner la lámina de color " + nombre);
			putValue("colorDeFondo", colorBoton);
		}
		public void actionPerformed(ActionEvent e){
			Color c = (Color) getValue("colorDeFondo");
			setBackground(c);
			System.out.println("Botón presionado: " + getValue(Action.NAME));
		}
	}
}
