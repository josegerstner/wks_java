package poo;
import java.util.Date;
import java.awt.event.*;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.Timer;
public class PruebaTemporizador2 {

	public static void main(String[] args) {
		Reloj miReloj = new Reloj();
		miReloj.enMarcha(3000, true);
		JOptionPane.showMessageDialog(null, "Pulsa aceptar para finalizar");
		System.exit(0);
	}

}

class Reloj{
	public void enMarcha(int intervalo, final boolean sonido){//hay que definir sonido como "final"
													//porque la clase interna local accede a esa variable
		class DameLaHora2 implements ActionListener{//CREAMOS UNA CLASE INTERNA LOCAL 
													//(no debe llevar modificadores de acceso)
			public void actionPerformed(ActionEvent evento){
				Date ahora = new Date();
				System.out.println("Te pongo la hora cada 3 segundos: " + ahora);
				if(sonido){
					Toolkit.getDefaultToolkit().beep();
				}
			}
		}
		ActionListener oyente = new DameLaHora2();
		Timer miTemporizador = new Timer(intervalo, oyente);
		miTemporizador.start();
	}
/*	private int intervalo;
	private boolean sonido;
	
	private class DameLaHora2 implements ActionListener{//CREAMOS UNA CLASE INTERNA
		public void actionPerformed(ActionEvent evento){
			Date ahora = new Date();
			System.out.println("Te pongo la hora cada 3 segundos: " + ahora);
			if(sonido){
				Toolkit.getDefaultToolkit().beep();
			}
		}
	}*/
}