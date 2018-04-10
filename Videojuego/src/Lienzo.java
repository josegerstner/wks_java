import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Lienzo extends Canvas
{
	JFrame ventana;
	BufferedImage fondo;
	BufferedImage link;
	int posx = 150;
	int posy = 30;
	
	int vx;
	int vy;

	boolean up, down, left, right;

	public BufferStrategy strategy;
	int PLAYER_SPEED = 2;

	
	
	
	public void GameLoop() {
		Initialize();

		LoadContent();

		boolean vive = true;

		while (vive)
		{
			Update();

			Draw();

			try
			{
				Thread.sleep(10);
			} catch (InterruptedException e)
			{
			}

		}

		UnLoadContent();

	}

	public void Initialize() {

		ventana = new JFrame("Zelda");

		ventana.add(this);

		ventana.setSize(10 * 16 * 4 + 6, 9 * 16 * 4 + 25);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
		ventana.setResizable(false);

		ventana.setLocationRelativeTo(null);

		setIgnoreRepaint(true);

		requestFocus();

		this.addKeyListener(new KeyAdapter()
		{
			public void updateSpeed() 
			{
				vx = 0;
				vy = 0;
				if (down)
					vy = PLAYER_SPEED;
				if (up)
					vy = -PLAYER_SPEED;
				if (left)
					vx = -PLAYER_SPEED;
				if (right)
					vx = PLAYER_SPEED;
			}

			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode())
				{
				case KeyEvent.VK_UP:
					up = true;
					break;
				case KeyEvent.VK_LEFT:
					left = true;
					break;
				case KeyEvent.VK_RIGHT:
					right = true;
					break;
				case KeyEvent.VK_DOWN:
					down = true;
					break;
				}
				updateSpeed();
			}
			
			public void keyReleased(KeyEvent e) {
				switch (e.getKeyCode())
				{
				case KeyEvent.VK_DOWN:
					down = false;
					break;
				case KeyEvent.VK_UP:
					up = false;
					break;
				case KeyEvent.VK_LEFT:
					left = false;
					break;
				case KeyEvent.VK_RIGHT:
					right = false;
					break;
				}
				updateSpeed();
			}

			

		});

		createBufferStrategy(2);
		strategy = getBufferStrategy();

	}

	

	public void LoadContent() {

		fondo = Util.LoadImage("fondo", true);

		link = Util.LoadImage("link", true);

	}

	public void Update() {

	}

	public void Draw() {

		posx += vx;
		posy += vy;

		Graphics g = strategy.getDrawGraphics();

		g.drawImage(fondo, 0, 0, this);

		g.drawImage(link, posx, posy, this);

		strategy.show();

	}

	public void UnLoadContent() {

	}

}
