package dibujar;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Path2D;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Dibujo extends Canvas implements MouseListener, MouseMotionListener{
	private ArrayList rectangles = new ArrayList();
	private ArrayList circles = new ArrayList();
	private ArrayList shapes = new ArrayList();
	public Color color;
	public int strk_width;
	private Path2D shape;
	public boolean m_alzada=true, rectangle=false, circle=false;
	private int uX, uY, x, y;
	Dibujo(){
		//inicializamos el color del pincel en negro
		this.color = Color.BLACK;
		this.setBackground(Color.WHITE);
		//esta figura guarda las líneas que dibuja con mano libre
		this.shape = new Path2D.Float();
		//seteamos grosor del pincel
		this.strk_width = 5;
	}
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D draw = (Graphics2D) g;
		draw.setColor(Color.WHITE);
		//indicamos que draw va a ocupar todo el canvas
		draw.fillRect(0, 0, this.getWidth(), this.getHeight());
		//indicamos el ancho del pincel
		draw.setStroke(new BasicStroke(this.strk_width));
		draw.setColor(this.color);
		//se guarda la figura que se hace en mano libre
		draw.draw(this.shape);
		
	}
	public void mouseDragged(MouseEvent e) {
		this.x = e.getX();
		this.y = e.getY();
		if(this.m_alzada) this.shape.lineTo(this.x, this.y);
		repaint();
	}
	public void mouseMoved(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {
		if(this.m_alzada){
			this.shape.moveTo(e.getX(), e.getY());
		}
	}
	public void mouseReleased(MouseEvent e) {
		
	}
	public void mouseEntered(MouseEvent e) {}
	
	public void mouseExited(MouseEvent e) {}
}
