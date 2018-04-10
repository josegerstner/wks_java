package graficos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class CampoPassword {
	public static void main(String[] args) {
		MarcoPasword miMarco = new MarcoPasword();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
@SuppressWarnings("serial")
class MarcoPasword extends JFrame{
	public MarcoPasword(){
		setTitle("Nombre usuario y contraseña");
		setBounds(400, 200, 450, 300);
		LaminaPasword miLamina = new LaminaPasword();
		add(miLamina);
		setVisible(true);
	}
}
@SuppressWarnings("serial")
class LaminaPasword extends JPanel{
	public LaminaPasword(){
		//definimos el layout que usaremos de base
		setLayout(new BorderLayout());
		//creamos la l�mina donde trabajaremos con los campos de texto
		JPanel laminaSuperior = new JPanel();
		laminaSuperior.setLayout(new GridLayout(2,2));
		add(laminaSuperior, BorderLayout.NORTH);
		JLabel etiquetaUsuario = new JLabel("Usuario: ");
		JLabel etiquetaContrasenia = new JLabel("Contraseña: ");
		JTextField campoUsuario = new JTextField(15);
		//CAMPO PARA INGRESAR PASSWORDS
		campoContrasenia = new JPasswordField();
		CompruebaPass evento = new CompruebaPass();
		campoContrasenia.getDocument().addDocumentListener(evento);
		laminaSuperior.add(etiquetaUsuario);
		laminaSuperior.add(campoUsuario);
		laminaSuperior.add(etiquetaContrasenia);
		laminaSuperior.add(campoContrasenia);
		JButton enviar = new JButton("Enviar");
		add(enviar, BorderLayout.SOUTH);
	}
	private class CompruebaPass implements DocumentListener{
		public void changedUpdate(DocumentEvent e) {
			
		}
		public void insertUpdate(DocumentEvent e) {
			char[] contrasenia;
			contrasenia = campoContrasenia.getPassword();
			if(contrasenia.length < 8 || contrasenia.length > 12){
				campoContrasenia.setBackground(Color.RED);
			}else{
				campoContrasenia.setBackground(Color.WHITE);
			}
		}
		public void removeUpdate(DocumentEvent e) {
			/*char[] contrasenia;
			contrasenia = campoContrasenia.getPassword();
			if(contrasenia.length < 8 || contrasenia.length > 12){
				campoContrasenia.setBackground(Color.RED);
			}else{
				campoContrasenia.setBackground(Color.WHITE);
			}*/
			this.insertUpdate(e);
		}
		
	}
	JPasswordField campoContrasenia;
}
