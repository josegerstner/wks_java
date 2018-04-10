package threads;

public class BancoSinSincronizar {
	public static void main(String[] args) {
		Banco banco = new Banco();
		for(int i=0; i<100; i++){
			EjecucionTransferencias runnable = new EjecucionTransferencias(banco, i, 2000);
			Thread thread = new Thread(runnable);
			thread.start();
		}
	}
}
class Banco{
	public Banco(){
		cuentas = new double[100];
		for(int i=0; i<cuentas.length; i++){
			cuentas[i] = 2000;
		}
		
		//saldoSuficiente = cierreBanco.newCondition();
	}
	
	public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException{
		//lock bloquea lo que sigue para que no entre otro thread
		//cierreBanco.lock();
		//try{
			//if(cuentas[cuentaOrigen] < cantidad){
			while(cuentas[cuentaOrigen] < cantidad){
				System.out.printf("SALDO INSUFICIENTE: Cuenta: %d Saldo: %.2f Transferencia: %.2f\n", cuentaOrigen, cuentas[cuentaOrigen], cantidad);
				//return;

				//el método await duerme el thread hasta que le den signal
				//saldoSuficiente.await();
				
				//wait duerme al hilo
				wait();
			
			}//else{
				//System.out.println("TRANSFERENCIA OK");
			//}
			System.out.println(Thread.currentThread());
		//	dinero que sale de la cuenta origen
			cuentas[cuentaOrigen] -= cantidad;
			System.out.printf("\t%.2f de %d para %d\n", cantidad, cuentaOrigen, cuentaDestino);
		//	dinero que entra a la cuenta destino
			cuentas[cuentaDestino] += cantidad;
			System.out.printf("\tSaldo total: %.2f\n", getSaldoTotal());
			
			//signalAll despierta a todos los hilos dormidos
			//para que se fijen si les sirve el estado actual
			//saldoSuficiente.signalAll();
			
			//notifyAll deapierta a los hilos
			notifyAll();
		//}finally{
			//unlock libera el bloqueo producido por el thread que estaba ejecutando
			//cierreBanco.unlock();
		//}
	}
	
	public double getSaldoTotal(){
		double sumaCuentas = 0;
		for(double a: cuentas){
			sumaCuentas += a;
		}
		return sumaCuentas;
	}
	private final double[] cuentas;
	//private Lock cierreBanco = new ReentrantLock();
	//private Condition saldoSuficiente;
}
class EjecucionTransferencias implements Runnable{
	public EjecucionTransferencias(Banco banco, int cuentaOrigen, double cantidadMaxima){
		this.banco = banco;
		this.cuentaOrigen = cuentaOrigen;
		this.cantidadMaxima = cantidadMaxima;
	}
	public void run() {
		try {
			while(true){
				int cuentaDestino = (int)(Math.random()*100);
				double cantidad = cantidadMaxima * Math.random();
				banco.transferencia(cuentaOrigen, cuentaDestino, cantidad);			
				Thread.sleep((int)(Math.random()*10));
			}
		} catch (InterruptedException e) {
			System.out.println("Hubo algún quilombo /*o*\\");
		}
	}
	private Banco banco;
	private int cuentaOrigen;
	private double cantidadMaxima;
}