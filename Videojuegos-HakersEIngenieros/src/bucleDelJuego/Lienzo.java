package bucleDelJuego;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Lienzo extends Canvas{
	JFrame ventana;
	BufferedImage fondo;
	BufferedImage personaje;
	int posx=150;
	
	public BufferStrategy strategy;
	
	public void gameLoop(){
		initialize();
		loadContent();
		
		boolean vive = true;
		
		while(vive){
			update();
			Draw();
			//paint(getGraphics());
			try{
				Thread.sleep(10);
			}catch(InterruptedException e){}
		}
		unloadContent();
	}
	public void initialize(){
		ventana = new JFrame("PokéZelda");
		
		ventana.add(this);
		
		ventana.setSize(10*16*4 + 6, 9*14*4 + 25);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
		ventana.setResizable(false);
		
		ventana.setLocationRelativeTo(null);
		
		createBufferStrategy(2);
		strategy = getBufferStrategy();
	}
	public void loadContent(){
		fondo = Util.LoadImage("fondo",true);
		personaje = Util.LoadImage("link", true);
	}
	public void update(){
		posx+=2;
	}
	public void Draw(){
		Graphics g = strategy.getDrawGraphics();
		g.drawImage(fondo, 0, 0, this);
		g.drawImage(personaje, posx, 270, this);
		strategy.show();
	}
	
	public void unloadContent(){
		
	}
}
