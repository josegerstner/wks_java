package graficos;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.Dimension;
import javax.swing.JFrame;
public class CreandoMarcoCentrado {
	public static void main(String[] args) {
		MarcoCentrado miMarco = new MarcoCentrado();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
@SuppressWarnings("serial")
class MarcoCentrado extends JFrame{
	public MarcoCentrado(){
		Toolkit mipantalla = Toolkit.getDefaultToolkit();
		Dimension tamanioPantalla = mipantalla.getScreenSize();//guardo la resoluci�n de mi pantalla en un objeto
		int altoPantalla = tamanioPantalla.height;
		int anchoPantalla = tamanioPantalla.width;
		setSize(anchoPantalla/2, altoPantalla/2);//la ventana va a medir la mitad de alto y ancho de mi pantalla
		setLocation(anchoPantalla/4, altoPantalla/4);//se va a situar justo en el medio de mi pantalla
		setVisible(true);
		setTitle("Ventana centrada");
		Image miIcono = mipantalla.getImage("src/graficos/imagenes/pikawaii.png");//creo un objeto imagen con la ruta de la imagen que voy a poner
		setIconImage(miIcono);//cambio la imagen de la aplicaci�n
	}
}