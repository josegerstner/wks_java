package chat;

import javax.swing.*;

import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServidorChat  {
	public static void main(String[] args) {
		MarcoServidor mimarco=new MarcoServidor();
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	
}
@SuppressWarnings("serial")
class MarcoServidor extends JFrame implements Runnable {	
	public MarcoServidor(){
		setTitle("Servidor");
		setBounds(650,150,280,350);				
		JPanel milamina= new JPanel();
		milamina.setLayout(new BorderLayout());
		areatexto=new JTextArea();
		milamina.add(areatexto,BorderLayout.CENTER);
		add(milamina);
		setVisible(true);
		
		Thread mihilo = new Thread(this);
		mihilo.start();
	}
	public void run() {
		try {
			ServerSocket servidor = new ServerSocket(9999);
			String nick, ip, mensaje;
			ArrayList<String> listaIp = new ArrayList<String>();
			PaqueteEnvio paqueteRecibido;
			while(true){
				Socket misocket = servidor.accept();
				
				//recibe la info
				ObjectInputStream paqueteDatos = new ObjectInputStream(misocket.getInputStream());
				paqueteRecibido = (PaqueteEnvio) paqueteDatos.readObject();
				nick = paqueteRecibido.getNick();
				ip = paqueteRecibido.getIp();
				mensaje = paqueteRecibido.getMensaje();
				
				if(!mensaje.equals(" online")){
					//escribo lo recibido en el servidor
					areatexto.append("\n" + nick + ": " + mensaje + " para " + ip);
					//reenvía la info
					Socket enviaDestinatario = new Socket(ip, 9090);
					ObjectOutputStream paqueteReenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());
					paqueteReenvio.writeObject(paqueteRecibido);
					
					//cerramos las conexiones
					paqueteReenvio.close();
					enviaDestinatario.close();
					misocket.close();
				}else{
					//-----DETECTA ONLINE-----------------------
					InetAddress localizacion = misocket.getInetAddress();
					String IpRemota = localizacion.getHostAddress();
					System.out.println("Online " + IpRemota);
					listaIp.add(IpRemota);
					paqueteRecibido.setIps(listaIp);
					for(String z: listaIp){
						System.out.println("Array: " + z);
						
						//envía las ips
						Socket enviaDestinatario = new Socket(z, 9090);
						ObjectOutputStream paqueteReenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());
						paqueteReenvio.writeObject(paqueteRecibido);
						
						//cerramos las conexiones
						paqueteReenvio.close();
						enviaDestinatario.close();
						misocket.close();
					}
					//--------------------------------------------

				}
			}
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	private	JTextArea areatexto;
}
