package graficos;
import javax.swing.*;
import java.awt.*;
public class EscribiendoEnMarco {

	public static void main(String[] args) {
		MarcoConTexto mimarco = new MarcoConTexto();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
@SuppressWarnings("serial")
class MarcoConTexto extends JFrame{
	public MarcoConTexto(){
		setVisible(true);
		setSize(600,450);
		setLocation(400,200);
		setTitle("Primer texto");
		Lamina miLamina = new Lamina();
		add(miLamina);	//añade la lámina para que haga lo que hace la lámina
	}
}
@SuppressWarnings("serial")
class Lamina extends JPanel{
	public void paintComponent(Graphics g){
		super.paintComponent(g);//tengo que llamar al método super para que haga la lámina con sus propiedades
		g.drawString("Estamos aprendiendo Swing", 100, 100);//lo único que hago es escribir un texto
	}
}