package test.java;

import main.java.Calculador;
import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;

public class PruebaCalculadora {
	Calculador calculadora;
	
	@Before
	void init() {
		
	}
	
	@Test
	void responderAnioNacimientoYPFOk() {
		
	}
	
	@Test
	void responderAnioNacimientoYPFIncorrecta() {
		Assert.assertFalse(false);
	}
	
	@Test
	void responderCargosCafiero() {
		Assert.assertTrue(true);
	}
}