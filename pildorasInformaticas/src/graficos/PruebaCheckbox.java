package graficos;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PruebaCheckbox {

	public static void main(String[] args) {
		MarcoCheck miMarco = new MarcoCheck();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
@SuppressWarnings("serial")
class MarcoCheck extends JFrame{
	public MarcoCheck(){
		setTitle("Ejemplo de Checkboxs");
		setBounds(400, 200, 500, 300);
		LaminaCheck miLamina = new LaminaCheck();
		add(miLamina);
		setVisible(true);
	}
}
@SuppressWarnings("serial")
class LaminaCheck extends JPanel{
	public LaminaCheck(){
		setLayout(new BorderLayout());
		Font miLetra = new Font("Serif", Font.PLAIN, 24);
		texto = new JLabel("En un lugar de la concha de tu madre all boys");
		texto.setFont(miLetra);
		JPanel laminaTexto = new JPanel();
		laminaTexto.add(texto);
		add(laminaTexto, BorderLayout.CENTER);
		checkNegrita = new JCheckBox("Negrita");
		checkItalic = new JCheckBox("Cursiva");
		checkNegrita.addActionListener(new ManejaChecks());
		checkItalic.addActionListener(new ManejaChecks());
		JPanel laminaChecks = new JPanel();
		laminaChecks.add(checkNegrita);
		laminaChecks.add(checkItalic);
		add(laminaChecks, BorderLayout.SOUTH);
	}
	private class ManejaChecks implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int tipo = 0;
			if(checkNegrita.isSelected())
				tipo += Font.BOLD;
			if(checkItalic.isSelected())
				tipo += Font.ITALIC;
			
			texto.setFont(new Font("Serif", tipo, 24));
		}
	}
	private JLabel texto;
	private JCheckBox checkNegrita, checkItalic;
}