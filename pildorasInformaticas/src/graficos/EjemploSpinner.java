package graficos;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class EjemploSpinner {
	public static void main(String[] args) {
		FrameSpinner miMarco = new FrameSpinner();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
@SuppressWarnings("serial")
class FrameSpinner extends JFrame{
	public FrameSpinner(){
		setTitle("Puebas con JSpinner");
		setBounds(450, 200, 400, 400);
		add(new LaminaSpinner());
		setVisible(true);
	}
}
@SuppressWarnings("serial")
class LaminaSpinner extends JPanel{
	public LaminaSpinner(){
		//Spinner de n�meros enteros
		//JSpinner control = new JSpinner();
		//Spinner de fechas
		//JSpinner control = new JSpinner(new SpinnerDateModel());
		//Spinner para listas de texto
		//String lista[] = {"Amarillo", "Rojo", "Azul"};
		//String lista[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		//JSpinner control = new JSpinner(new SpinnerListModel(lista));
		//Spinner para n�meros (valorinicial, desde, hasta, decuantoencuanto)
		//JSpinner control = new JSpinner(new MiModeloJSpinner(5, 0, 10, 1));
		
		//se puede hacer con una clase interna an�nima:
		JSpinner control = new JSpinner(new SpinnerNumberModel(5, 0, 10, 1){
			public Object getNextValue(){
				return super.getPreviousValue();
			}
			public Object getPreviousValue(){
				return super.getNextValue();
			}
		});
		
		Dimension d = new Dimension(100, 20);
		control.setPreferredSize(d);
		add(control);
	}
	/*private class MiModeloJSpinner extends SpinnerNumberModel{
		public MiModeloJSpinner(int valorInicial, int desde, int hasta, int deCuantoEnCuanto){
			super(valorInicial, desde, hasta, deCuantoEnCuanto);
			
		}
		public Object getNextValue(){
			return super.getPreviousValue();
		}
		public Object getPreviousValue(){
			return super.getNextValue();
		}
	}*/
}