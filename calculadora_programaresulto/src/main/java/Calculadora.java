package main.java;
/*
 * Canal de Youtube: Programa Resuelto
 * https://www.youtube.com/channel/UCMMnLg0hG4akMmKSB4cxMQw
 * 
 * Parte 1:
 * Crear un programa que, al recibir como datos dos n�meros,
 * calcule la suma, resta y multiplicaci�n de dichos n�meros.
 * 
 * Parte 2:
 * Haga que el programa pregunte infinitamente por dos n�meros
 * y los opere hasta que el usuario cierre el programa.
 * Cree un separador entre cada operaci�n.
 * 
 * Parte 3:
 * Hacer que el programa funcione con ventanas emergentes.
 *
 * */

public class Calculadora {
	int resultado;
	int numero1;
	int numero2;
	
	public Calculadora(int numero1, int numero2) {
		this.numero1 = numero1;
		this.numero2 = numero2;
	}
	int sumar() {
		return resultado = numero1 + numero2;
	}
	int restar() {
		return resultado = numero1 - numero2;
	}
	int multiplicar() {
		return resultado = numero1 * numero2;
	}
}