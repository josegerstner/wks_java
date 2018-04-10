package com.josegerstner.semaforo;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Panel extends JFrame{
	public Panel(){
		setBounds(400,200,600,400);
		setTitle("Sema-forro");
		Semaforo semaforo = new Semaforo();
		add(semaforo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
