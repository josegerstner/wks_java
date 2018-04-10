package graficos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TiposCuadrosDialogo {
	public static void main(String[] args) {
		CuadrosDialogo miMarco = new CuadrosDialogo();
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
@SuppressWarnings("serial")
class CuadrosDialogo extends JFrame{
	public CuadrosDialogo(){
		setBounds(400,200,450,400);
		setTitle("Tipos de cuadros de diálogo");
		add(new LaminaCuadrosDialogo());
		setVisible(true);
	}
}
@SuppressWarnings("serial")
class LaminaCuadrosDialogo extends JPanel{
	public LaminaCuadrosDialogo(){
		boton1 = new JButton("Botón 1");
		boton2 = new JButton("Botón 2");
		boton3 = new JButton("Botón 3");
		boton4 = new JButton("Botón 4");
		
		boton1.addActionListener(new AccionBotones());
		boton2.addActionListener(new AccionBotones());
		boton3.addActionListener(new AccionBotones());
		boton4.addActionListener(new AccionBotones());
		
		add(boton1);
		add(boton2);
		add(boton3);
		add(boton4);
	}
	private class AccionBotones implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==boton1){
				JOptionPane.showMessageDialog(LaminaCuadrosDialogo.this, "Has presionado el botón 1", "Botonazo", 0, new ImageIcon("src/graficos/imagenes/picartroll.png"));
				
			}else if(e.getSource()==boton2){
				JOptionPane.showInputDialog(LaminaCuadrosDialogo.this, "Has presionado el botón 2", "Gilazo", 1);
				
			}else if(e.getSource()==boton3){
				JOptionPane.showConfirmDialog(LaminaCuadrosDialogo.this, "Has presionado el botón 3", "Agachate y conocelo", 3);
				
			}else{
				JOptionPane.showOptionDialog(LaminaCuadrosDialogo.this, "Has presionado el botón 4", "Qué quilombo", 1, 2, new ImageIcon("src/graficos/imagenes/pikachu_saludando.png"), null, null);
			}
		}
	}
	private JButton boton1, boton2, boton3, boton4;
}