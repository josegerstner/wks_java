package graficos;

import javax.swing.*;
public class CreandoMarcos {

	public static void main(String[] args) {
		MiMarco marco1 = new MiMarco();
		marco1.setVisible(true);
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
@SuppressWarnings("serial")
class MiMarco extends JFrame{
	public MiMarco(){
		//setSize(500, 300);//define el tama�o del marco
		//setLocation(500, 300);//define la posici�n del marco
		setBounds(450, 250, 500, 300);//define la posici�n y el tama�o del marco
		//setResizable(true);//permite redimensionar el marco con el rat�n
		//setExtendedState(Frame.MAXIMIZED_BOTH);//define que el marco se abre a pantalla completa
		setTitle("Mi ventana");
	}
}