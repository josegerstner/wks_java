package principal_package;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class VistaIngresoDatos extends JFrame{
	public VistaIngresoDatos(){
		setTitle("Materias");
		setBounds(400,200,450,300);
		Lamina miLamina = new Lamina();
		add(miLamina);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private class Lamina extends JPanel{
		public Lamina(){
			setLayout(new BorderLayout());
			PanelDatos panelMateria = new PanelDatos();
			add(panelMateria, BorderLayout.NORTH);
			PanelEnviar enviar = new PanelEnviar();
			add(enviar, BorderLayout.SOUTH);
		}
		private class PanelDatos extends JPanel{
			public PanelDatos(){
				setLayout(new GridLayout(2,2));
				JLabel materia = new JLabel("Materia");
				add(materia);
				JTextField materia_db = new JTextField(10);
				add(materia_db);
				JLabel nota = new JLabel("Nota");
				add (nota);
				JTextField nota_db = new JTextField(2);
				add(nota_db);
			}
		}
		private class PanelEnviar extends JPanel{
			public PanelEnviar(){
				setLayout(new FlowLayout());
				JButton enviar = new JButton("Enviar");
				enviar.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				add (enviar);
				JButton finalizar = new JButton("Finalizar");
				finalizar.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				add(finalizar);
			}
		}
	}
}
