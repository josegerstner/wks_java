package graficos;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MarcoMenu {
	public static void main(String[] args) {
		MenuFrame miMarco = new MenuFrame();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
@SuppressWarnings("serial")
class MenuFrame extends JFrame{
	public MenuFrame(){
		setBounds(400,200,400,400);
		MenuLamina miLamina = new MenuLamina();
		add(miLamina);
		setTitle("Probando menús");
		setVisible(true);
	}
}
@SuppressWarnings("serial")
class MenuLamina extends JPanel{
	public MenuLamina(){
		//creamos la barra de menú, donde se alojarán los menús
		JMenuBar miBarra = new JMenuBar();
		
		//creamos los menús
		JMenu archivo = new JMenu("Archivo");
		JMenu edicion = new JMenu("Edición");
		JMenu herramientas = new JMenu("Herramientas");
		JMenu opciones = new JMenu("Opciones");
		
		//creamos las opciones que tendrán los menús
		JMenuItem guardar = new JMenuItem("Guardar");
		JMenuItem guardarComo = new JMenuItem("Guardar como...");
		
		JMenuItem cortar = new JMenuItem("Cortar", new ImageIcon("src/graficos/imagenes/articuno.png"));
		JMenuItem copiar = new JMenuItem("Copiar", new ImageIcon("src/graficos/imagenes/zapdos.png"));
		//cambiamos la alineación del texto con respecto de la imagen
		copiar.setHorizontalTextPosition(SwingConstants.LEFT);
		JMenuItem pegar = new JMenuItem("Pegar", new ImageIcon("src/graficos/imagenes/moltres.png"));
		
		JMenuItem generales = new JMenuItem("Generales");
		
		JMenuItem opcion1 = new JMenuItem("Opción 1");
		JMenuItem opcion2 = new JMenuItem("Opción 2");
		
		//agregar las opciones a los menús
		archivo.add(guardar);
		archivo.add(guardarComo);
		
		edicion.add(cortar);
		edicion.add(copiar);
		edicion.add(pegar);
		edicion.addSeparator();
		opciones.add(opcion1);
		opciones.add(opcion2);
		
		edicion.add(opciones);
		
		herramientas.add(generales);
		
		//agregamos los menús a la barra
		miBarra.add(archivo);
		miBarra.add(edicion);
		miBarra.add(herramientas);
		
		//agregamos la barra a la lámina
		add(miBarra);
	}
}