package graficos;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class DibujandoMarcosColoreados {
	public static void main(String[] args) {
		MarcoConColor mimarco = new MarcoConColor();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
@SuppressWarnings("serial")
class MarcoConColor extends JFrame{
	public MarcoConColor(){
		setTitle("Prueba de colores");
		setSize(400,400);
		LaminaConColor miLamina = new LaminaConColor();
		add(miLamina);
		//le doy un color al fondo
		miLamina.setBackground(Color.DARK_GRAY);
		//Le doy un color 
		miLamina.setForeground(Color.BLUE);
	}
}
@SuppressWarnings("serial")
class LaminaConColor extends JPanel{
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 =(Graphics2D) g;
		
		//dibujo de rect�ngulo
		Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150);
		g2.setPaint(Color.BLACK);
		g2.draw(rectangulo);
		//Pinto el interior del rect�ngulo
		g2.setPaint(Color.RED);//usando una variable de clase
		g2.fill(rectangulo);//el m�todo fill pinta el interior
		
		//Dibujo de elipse
		Ellipse2D elipse = new Ellipse2D.Double();
		elipse.setFrame(rectangulo);
		g2.setPaint(Color.BLACK);
		g2.draw(elipse);
		//Pinto el interior de la elipse
		Color miColor = new Color(10, 120, 30);
		g2.setPaint(miColor);
		g2.fill(elipse);
	}
}