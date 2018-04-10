package archivos;
import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
public class Nave {
	private String nave = "nave.jpg";
	private int dx;
	private int dy;
	private int x;
	private int y;
	private Image imagen;
	public Nave(){
		x=40;
		y=60;
		ImageIcon img = new ImageIcon(this.getClass().getResource(nave));//busca un recurso llamado nave
		imagen = img.getImage();//se llama al archivo nave
	}
	public void mover(){//X e Y representan la posición de la imagen
		x += dx;
		y += dy;
	}
	public int tenerX(){
		return x;
	}
	public int tenerY(){
		return y;
	}
	public Image tenerImagen(){
		return imagen;
	}
	//eventos que responden al teclado
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();//obtiene cada número de nuestro teclado
		if(key == KeyEvent.VK_LEFT){
			dx = -1;//rota hacia la izquierda
		}else if(key == KeyEvent.VK_RIGHT){
			dx = 1;//rota hacia la derecha
		}else if(key == KeyEvent.VK_UP){
			dy = -1;//rota hacia arriba
		}
		else if(key == KeyEvent.VK_DOWN){
			dy = 1;//rota hacia abajo
		}
	}
	//métodos de la clase keyAdapter
	public void keyReleased(KeyEvent e){//cuando se deja de presionar las teclas
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_LEFT){
			dx = 0;//para que deje de moverse
		}else if(key == KeyEvent.VK_RIGHT){
			dx = 0;
		}else if(key == KeyEvent.VK_UP){
			dy = 0;
		}
		else if(key == KeyEvent.VK_DOWN){
			dy = 0;
		}
	}
}
