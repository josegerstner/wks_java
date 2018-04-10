package colecciones;

public class Cliente {
	public Cliente(String nombre, String nroCuenta, double saldo){
		this.nombre = nombre;
		this. nroCuenta = nroCuenta;
		this.saldo = saldo;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNroCuenta() {
		return nroCuenta;
	}
	public void setNroCuenta(String nroCuenta) {
		this.nroCuenta = nroCuenta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nroCuenta == null) ? 0 : nroCuenta.hashCode());
		return result;
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (nroCuenta == null) {
			if (other.nroCuenta != null)
				return false;
		} else if (!nroCuenta.equals(other.nroCuenta))
			return false;
		return true;
	}

	private String nombre;
	private String nroCuenta;
	private double saldo;
}
