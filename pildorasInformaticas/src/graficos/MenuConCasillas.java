package graficos;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;
import javax.swing.text.StyledEditorKit;

public class MenuConCasillas {
	public static void main(String[] args) {
		MenuProcesador miMarco = new MenuProcesador();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
@SuppressWarnings("serial")
class MenuProcesador extends JFrame{
	public MenuProcesador(){
		setBounds(400,200,500,400);
		LaminaProcesador miLamina = new LaminaProcesador();
		add(miLamina);
		setTitle("Procesador de textos");
		setVisible(true);
	}
}
@SuppressWarnings("serial")
class LaminaProcesador extends JPanel{
	public LaminaProcesador(){
		setLayout(new BorderLayout());
		//----------------------------------
		JPanel laminaMenu = new JPanel();
		JMenuBar miBarra = new JMenuBar();
		fuente = new JMenu("Fuente");
		estilo = new JMenu("Estilo");
		tamanio = new JMenu("Tamaño");
		//------------------------------------
		configuraMenu("Arial", "Fuente", "Arial", 1, 1);
		configuraMenu("Courier", "Fuente", "Courier", 1, 1);
		configuraMenu("Verdana", "Fuente", "Verdana", 1, 1);
		
		//configuraMenu("Negrita", "Estilo", "", Font.BOLD, 1);
		//configuraMenu("Cursiva", "Estilo", "", Font.ITALIC, 1);
		JCheckBoxMenuItem negrita = new JCheckBoxMenuItem("Negrita", new ImageIcon("src/graficos/imagenes/zapdos.png"));
		JCheckBoxMenuItem cursiva = new JCheckBoxMenuItem("Cursiva", new ImageIcon("src/graficos/imagenes/articuno.png"));
		negrita.addActionListener(new StyledEditorKit.BoldAction());
		cursiva.addActionListener(new StyledEditorKit.ItalicAction());
		estilo.add(negrita);
		estilo.add(cursiva);
		//configuraMenu("Pequeña", "Tamaño", "", 9, 12);
		//configuraMenu("Mediana", "Tamaño", "", 9, 16);
		//configuraMenu("Grande", "Tamaño", "", 9, 20);
		//configuraMenu("Muy Grande", "Tamaño", "", 9, 24);
		ButtonGroup tamanioLetra = new ButtonGroup();
		JRadioButtonMenuItem doce = new JRadioButtonMenuItem("12");
		JRadioButtonMenuItem dieciseis = new JRadioButtonMenuItem("16");
		JRadioButtonMenuItem veinte = new JRadioButtonMenuItem("20");
		JRadioButtonMenuItem veinticuatro = new JRadioButtonMenuItem("24");
		//veinticuatro.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
		tamanioLetra.add(doce);
		tamanioLetra.add(dieciseis);
		tamanioLetra.add(veinte);
		tamanioLetra.add(veinticuatro);
		doce.addActionListener(new StyledEditorKit.FontSizeAction("Cambia tamaño", 12));
		dieciseis.addActionListener(new StyledEditorKit.FontSizeAction("Cambia tamaño", 16));
		veinte.addActionListener(new StyledEditorKit.FontSizeAction("Cambia tamaño", 20));
		veinticuatro.addActionListener(new StyledEditorKit.FontSizeAction("Cambia tamaño", 24));
		
		tamanio.add(doce);
		tamanio.add(dieciseis);
		tamanio.add(veinte);
		tamanio.add(veinticuatro);
		
		//----------------------------------
		miBarra.add(fuente);
		miBarra.add(estilo);
		miBarra.add(tamanio);
		laminaMenu.add(miBarra);
		add(laminaMenu, BorderLayout.NORTH);
		//------------------------------------
		
		miArea = new JTextPane();
		add(miArea, BorderLayout.CENTER);
	}
	public void configuraMenu(String rotulo, String menu, String tipoLetra, int estilos, int tamanioFuente){
		//------------------------------------
		JMenuItem elementoMenu = new JMenuItem(rotulo);
		if(menu=="Fuente"){
			fuente.add(elementoMenu);
			if(tipoLetra=="Arial"){
				elementoMenu.addActionListener(new StyledEditorKit.FontFamilyAction("Cambia tipo", "Arial"));
			}else if(tipoLetra=="Courier"){
				elementoMenu.addActionListener(new StyledEditorKit.FontFamilyAction("Cambia tipo", "Courier"));
			}else if(tipoLetra=="Verdana"){
				elementoMenu.addActionListener(new StyledEditorKit.FontFamilyAction("Cambia tipo", "Verdana"));
			}
		}else if(menu=="Estilo"){
			estilo.add(elementoMenu);
			if(estilos==Font.BOLD){
				elementoMenu.addActionListener(new StyledEditorKit.BoldAction());
			}else if(estilos == Font.ITALIC){
				elementoMenu.addActionListener(new StyledEditorKit.ItalicAction());
			}
		}else if(menu=="Tamaño"){
			tamanio.add(elementoMenu);
			elementoMenu.addActionListener(new StyledEditorKit.FontSizeAction("Cambia tamaño", tamanioFuente));
		}	
	}	
	JTextPane miArea;
	JMenu fuente, estilo, tamanio;
	Font letras;
}