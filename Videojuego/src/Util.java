import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;

public class Util
{

	public static BufferedImage LoadImage(String nombre, boolean scale2x) {

		BufferedImage imgAux = null;

		try
		{

			imgAux = ImageIO.read(new File("images/" + nombre + ".png"));

			if (scale2x == true)
			{

				imgAux = Scalr.resize(imgAux, imgAux.getWidth() * 4, imgAux.getHeight() * 4);

			}

			return imgAux;

		} catch (Exception e)
		{
			System.out.println("No se pudo cargar la imagen " + nombre);
			System.exit(0);
			return null;

		}
	}

}
