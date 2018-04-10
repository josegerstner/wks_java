package graficos;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class TrabajandoConFuentes {
	public static void main(String[] args) {
		MarcoConFuentes mimarco = new MarcoConFuentes();
		mimarco.setVisible(true);
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
@SuppressWarnings("serial")
class MarcoConFuentes extends JFrame{
	public MarcoConFuentes(){
		setTitle("Prueba con fuentes");
		setSize(400,400);
		LaminaConFuentes miLamina = new LaminaConFuentes();
		add(miLamina);
	}
}
@SuppressWarnings("serial")
class LaminaConFuentes extends JPanel{
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 =(Graphics2D) g;
		Font miFuente = new Font("Verdana", Font.BOLD, 26);
		g2.setFont(miFuente);
		g2.setColor(Color.RED);
		g2.drawString("Mi nombre :D", 100, 100);
		g2.setFont(new Font("Arial", Font.ITALIC, 20));
		g2.setColor(new Color(128,90,50).brighter());
		g2.drawString("Curso de Java", 100, 200);
	}
}