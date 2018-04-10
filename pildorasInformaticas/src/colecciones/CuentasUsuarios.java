package colecciones;

import java.util.HashSet;
import java.util.Iterator;

public class CuentasUsuarios {
	public static void main(String[] args) {
		Cliente cl1 = new Cliente("Antonio Banderas", "00001", 200000);
		Cliente cl2 = new Cliente("Rafael Nadal", "00002", 250000);
		Cliente cl3 = new Cliente("Penelope Cruz", "00003", 300000);
		Cliente cl4 = new Cliente("Julio Iglesias", "00004", 500000);
		Cliente cl5 = new Cliente("Antonio Banderas", "00001", 200000);
		
		HashSet <Cliente> clientesBanco = new HashSet <Cliente>();
		
		clientesBanco.add(cl1);
		clientesBanco.add(cl2);
		clientesBanco.add(cl3);
		clientesBanco.add(cl4);
		//si yo agrego un cliente con los mismos datos, la MV de java no se da cuenta
		//por eso sobreescribimos el método equals
		clientesBanco.add(cl5);

		
		Iterator<Cliente> it = clientesBanco.iterator();
		while(it.hasNext()){
			String nombreCliente = it.next().getNombre();
			if(nombreCliente.equals("Julio Iglesias")){
				it.remove();
			}
		}
		
		for (Cliente cliente : clientesBanco) {
			System.out.println(cliente.getNombre() + " " + cliente.getNroCuenta() + " " + cliente.getSaldo());
		}
	}
}
