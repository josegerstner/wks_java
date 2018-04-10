package vehiculo;

public class Vehiculo {
	//ATRIBUTOS
	//los modificadores de acceso ENCAPSULAN las variables
	private String matricula;
	private String marca;
	private String modelo;
	private int anio;
	public Vehiculo(String matricula, String marca){
		super();
		if(matricula.length() == 6){
			this.matricula = matricula;
		}else{
			System.out.println("La matrícula debe ser de 6 caracteres");
		}
		this.marca = marca;
	}
	public Vehiculo(String matricula, String marca, String modelo, int anio) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.anio = anio;
	}

	//GETTERS
	public String getMatricula() {
		return matricula;
	}
	public String getMarca() {
		return marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	//METODOS (COMPORTAMIENTO)
	public void arrancar(){
		System.out.println("El vehículo arrancó");
	}
	public void frenar(){
		System.out.println("El vehículo frenó");
	}
	public void reversa(){
		System.out.println("El vehículo está de reversa");
	}
}
