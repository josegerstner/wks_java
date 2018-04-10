package procesadorDeTextos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

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
import javax.swing.KeyStroke;
import javax.swing.text.StyledEditorKit;

public class ProcesadorTextos {
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
		
		configuraMenu("Negrita", "Estilo", "", Font.BOLD, 1);
		configuraMenu("Cursiva", "Estilo", "", Font.ITALIC, 1);
		
		configuraMenu("Pequeña", "Tamaño", "", 9, 12);
		configuraMenu("Mediana", "Tamaño", "", 9, 16);
		configuraMenu("Grande", "Tamaño", "", 9, 20);
		configuraMenu("Muy Grande", "Tamaño", "", 9, 24);
		//----------------------------------
		miBarra.add(fuente);
		miBarra.add(estilo);
		miBarra.add(tamanio);
		laminaMenu.add(miBarra);
		add(laminaMenu, BorderLayout.NORTH);
		//------------------------------------
		
		miArea = new JTextPane();
		add(miArea, BorderLayout.CENTER);
		JPopupMenu emergente = new JPopupMenu();
		JMenuItem negritaE = new JMenuItem("Negrita");
		JMenuItem cursivaE = new JMenuItem("Cursiva");
		negritaE.addActionListener(new StyledEditorKit.BoldAction());
		cursivaE.addActionListener(new StyledEditorKit.ItalicAction());
		emergente.add(negritaE);
		emergente.add(cursivaE);
		miArea.setComponentPopupMenu(emergente);
		
//*******************************************************************/
		
		/*//Agregando la barra de herramientas
		JToolBar barra = new JToolBar();
		//BOTONES NEGRITA, CURSIVA SUBRAYAR
		JButton negritaBarra = new JButton(new ImageIcon("src/graficos/imagenes/negrita.png"));
		JButton cursivaBarra = new JButton(new ImageIcon("src/graficos/imagenes/cursiva.png"));
		JButton subrayarBarra = new JButton(new ImageIcon("src/graficos/imagenes/subrayar.png"));
		negritaBarra.addActionListener(new StyledEditorKit.BoldAction());
		cursivaBarra.addActionListener(new StyledEditorKit.ItalicAction());
		subrayarBarra.addActionListener(new StyledEditorKit.UnderlineAction());
		barra.add(negritaBarra);
		barra.add(cursivaBarra);
		barra.add(subrayarBarra);
		
		//BOTONES COLOREAR EL TEXTO
		JButton amarilloBarra = new JButton(new ImageIcon("src/graficos/imagenes/zapdos.png"));
		JButton azulBarra = new JButton(new ImageIcon("src/graficos/imagenes/articuno.png"));
		JButton rojoBarra = new JButton(new ImageIcon("src/graficos/imagenes/moltres.png"));
		amarilloBarra.addActionListener(new StyledEditorKit.ForegroundAction("Poner texto en amarillo", Color.YELLOW));
		azulBarra.addActionListener(new StyledEditorKit.ForegroundAction("Poner texto en azul", Color.BLUE));
		rojoBarra.addActionListener(new StyledEditorKit.ForegroundAction("Poner texto en rojo", Color.RED));
		barra.add(amarilloBarra);
		barra.add(azulBarra);
		barra.add(rojoBarra);
		
		//BOTONES PARA ALINEAR EL TEXTO
		JButton align_left = new JButton(new ImageIcon("src/graficos/imagenes/align-left.png"));
		JButton align_center = new JButton(new ImageIcon("src/graficos/imagenes/align-center.png"));
		JButton align_right = new JButton(new ImageIcon("src/graficos/imagenes/align-right.png"));
		JButton align_justify = new JButton(new ImageIcon("src/graficos/imagenes/align-justify.png"));
		align_left.addActionListener(new StyledEditorKit.AlignmentAction("Izquierda", 0));
		align_center.addActionListener(new StyledEditorKit.AlignmentAction("Centrado", 1));
		align_right.addActionListener(new StyledEditorKit.AlignmentAction("Derecha", 2));
		align_justify.addActionListener(new StyledEditorKit.AlignmentAction("Justificado", 3));
		barra.add(align_left);
		barra.add(align_center);
		barra.add(align_right);
		barra.add(align_justify);*/
		
		barra = new JToolBar();
		
		configuraBarra("src/graficos/imagenes/negrita.png").addActionListener(new StyledEditorKit.BoldAction());
		configuraBarra("src/graficos/imagenes/cursiva.png").addActionListener(new StyledEditorKit.ItalicAction());
		configuraBarra("src/graficos/imagenes/subrayar.png").addActionListener(new StyledEditorKit.UnderlineAction());
		barra.addSeparator();
		
		configuraBarra("src/graficos/imagenes/zapdos.png").addActionListener(new StyledEditorKit.ForegroundAction("Poner texto en amarillo", Color.YELLOW));
		configuraBarra("src/graficos/imagenes/articuno.png").addActionListener(new StyledEditorKit.ForegroundAction("Poner texto en azul", Color.BLUE));
		configuraBarra("src/graficos/imagenes/moltres.png").addActionListener(new StyledEditorKit.ForegroundAction("Poner texto en rojo", Color.RED));
		barra.addSeparator();
		
		configuraBarra("src/graficos/imagenes/align-left.png").addActionListener(new StyledEditorKit.AlignmentAction("Izquierda", 0));
		configuraBarra("src/graficos/imagenes/align-center.png").addActionListener(new StyledEditorKit.AlignmentAction("Centrado", 1));
		configuraBarra("src/graficos/imagenes/align-right.png").addActionListener(new StyledEditorKit.AlignmentAction("Derecha", 2));
		configuraBarra("src/graficos/imagenes/align-justify.png").addActionListener(new StyledEditorKit.AlignmentAction("Justificado", 3));
		
		barra.setOrientation(1);
		add(barra, BorderLayout.WEST);
		
//*******************************************************************/
	}
	public JButton configuraBarra(String ruta){
		JButton boton = new JButton(new ImageIcon(ruta));
		barra.add(boton);
		return boton;
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
				elementoMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
				elementoMenu.addActionListener(new StyledEditorKit.BoldAction());
			}else if(estilos == Font.ITALIC){
				elementoMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K, InputEvent.CTRL_DOWN_MASK));
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
	JButton negritaBarra, cursivaBarra, subraBarra, amarilloBarra, azulBarra, rojoBarra, a_izquierda, a_centrado, a_derecha, a_justificado;
	JToolBar barra;
}