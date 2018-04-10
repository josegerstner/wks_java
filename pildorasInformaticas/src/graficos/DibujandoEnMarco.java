package graficos;
import java.awt.*;
import javax.swing.*;
public class DibujandoEnMarco {

	public static void main(String[] args) {
		MarcoConDibujos mimarco = new MarcoConDibujos();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
@SuppressWarnings("serial")
class MarcoConDibujos extends JFrame{
	public MarcoConDibujos(){
		setTitle("Prueba de dibujos");
		setSize(400,400);
		LaminaConFiguras miLamina = new LaminaConFiguras();
		add(miLamina);
	}
}
@SuppressWarnings("serial")
class LaminaConFiguras extends JPanel{
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawRect(50, 50, 300, 200);//Dibujo un rect�ngulo
		g.drawLine(100, 100, 300, 200);//Dibujo una l�nea
		g.drawArc(50, 100, 100, 200, 120, 150);
	}
}