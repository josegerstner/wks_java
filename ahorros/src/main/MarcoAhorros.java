package main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class MarcoAhorros extends JFrame{
	MarcoAhorros(){
		setTitle("Ahorros");
		setBounds(400,200,400,300);
		setLayout(new BorderLayout());
		
		add(new PanelAhorros(), BorderLayout.CENTER);
		
		loco = new JTextArea(10, 10);
		loco.setEditable(false);
		add(loco, BorderLayout.EAST);
		
		enviar = new JButton("Enviar");
		enviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		add(enviar, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	JTextArea loco;
	JButton enviar;
}
