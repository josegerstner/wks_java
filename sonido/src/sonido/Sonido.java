package sonido;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.Clip; //esta librería sirve para reproducir .wav
import javax.sound.sampled.AudioSystem;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Sonido {
	private JFrame frame;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
					Sonido window = new Sonido();
					window.frame.setVisible(true);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}
	public Sonido(){
		initialize();
	}
	private void initialize(){
		frame = new JFrame();
		frame.setBounds(400,200,400,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Reproducción de audio :D");
		
		JButton botonReproducir = new JButton("Reproducir");
		botonReproducir.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				try{
					Clip sonido = AudioSystem.getClip();
					File archivo = new File("bin/sonido/Granada de Paz - piano.wav");
					sonido.open(AudioSystem.getAudioInputStream(archivo));
					sonido.start();
					Thread.sleep(11000);
					sonido.close();
				}catch(Exception e2){
					System.out.println("ERROR : No se puede abrir el archivo");
					System.out.println(" " + e2);
				}
			}
		});
		botonReproducir.setBounds(150,75,125,25);
		frame.getContentPane().add(botonReproducir);
	}
}
