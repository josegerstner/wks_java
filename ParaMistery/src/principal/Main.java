package principal;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

//import graficos.MarcoConImagenes;

public class Main {
	public static void main(String[] args) {
		MarcoConImagenes mimarco = new MarcoConImagenes();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

@SuppressWarnings("serial")
class MarcoConImagenes extends JFrame{
	public MarcoConImagenes(){
		setTitle("Te queremos, Mistery!!!");
		setBounds(400, 100, 500, 500);
		LaminaConImagenes miLamina = new LaminaConImagenes();
		add(miLamina);
		try{
			imagen = ImageIO.read(new File("cuore.png"));//la clase ImageIO lanza una excepci�n si no la encuentra
		}					//al m�todo read le pasamos un objeto File para que traiga
		catch(IOException e){
			System.out.println("ERROR: imagen no encontrada");//si no lo encuentra, pasa esto
		}
		setIconImage(imagen);
	}
	private Image imagen;
}
@SuppressWarnings("serial")
class LaminaConImagenes extends JPanel{
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//copiar una imagen a lo ancho y largo de la l�mina
		File miImagen = new File("cuore.png");
		try{
			imagen = ImageIO.read(miImagen);//la clase ImageIO lanza una excepci�n si no la encuentra
		}					//al m�todo read le pasamos un objeto File para que traiga
		catch(IOException e){
			System.out.println("ERROR: imagen no encontrada");//si no lo encuentra, pasa esto
		}
		int anchuraImagen = imagen.getWidth(this);
		int alturaImagen = imagen.getHeight(this);
		g.drawImage(imagen, 0, 0, null);//dibujamos la imagen dentro de la l�mina
		//g.copyArea(0, 0, 90, 90, 400, 350);//los primeros cuatro par�metros indican la imagen a copiar
											//los �ltimos dos indican d�nde quiero copiarla
		for(int i=0; (anchuraImagen*i)<500; i++){
			for(int j=0; (alturaImagen*j)<500; j++){
				g.copyArea(0, 0, anchuraImagen, alturaImagen, anchuraImagen*i, alturaImagen*j);
			}
		}
		//dibujar una imagen en la l�mina
		try{
			imagen = ImageIO.read(new File("cuore.png"));//la clase ImageIO lanza una excepci�n si no la encuentra
		}					//al m�todo read le pasamos un objeto File para que traiga
		catch(IOException e){
			System.out.println("ERROR: imagen no encontrada");//si no lo encuentra, pasa esto
		}
		g.drawImage(imagen, 15, 30, null);//dibujamos la imagen dentro de la l�mina
	}
	private Image imagen;
}