package excepciones;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeerImagen {
	public static void main(String[] args) {
		MarcoConImagen mimarco = new MarcoConImagen();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
@SuppressWarnings("serial")
class MarcoConImagen extends JFrame{
	public MarcoConImagen(){
		setTitle("Prueba con imagen");
		setBounds(400, 100, 500, 500);
		LaminaConImagen miLamina = new LaminaConImagen();
		add(miLamina);
	}
}
@SuppressWarnings("serial")
class LaminaConImagen extends JPanel{

	public LaminaConImagen(){
		try{
			imagen = ImageIO.read(new File("bin/graficos/imagenes/pikachu_mini.jpg"));
		}catch(IOException e){
			System.out.println("La imagen no se encuentra");
		}
		
	}
	
	public void paintComponent(Graphics g) throws NullPointerException{
		super.paintComponent(g);
		try{
			int anchuraImagen = imagen.getWidth(this);
			int alturaImagen = imagen.getHeight(this);
			g.drawImage(imagen, 0, 0, null);
			for(int i=0; (anchuraImagen*i)<500; i++){
				for(int j=0; (alturaImagen*j)<500; j++){
					g.copyArea(0, 0, anchuraImagen, alturaImagen, anchuraImagen*i, alturaImagen*j);
				}
			}
		}catch(Exception e){
			g.drawString("No se ha podido cargar la imagen", 10, 10);
		}
	}
	
	private Image imagen;
}