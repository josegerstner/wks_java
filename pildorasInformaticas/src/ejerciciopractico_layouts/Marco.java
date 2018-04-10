package ejerciciopractico_layouts;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Marco extends JFrame{
	public Marco(){
		setTitle("Prueba de diálogos");
		setBounds(300, 150, 650, 400);
		setLayout(new BorderLayout());
		
		JPanel laminaCuadricula = new JPanel();
		//establecemos que la lámina va a tener 2 filas y 3 columnas
		laminaCuadricula.setLayout(new GridLayout(2, 3));
		
		//instanciamos la primera caja
		String primeraCaja[] = {"Mensaje", "Confirmar", "Opción", "Entrada"};
		primeraLamina = new LaminaBotones("Tipo", primeraCaja);
		
		//instanciamos la segunda caja
		segundaLamina = new LaminaBotones("Tipo de mensaje", new String[]{
				"ERROR_MESSAGE",
				"INFORMATION_MESSAGE",
				"WARNING_MESSAGE",
				"QUESTION_MESSAGE",
				"PLAIN_MESSAGE"
		});
		
		//instanciamos la tercera caja
		terceraLamina = new LaminaBotones("Mensaje", new String[]{
				"Cadena",
				"Icono",
				"Componente",
				"Otros",
				"Object[]"
		});
		
		//instanciamos la cuarta caja
		cuartaLamina = new LaminaBotones("Confirmar", new String[]{
				"DEFAULT_OPTION",
				"YES_NO_OPTION",
				"YES_NO_CANCEL_OPTION",
				"OK_CANCEL_OPTION",
		});
		
		//instanciamos la quinta caja
		quintaLamina = new LaminaBotones("Opción", new String[]{
				"String[]",
				"Icon[]",
				"Object[]",
		});
		
		//instanciamos la sexta caja
		sextaLamina = new LaminaBotones("Entrada", new String[]{
				"Campo de texto",
				"Combo",
		});
		
		//creamos la lámina inferior
		JPanel laminaMostrar = new JPanel();
		JButton botonMostrar = new JButton("Mostrar");
		laminaMostrar.add(botonMostrar);
		botonMostrar.addActionListener(new AccionMostrar());
		
		laminaCuadricula.add(primeraLamina);
		laminaCuadricula.add(segundaLamina);
		laminaCuadricula.add(terceraLamina);
		laminaCuadricula.add(cuartaLamina);
		laminaCuadricula.add(quintaLamina);
		laminaCuadricula.add(sextaLamina);
		
		//agregamos las láminas al marco
		add(laminaCuadricula, BorderLayout.CENTER);
		add(laminaMostrar, BorderLayout.SOUTH);
	}
	
	//proporciona el mensaje
	public Object dameMensaje(){
		String s = terceraLamina.dameSeleccion();
		if(s.equals("Cadena")){
			return cadenaMensaje;
		}else if(s.equals("Icono")){
			return iconoMensaje;
		}else if(s.equals("Componente")){
			return componenteMensaje;
		}else if(s.equals("Otros")){
			return objetoMensaje;
		}else if(s.equals("Object[]")){
			return new Object[]{
					cadenaMensaje,
					iconoMensaje,
					componenteMensaje,
					objetoMensaje
			};
		}else{
			//agregamos el return null sólo para que el código no se queje
			return null;
		}
	}
	
	//devuelve el tipo del ícono o nº botones confirmar
	public int dameIconoConfirmar(LaminaBotones lamina){
		String s = lamina.dameSeleccion();
		if(s.equals("ERROR_MESSAGE") || s.equals("YES_NO_OPTION")){
			return 0;
		}else if(s.equals("INFORMATION_MESSAGE") || s.equals("YES_NO_CANCEL_OPTION")){
			return 1;
		}else if(s.equals("WARNING_MESSAGE") || s.equals("OK_CANCEL_OPTION")){
			return 2;
		}else if(s.equals("QUESTION_MESSAGE")){
			return 3;
		}else if(s.equals("PLAIN_MESSAGE") || s.equals("DEFAULT_OPTION")){
			return -1;
		}else{
			//agregamos el return -2 sólo para que el código no moleste
			return -1;
		}
	}
	
	//da opciones a la lámina opción
	public Object[] dameOpciones(LaminaBotones lamina){
		String s = lamina.dameSeleccion();
		if(s.equals("String[]")){
			return new String[]{"Amarillo", "Azul", "Rojo"};
		}else if(s.equals("Icon[]")){
			return new Object[]{
					new ImageIcon("src/graficos/imagenes/zapdos.png"),
					new ImageIcon("src/graficos/imagenes/articuno.png"),
					new ImageIcon("src/graficos/imagenes/moltres.png")
			};
		}else if(s.equals("Object[]")){
			return new Object[]{
					cadenaMensaje,
					iconoMensaje,
					componenteMensaje,
					objetoMensaje
			};
		}else{
			return null;
		}
	}
	
	//creamos una clase interna con los eventos que desencadena el botón mostrar
	private class AccionMostrar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			//System.out.println(primeraLamina.dameSeleccion());
			if(primeraLamina.dameSeleccion().equals("Mensaje")){
				JOptionPane.showMessageDialog(Marco.this, dameMensaje(), "Título", dameIconoConfirmar(segundaLamina));
			}else if(primeraLamina.dameSeleccion().equals("Confirmar")){
				JOptionPane.showConfirmDialog(Marco.this, dameMensaje(), "Título", dameIconoConfirmar(cuartaLamina), dameIconoConfirmar(segundaLamina));
			}else if(primeraLamina.dameSeleccion().equals("Entrada")){
				if(sextaLamina.dameSeleccion().equals("Campo de texto")){
					JOptionPane.showInputDialog(Marco.this, dameMensaje(), "Título", dameIconoConfirmar(segundaLamina));
				}else{
					JOptionPane.showInputDialog(Marco.this, dameMensaje(), "Título", dameIconoConfirmar(segundaLamina), null, new String[]{"Amarillo", "Azul", "Rojo"}, "Azul");
				}
			}else if(primeraLamina.dameSeleccion().equals("Opción")){
				JOptionPane.showOptionDialog(Marco.this, dameMensaje(), "Título", 1, dameIconoConfirmar(segundaLamina), null, dameOpciones(quintaLamina), null);
			}
		}
	}
	
	//creamos otra clase interna con una lámina de ejemplo para mostrar como mensaje
	private class LaminaEjemplo extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			Rectangle2D rectangulo = new Rectangle2D.Double(0, 0, getWidth(), getHeight());
			g2.setPaint(Color.YELLOW);
			g2.fill(rectangulo);
		}
	}
	private LaminaBotones primeraLamina, segundaLamina, terceraLamina, cuartaLamina, quintaLamina, sextaLamina;
	private String cadenaMensaje = "Mensaje";
	private Icon iconoMensaje = new ImageIcon("src/graficos/imagenes/zapdos.png");
	private Object objetoMensaje = new Date();
	private Component componenteMensaje = new LaminaEjemplo();
}
