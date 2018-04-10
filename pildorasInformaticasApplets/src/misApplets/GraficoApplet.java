package misApplets;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JApplet;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GraficoApplet extends JApplet{
	public void init(String[] args) {
		LaminaGrafico miLamina = new LaminaGrafico();
		add(miLamina);
		miLamina.setVisible(true);
		setBounds(0,0,200,400);
		setVisible(true);
	}
}
@SuppressWarnings("serial")
class LaminaGrafico extends JPanel{
	public void paint(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		g2.rotate(180/180.0 * Math.PI, 125, 100);
		
		Rectangle2D graf1 = new Rectangle2D.Double(50, 0, 50, 50);
		Rectangle2D graf2 = new Rectangle2D.Double(100, 0, 50, 75);
		Rectangle2D graf3 = new Rectangle2D.Double(150, 0, 50, 100);
		
		g2.setPaint(Color.RED);
		g2.fill(graf1);
		g2.setPaint(Color.YELLOW);
		g2.fill(graf2);
		g2.setPaint(Color.GREEN);
		g2.fill(graf3);
	}
}