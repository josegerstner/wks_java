package graficos;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DibujandoMarcosConDibujos2D {
	public static void main(String[] args) {
		MarcoConDibujos2D mimarco = new MarcoConDibujos2D();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
@SuppressWarnings("serial")
class MarcoConDibujos2D extends JFrame{
	public MarcoConDibujos2D(){
		setTitle("Prueba de dibujos");
		setSize(400,400);
		LaminaConFiguras2D miLamina = new LaminaConFiguras2D();
		add(miLamina);
	}
}
@SuppressWarnings("serial")
class LaminaConFiguras2D extends JPanel{
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 =(Graphics2D) g;
		Rectangle2D rectangulo = new Rectangle2D.Double(100, 100, 200, 150);
		g2.draw(rectangulo);//Dibujo el rect�ngulo
		Ellipse2D elipse = new Ellipse2D.Double();
		elipse.setFrame(rectangulo);//La elipse debe estar dentro de un rect�ngulo imaginario, en este caso ya lo dibujamos
		g2.draw(elipse);//DIbujo la elipse
		g2.draw(new Line2D.Double(100, 100, 300, 250));//Dibujamos una l�nea justo desde donde empieza el rect�ngulo hasta donde termina
		double centroEnX = rectangulo.getCenterX();
		double centroEnY = rectangulo.getCenterY();
		double radio = 150;
		Ellipse2D circulo = new Ellipse2D.Double();
		circulo.setFrameFromCenter(centroEnX, centroEnY, centroEnX+radio, centroEnY+radio);
		g2.draw(circulo);
	}
}