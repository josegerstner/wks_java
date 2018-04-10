package graficos;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextPane;
import javax.swing.JToolBar;

public class MenuEmergente {
	public static void main(String[] args) {
		MarcoEmergentePopup miMarco = new MarcoEmergentePopup();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
@SuppressWarnings("serial")
class MarcoEmergentePopup extends JFrame{
	public MarcoEmergentePopup(){
		setBounds(400, 200, 500, 400);
		setTitle("Laburando con popups");
		LaminaEmergente miLamina = new LaminaEmergente();
		add(miLamina);
		setVisible(true);
	}
}
@SuppressWarnings("serial")
class LaminaEmergente extends JPanel{
	public LaminaEmergente(){
		setLayout(new BorderLayout());
		JPanel laminaMenu = new JPanel();
		JMenuBar miBarra = new JMenuBar();
		JMenu fuente = new JMenu("Fuente");
		JMenu estilo = new JMenu("Estilo");
		JMenu tamanio = new JMenu("Tamaño");
		miBarra.add(fuente);
		miBarra.add(estilo);
		miBarra.add(tamanio);
		laminaMenu.add(miBarra);
		add(laminaMenu, BorderLayout.NORTH);
		JTextPane miArea = new JTextPane();
		add(miArea, BorderLayout.CENTER);
		JPopupMenu emergente = new JPopupMenu();
		JMenuItem opcion1 = new JMenuItem("Opción 1");
		JMenuItem opcion2 = new JMenuItem("Opción 2");
		JMenuItem opcion3 = new JMenuItem("Opción 3");
		emergente.add(opcion1);
		emergente.add(opcion2);
		emergente.add(opcion3);
		miArea.setComponentPopupMenu(emergente);
		//*******************************************************************/
		//Agregando la barra de herramientas
		JToolBar barra = new JToolBar();
		JButton negritaBarra = new JButton(new ImageIcon("src/graficos/imagenes/negrita.png"));
		JButton cursivaBarra = new JButton(new ImageIcon("src/graficos/imagenes/cursiva.png"));
		barra.add(negritaBarra);
		barra.add(cursivaBarra);
		barra.setOrientation(1);
		add(barra, BorderLayout.WEST);
		
		//*******************************************************************/
	}
}