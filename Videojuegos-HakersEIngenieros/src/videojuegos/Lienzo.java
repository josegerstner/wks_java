package videojuegos;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;

@SuppressWarnings("serial")
public class Lienzo extends Canvas{
	public void paint(Graphics g){
		BufferedImage fondo = LoadImage("fondo", false);
		BufferedImage link = LoadImage("link", true);
		
		g.drawImage(fondo, 0, 0, this);
		g.drawImage(link, 0, 270, this);
	}
	
	BufferedImage LoadImage(String nombre, boolean scale2x){
		BufferedImage imgAux = null;
		
		try{
			imgAux = ImageIO.read(new File("images/" + nombre +".png"));
			
			if(scale2x){
				imgAux = Scalr.resize(imgAux, imgAux.getWidth()/2, imgAux.getHeight()/2);
			}
			return imgAux;
		}catch(Exception e){
			System.out.println("No se pudo cargar la imagen");
			System.exit(0);
			return null;
		}
	}
}
