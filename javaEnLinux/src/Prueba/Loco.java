package Prueba;
import javax.swing.*;

public class Loco extends JFrame{
	private JLabel label1;
	public Loco(){ 
		setLayout(null); 
		label1=new JLabel("Hola Mundo"); 
		label1.setBounds(10,20,200,30); 
		add(label1); 
	} 
	public static void main(String[] ar){ 
		Loco formulario1= new Loco();
		formulario1.setBounds(100,100,400,300);
		formulario1.setVisible(true);
	}
}