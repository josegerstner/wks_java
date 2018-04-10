package chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.*;
import java.util.ArrayList;

import javax.swing.*;

public class ClienteChat {
	public static void main(String[] args) {
		MarcoCliente mimarco=new MarcoCliente();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
@SuppressWarnings("serial")
class MarcoCliente extends JFrame{	
	public MarcoCliente(){
		setTitle("Cliente");
		setBounds(300,150,280,350);
		LaminaMarcoCliente milamina=new LaminaMarcoCliente();
		add(milamina);
		setVisible(true);
		
		addWindowListener(new EnvioOnline());
	}
}

//-------------------ENVIO SEÑAL ONLINE---------------------------
class EnvioOnline extends WindowAdapter{
	public void windowOpened(WindowEvent e){
		try{
			//esto se envía cuando se abre la ventana, podría mandar el nick
			Socket misocket = new Socket("192.168.1.16", 9999);
			PaqueteEnvio datos = new PaqueteEnvio();
			datos.setMensaje(" online");
			ObjectOutputStream paqueteDatos = new ObjectOutputStream(misocket.getOutputStream());
			paqueteDatos.writeObject(datos);
			
			paqueteDatos.close();
			misocket.close();
			
		}catch(Exception e2){
			System.out.println(e2.getMessage());
		}
	}
}

@SuppressWarnings("serial")
class LaminaMarcoCliente extends JPanel implements Runnable {	
	public LaminaMarcoCliente(){
		String nick_usuario = JOptionPane.showInputDialog("Nick: ");
		JLabel n_nick = new JLabel("Nick: ");
		add(n_nick);
		nick= new JLabel();
		nick.setText(nick_usuario);
		add(nick);
		JLabel texto=new JLabel("Online: ");
		add(texto);
		ip = new JComboBox();
		add(ip);
		campoChat = new JTextArea(12,20);
		add(campoChat);
		campo1=new JTextField(20);
		add(campo1);		
		miboton=new JButton("Enviar");
		EnviaTexto miEvento = new EnviaTexto();
		miboton.addActionListener(miEvento);
		add(miboton);
		
		Thread miHilo = new Thread(this);
		miHilo.start();
	}
	private class EnviaTexto implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			campoChat.append("\nYo: " + campo1.getText());
			
			try {
				Socket misocket = new Socket("192.168.1.16", 9999);
				PaqueteEnvio datos = new PaqueteEnvio();
				datos.setNick(nick.getText());
				datos.setIp(ip.getSelectedItem().toString());
				datos.setMensaje(campo1.getText());
				
				ObjectOutputStream paqueteDatos = new ObjectOutputStream(misocket.getOutputStream());
				paqueteDatos.writeObject(datos);
				misocket.close();
			} catch (IOException e1) {
				System.out.println(e1.getMessage());
			}
			
		}
	}
	private JTextField campo1;
	private JComboBox ip;
	private JLabel nick;
	private JTextArea campoChat;
	private JButton miboton;
	
	public void run() {
		try{
			ServerSocket servidorCliente = new ServerSocket(9090);
			Socket cliente;
			PaqueteEnvio paqueteRecibido;
			while(true){
				//recibo datos
				cliente = servidorCliente.accept();
				ObjectInputStream flujoEntrada = new ObjectInputStream(cliente.getInputStream());
				paqueteRecibido = (PaqueteEnvio) flujoEntrada.readObject();
				
				if(!paqueteRecibido.getMensaje().equals(" online")){
					campoChat.append("\n" + paqueteRecibido.getNick() + ": " + paqueteRecibido.getMensaje());
				}else{
					//campoChat.append("\n" + paqueteRecibido.getIps());
					ArrayList<String> IpsMenu = new ArrayList<String>();
					IpsMenu = paqueteRecibido.getIps();
					ip.removeAllItems();
					for(String z: IpsMenu){
						ip.addItem(z);
					}
				}
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
}
@SuppressWarnings("serial")
class PaqueteEnvio implements Serializable{
	private String nick, ip, mensaje;
	private ArrayList<String> Ips;
	public ArrayList<String> getIps() {
		return Ips;
	}
	public void setIps(ArrayList<String> ips) {
		Ips = ips;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}