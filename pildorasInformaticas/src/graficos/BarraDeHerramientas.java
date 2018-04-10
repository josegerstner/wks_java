package graficos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class BarraDeHerramientas {

	public static void main(String[] args) {
		MarcoBarraHerramientas mimarco = new MarcoBarraHerramientas();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
@SuppressWarnings("serial")
class MarcoBarraHerramientas extends JFrame{
	public MarcoBarraHerramientas(){
		setTitle("Barra de herramientas con acciones");
		setBounds(450, 200, 500, 350);
		lamina = new JPanel();
		add(lamina);
		Action accionAmarillo = new ActionColor("Amarillo", new ImageIcon("src/graficos/imagenes/zapdos.png"), Color.YELLOW);
		Action accionAzul = new ActionColor("Azul", new ImageIcon("src/graficos/imagenes/articuno.png"), Color.BLUE);
		Action accionRojo = new ActionColor("Rojo", new ImageIcon("src/graficos/imagenes/moltres.png"), Color.RED);
		Action accionSalir = new AbstractAction("Salir", new ImageIcon("src/graficos/imagenes/picartroll_small.png")){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		};
		JMenu menu = new JMenu("Color");
		menu.add(accionAmarillo);
		menu.add(accionAzul);
		menu.add(accionRojo);
		JMenuBar barraMenu = new JMenuBar();
		barraMenu.add(menu);
		setJMenuBar(barraMenu);
		//Construcción de la barra de herramientas
		JToolBar barra = new JToolBar();
		barra.add(accionAmarillo);
		barra.add(accionAzul);
		barra.add(accionRojo);
		barra.addSeparator();
		barra.add(accionSalir);
		add(barra, BorderLayout.NORTH);
	}
	private class ActionColor extends AbstractAction{
		public ActionColor(String nombre, Icon icono, Color c){
			putValue(Action.NAME, nombre);
			putValue(Action.SMALL_ICON, icono);
			putValue(Action.SHORT_DESCRIPTION, "Color de fondo..." + nombre);
			putValue("Color", c);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			Color c = (Color) getValue("Color");
			lamina.setBackground(c);
		}
	}
	private JPanel lamina;
}