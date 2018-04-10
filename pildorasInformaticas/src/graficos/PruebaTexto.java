package graficos;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PruebaTexto {

	public static void main(String[] args) {
		MarcoTexto miMarco = new MarcoTexto();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
@SuppressWarnings("serial")
class MarcoTexto extends JFrame{
	public MarcoTexto(){
		setTitle("Calculadora");
		setBounds(400, 200, 450, 300);
		LaminaTexto miLamina = new LaminaTexto();
		add(miLamina);
		setVisible(true);
	}
}
@SuppressWarnings("serial")
class LaminaTexto extends JPanel{
	public LaminaTexto(){
		setLayout(new BorderLayout());
		JPanel miLamina2 = new JPanel();
		miLamina2.setLayout(new FlowLayout());
		JLabel texto = new JLabel("Email: ");
		resultado = new JLabel("", JLabel.CENTER);
		miLamina2.add(texto);
		campo1 = new JTextField(20);
		miLamina2.add(campo1);
		JButton botonEnviar = new JButton("Comprobar");
		DameTexto miEvento = new DameTexto();
		botonEnviar.addActionListener(miEvento);
		miLamina2.add(botonEnviar);
		add(miLamina2, BorderLayout.NORTH);
		add(resultado, BorderLayout.CENTER);
	}
	private class DameTexto implements ActionListener{
		public void actionPerformed(ActionEvent e){
			int correcto = 0;
			String email = campo1.getText().trim();
			for(int i=0; i<email.length(); i++){
				if(email.charAt(i)=='@'){
					correcto++;
				}
			}
			if(correcto!=1){
				resultado.setText("Email incorrecto");
			}else{
				resultado.setText("Email correcto");
			}
			//cuando pulse el botón me imprime en pantalla lo que hay dentro del cuadro de texto
			//System.out.println(campo1.getText().trim());
		}
	}
	private JTextField campo1;
	private JLabel resultado;
}