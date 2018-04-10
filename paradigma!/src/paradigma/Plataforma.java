package paradigma;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
class Plataforma extends JFrame {
	Plataforma(){
		setSize(400,400);
		setLocationRelativeTo(null);
		Lamina miLamina = new Lamina();
		add(miLamina);
		setVisible(true);
	}
}
//------------------------------PAGINA PRINCIPAL---------------------------//
@SuppressWarnings("serial")
class Lamina extends JPanel {
	Lamina(){
		JButton nuevoUser = new JButton("Nuevo Usuario");
		JButton verPost = new JButton("Ver Posts");
		add(nuevoUser);
		add(verPost);
	}
}
//------------------------------NUEVO USER---------------------------//
@SuppressWarnings("serial")
class NuevoUsuario extends JPanel {
	NuevoUsuario(){
		JLabel _user = new JLabel("Usuario: ");
		JTextField user = new JTextField(5);
		add(_user);
		add(user);
	}
}