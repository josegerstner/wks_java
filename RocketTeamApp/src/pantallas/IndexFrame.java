package pantallas;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class IndexFrame extends JFrame{
	IndexFrame(){
		IndexPanel miPanel = new IndexPanel();
		setBounds(450, 100, 400, 600);
		setTitle("Rocket Team App");
		try{
			imagen = ImageIO.read(new File("bin/images/rocketIcon2.jpg"));
		}
		catch(IOException e){
			System.out.println("ERROR: imagen no encontrada");//si no lo encuentra, pasa esto
		}
		setIconImage(imagen);
		add(miPanel);
		setVisible(true);
	}
	private Image imagen;
}
