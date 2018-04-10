package threads;
import java.awt.geom.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class UsoThreads {
	public static void main(String[] args) {
		JFrame marco=new MarcoRebote();
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setVisible(true);
	}
}

class PelotaHilos implements Runnable{
	public PelotaHilos(Pelota unaPelota, Component unComponente){
		pelota = unaPelota;
		componente = unComponente;
	}
	public void run() {
		
		System.out.println("Estado del hilo al comenzar: " + Thread.currentThread().isInterrupted());
		
		//for (int i=1; i<=3000; i++){
	
		//el método interrupted devuelve un boolean true si está interrumpido
		//while(!Thread.interrupted()){
		
		//el método currentThread nos devuelve el hilo en ejecución
		//el método is interrupted nos devuelve un boolean true si el hilo apuntado está interrumpido
		while(!Thread.currentThread().isInterrupted()){
			pelota.mueve_pelota(componente.getBounds());		
			componente.paint(componente.getGraphics());
		/*	try {
		 *	//el método sleep no permite interrumpir el hilo mientras está dormido
				Thread.sleep(4);
			} catch (InterruptedException e) {
				System.out.println("Pasó algo, loquita");;
			}*/
		}
		
		System.out.println("Estado del hilo al terminar: " + Thread.currentThread().isInterrupted());
		
	}
	private Pelota pelota;
	private Component componente;
}

//Movimiento de la pelota-----------------------------------------------------------------------------------------
class Pelota{
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
class LaminaPelota extends JPanel{
	//Añadimos pelota a la lámina
	public void add(Pelota b){
		pelotas.add(b);
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2=(Graphics2D)g;
		for(Pelota b: pelotas){
			g2.fill(b.getShape());
		}
	}
	private ArrayList<Pelota> pelotas=new ArrayList<Pelota>();
}
//Marco con lámina y botones------------------------------------------------------------------------------
@SuppressWarnings("serial")
class MarcoRebote extends JFrame{
	public MarcoRebote(){
		setBounds(400,200,400,350);
		setTitle ("Rebotes");
		lamina=new LaminaPelota();
		add(lamina, BorderLayout.CENTER);
		JPanel laminaBotones=new JPanel();
		//se agrega el botón para lanzar las pelotas
		ponerBoton(laminaBotones, "Dale!", new ActionListener(){
			public void actionPerformed(ActionEvent evento){
				comienza_el_juego();
			}
		});
		//se agrega el botón para salir de la aplicación
		ponerBoton(laminaBotones, "Salir", new ActionListener(){
			public void actionPerformed(ActionEvent evento){
				System.exit(0);
			}
		});
		//se agrega el botón para interrumpir la animación de la pelota
		ponerBoton(laminaBotones, "Detener", new ActionListener(){
			public void actionPerformed(ActionEvent evento){
				detener();
			}
		});
		
		add(laminaBotones, BorderLayout.SOUTH);
	}
	//Ponemos botones
	public void ponerBoton(Container c, String titulo, ActionListener oyente){
		JButton boton=new JButton(titulo);
		c.add(boton);
		boton.addActionListener(oyente);
	}
	//Añade pelota y la bota 1000 veces
	public void comienza_el_juego (){
		Pelota pelota=new Pelota();
		lamina.add(pelota);
		
		//guardamos un objeto de nuestra clase Runnable en una variable Runnable
		Runnable r = new PelotaHilos(pelota, lamina);
		//Instanciamos una variable Thread y le pasamos como parámetro
		//la instancia hecha anteriormente
		t = new Thread(r);
		//le damos start() al Thread
		t.start();
	}
	public void detener(){
		//el método stop() está obsoleto
		//t.stop();
		
		t.interrupt();
	}
	private LaminaPelota lamina;
	private Thread t;
}