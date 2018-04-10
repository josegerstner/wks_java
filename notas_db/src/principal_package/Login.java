package principal_package;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

@SuppressWarnings("serial")
class Login extends JFrame{
	public Login(){
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
		setLayout(new BorderLayout());
		JPanel laminaSuperior = new JPanel();
		laminaSuperior.setLayout(new GridLayout(2,2));
		add(laminaSuperior, BorderLayout.NORTH);
		JLabel etiquetaUsuario = new JLabel("Usuario: ");
		JLabel etiquetaContrasenia = new JLabel("Contraseña: ");
		JTextField campoUsuario = new JTextField(15);
		campoContrasenia = new JPasswordField();//CAMPO PARA INGRESAR PASSWORDS
		CompruebaPass evento = new CompruebaPass();
		campoContrasenia.getDocument().addDocumentListener(evento);
		laminaSuperior.add(etiquetaUsuario);
		laminaSuperior.add(campoUsuario);
		laminaSuperior.add(etiquetaContrasenia);
		laminaSuperior.add(campoContrasenia);
		enviar = new JButton("Enviar");
		enviar.addActionListener(new AccionEnviar());
		add(enviar, BorderLayout.SOUTH);
	}
	private class AccionEnviar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==enviar){
				VistaIngresoDatos miVista = new VistaIngresoDatos();
				miVista.setVisible(true);
				setVisible(false);
			}
			
		}
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
	JButton enviar;
}