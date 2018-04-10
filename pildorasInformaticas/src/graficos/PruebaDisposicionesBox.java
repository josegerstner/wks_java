package graficos;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PruebaDisposicionesBox {
	public static void main(String[] args) {
		MarcoCaja miMarco = new MarcoCaja();
		miMarco.setVisible(true);
	}
}
@SuppressWarnings("serial")
class MarcoCaja extends JFrame{
	public MarcoCaja(){
		setTitle("Pruebas de la disposición Box");
		setBounds(400, 200, 450, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Creamos el primer contenedor
		JLabel nombre = new JLabel("Nombre");
		JTextField userName = new JTextField(10);
		userName.setMaximumSize(userName.getPreferredSize());
		Box cajaNombre = Box.createHorizontalBox();
		cajaNombre.add(nombre);
		cajaNombre.add(Box.createHorizontalStrut(10));
		cajaNombre.add(userName);
		
		//Creamos el segundo contenedor
		JLabel contrasenia = new JLabel("Contraseña");
		JTextField userPass = new JTextField(10);
		userPass.setMaximumSize(userPass.getPreferredSize());
		Box cajaPass = Box.createHorizontalBox();
		cajaPass.add(contrasenia);
		cajaPass.add(Box.createHorizontalStrut(10));
		cajaPass.add(userPass);
		
		//Creamos el tercer contenedor
		JButton ok = new JButton("Ok");
		JButton cancelar = new JButton("Cancelar");
		Box cajaBotones = Box.createHorizontalBox();
		cajaBotones.add(ok);
		cajaBotones.add(Box.createGlue());
		cajaBotones.add(cancelar);
		
		//Creamos el box contenedor de los demás
		Box cajaContenedora = Box.createVerticalBox();
		cajaContenedora.add(cajaNombre);
		cajaContenedora.add(cajaPass);
		cajaContenedora.add(cajaBotones);
		add(cajaContenedora, BorderLayout.CENTER);
	}
}