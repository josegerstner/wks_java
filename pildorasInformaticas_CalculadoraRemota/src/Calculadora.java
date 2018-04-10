import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Calculadora {

	public static void main(String[] args) {
		MarcoCalculadora miMarco = new MarcoCalculadora();
		miMarco.setVisible(true);
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
@SuppressWarnings("serial")
class MarcoCalculadora extends JFrame{
	public MarcoCalculadora(){
		setTitle("Calculadora");
		setBounds(400, 200, 450, 300);
		LaminaCalculadora miLamina = new LaminaCalculadora();
		add(miLamina);
	}
}
@SuppressWarnings("serial")
class LaminaCalculadora extends JPanel{
	public LaminaCalculadora(){
		ceroInicial = true;
		ultimaOperacion = "=";
		setLayout(new BorderLayout());
		pantalla = new JButton("0");
		pantalla.setEnabled(false);
		add(pantalla, BorderLayout.NORTH);
		teclado = new JPanel();
		teclado.setLayout(new GridLayout(4, 4));//indicamos 4 filas y 4 columnas
		ActionListener mostrarNumero = new MuestraNumero();
		ActionListener operacion = new Operaciones();
		//agregamos los botones
		agregarBoton("7", mostrarNumero);
		agregarBoton("8", mostrarNumero);
		agregarBoton("9", mostrarNumero);
		agregarBoton("/", operacion);
		agregarBoton("4", mostrarNumero);
		agregarBoton("5", mostrarNumero);
		agregarBoton("6", mostrarNumero);
		agregarBoton("*", operacion);
		agregarBoton("1", mostrarNumero);
		agregarBoton("2", mostrarNumero);
		agregarBoton("3", mostrarNumero);
		agregarBoton("-", operacion);
		agregarBoton("0", mostrarNumero);
		agregarBoton(".", mostrarNumero);
		agregarBoton("=", operacion);
		agregarBoton("+", operacion);
		add(teclado, BorderLayout.CENTER);
	}
	private void agregarBoton(String rotulo, ActionListener oyente){
		JButton boton = new JButton(rotulo);
		boton.addActionListener(oyente);
		teclado.add(boton);
	}
	//clase para agregar los n�meros pulsados al display
	private class MuestraNumero implements ActionListener{
		public void actionPerformed(ActionEvent evento) {
			
			//devuelve el string asociado con esta acci�n
			//en este caso, que me devuelva el n�mero ingresado
			String entrada = evento.getActionCommand();
			//pregunto si reci�n arranca el programa
			if(ceroInicial){
				pantalla.setText("");
				ceroInicial = false;
			}
			//le pone ese n�mero a la pantalla
			pantalla.setText(pantalla.getText() + entrada);
		}
	}
	//clase para las operaciones
	private class Operaciones implements ActionListener{
		public void actionPerformed(ActionEvent evento) {
			String operacion = evento.getActionCommand();
			calcular(Double.parseDouble(pantalla.getText()));
			ultimaOperacion = operacion;
			if(operacion.equals("=")){
				resultado = 0;
			}
			ceroInicial = true;
		}
		//m�todo motor de la calculadora
		private void calcular(double numero){
			if(ultimaOperacion.equals("+")){
				resultado += numero;
			}else if(ultimaOperacion.equals("-")){
				resultado -= numero;
			}else if(ultimaOperacion.equals("*")){
				resultado *= numero;
			}else if(ultimaOperacion.equals("/")){
				resultado /= numero;
			}else if(ultimaOperacion.equals("=")){
				resultado = numero;
			}
			pantalla.setText("" + resultado);
			//seteo el resultado
		}
	}
	private JPanel teclado;
	private JButton pantalla;
	private boolean ceroInicial;//si no se inicia es "false"
	private double resultado;
	private String ultimaOperacion;
}