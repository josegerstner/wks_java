package archivos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Dibujar extends JPanel implements ActionListener{
	private Nave nave; //para que todos los métodos la reconozcan
	private Timer timer;
	public Dibujar(){
		setBackground(Color.BLACK);//color de fondo
		setFocusable(true);//para que el teclado detecte el color(?)
		addKeyListener(new Teclado());//se agrega una clase Teclado
		nave = new Nave();
		timer = new Timer(15, this);//maneja la velocidad a la que irá la nave
		timer.start();
	}
	public void paint(Graphics grafica){
		super.paint(grafica);//pinta la gráfica en la superclase paint
		
		Graphics2D g2 = (Graphics2D) grafica;
		g2.drawImage(nave.tenerImagen(), nave.tenerX(), nave.tenerY(), null);//dibuja la imagen y se llama la función y las coordenadas 
	}
	public void actionPerformed(ActionEvent e) {//para que se ejecute la acción mover
		nave.mover();
		repaint();//para que se vuelva a dibujar la imagen en la lámina 
	}
	private class Teclado extends KeyAdapter{//se llama a los dos eventos de teclado
		public void keyReleased(KeyEvent e){
			nave.keyReleased(e);
		}
		public void keyPressed(KeyEvent e){
			nave.keyPressed(e);
		}
	}
}
