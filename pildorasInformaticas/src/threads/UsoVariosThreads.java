package threads;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class UsoVariosThreads {
	public static void main(String[] args) {
		JFrame marco=new MarcoRebote2();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);
	}
}

class PelotaHilos2 implements Runnable{
	public PelotaHilos2(Pelota2 unaPelota, Component unComponente){
		pelota = unaPelota;
		componente = unComponente;
	}
	public void run() {
		
		System.out.println("Estado del hilo al comenzar: " + Thread.currentThread().isInterrupted());
		
		while(!Thread.currentThread().isInterrupted()){
			pelota.mueve_pelota(componente.getBounds());		
			componente.paint(componente.getGraphics());
			try {
				Thread.sleep(4);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
		
		System.out.println("Estado del hilo al terminar: " + Thread.currentThread().isInterrupted());
		
	}
	private Pelota2 pelota;
	private Component componente;
}

//Movimiento de la pelota-----------------------------------------------------------------------------------------
class Pelota2{
	// Mueve la pelota invirtiendo posición si choca con límites
	public void mueve_pelota(Rectangle2D limites){
		x+=dx;
		y+=dy;
		if(x<limites.getMinX()){
			x=limites.getMinX();
			dx=-dx;
		}
		if(x + TAMX>=limites.getMaxX()){
			x=limites.getMaxX() - TAMX;
			dx=-dx;
		}
		if(y<limites.getMinY()){
			y=limites.getMinY();
			dy=-dy;
		}
		if(y + TAMY>=limites.getMaxY()){
			y=limites.getMaxY()-TAMY;
			dy=-dy;
		}
	}
	//Forma de la pelota en su posición inicial
	public Ellipse2D getShape(){
		return new Ellipse2D.Double(x,y,TAMX,TAMY);
	}	
	private static final int TAMX=15;
	private static final int TAMY=15;
	private double x=0;
	private double y=0;
	private double dx=1;
	private double dy=1;
}
// Lámina que dibuja las pelotas----------------------------------------------------------------------
@SuppressWarnings("serial")
class LaminaPelota2 extends JPanel{
	//Añadimos pelota a la lámina
	public void add(Pelota2 b){
		pelotas.add(b);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		for(Pelota2 b: pelotas){
			g2.fill(b.getShape());
		}
	}
	private ArrayList<Pelota2> pelotas=new ArrayList<Pelota2>();
}
//Marco con lámina y botones------------------------------------------------------------------------------
@SuppressWarnings("serial")
class MarcoRebote2 extends JFrame{
	public MarcoRebote2(){
		setBounds(400,200,600,350);
		setTitle ("Rebotes");
		lamina=new LaminaPelota2();
		add(lamina, BorderLayout.CENTER);
		JPanel laminaBotones=new JPanel();
		
		//Botón para arrancar el hilo 1
		arranca1 = new JButton("Hilo 1");
		arranca1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				comienza_el_juego(evento);
			}
		});
		laminaBotones.add(arranca1);
		
		//Botón para arrancar el hilo 2
		arranca2 = new JButton("Hilo 2");
		arranca2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				comienza_el_juego(evento);
			}
		});
		laminaBotones.add(arranca2);
		
		//Botón para arrancar el hilo 3
		arranca3 = new JButton("Hilo 3");
		arranca3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				comienza_el_juego(evento);
			}
		});
		laminaBotones.add(arranca3);
		
		//Botón para detener el hilo 1
		detener1 = new JButton("Detener 1");
		detener1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evento) {
				detener(evento);
			}
		});
		laminaBotones.add(detener1);
		
		//Botón para detener el hilo 2
		detener2 = new JButton("Detener 2");
		detener2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				detener(evento);
			}
		});
		laminaBotones.add(detener2);
		
		//Botón para detener el hilo 3
		detener3 = new JButton("Detener 3");
		detener3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				detener(evento);
			}
		});
		laminaBotones.add(detener3);

		add(laminaBotones, BorderLayout.SOUTH);
	}
	
	//Añade pelota y la bota 1000 veces
	public void comienza_el_juego (ActionEvent e){
		Pelota2 pelota=new Pelota2();
		lamina.add(pelota);
		Runnable r = new PelotaHilos2(pelota, lamina);
		
		if(e.getSource().equals(arranca1)){
			t1 = new Thread(r);
			t1.start();
		}else if(e.getSource().equals(arranca2)){
			t2 = new Thread(r);
			t2.start();
		}else if(e.getSource().equals(arranca3)){
			t3 = new Thread(r);
			t3.start();
		}
	}
	public void detener(ActionEvent e){
		if(e.getSource().equals(detener1)){
			t1.interrupt();
		}else if(e.getSource().equals(detener2)){
			t2.interrupt();
		}else if(e.getSource().equals(detener3)){
			t3.interrupt();
		}
	}
	private LaminaPelota2 lamina;
	private Thread t1, t2, t3;
	JButton arranca1, arranca2, arranca3, detener1, detener2, detener3;
}