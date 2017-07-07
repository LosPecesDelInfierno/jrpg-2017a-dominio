package testMensajeria;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;


import mensajeria.PaqueteDeMovimientos;
import mensajeria.PaqueteMovimiento;

public class TestPaqueteDeMovimientos {

	PaqueteDeMovimientos pm;
	
	@Test
	public void testPaqueteMovimientos() {
		PaqueteMovimiento pm1 = new PaqueteMovimiento(23);
		PaqueteMovimiento pm2 = new PaqueteMovimiento(22);
		Map<Integer, PaqueteMovimiento> mapa = new HashMap<>();
		mapa.put(0, pm1);
		mapa.put(1, pm2);
		Map<Integer, PaqueteMovimiento> mapaReturn = new HashMap<>();
		pm = new PaqueteDeMovimientos(mapa);
		mapaReturn = pm.getPersonajes();

		Assert.assertEquals(mapaReturn.get(0).getIdPersonaje(), 23);
		Assert.assertEquals(mapaReturn.get(1).getIdPersonaje(), 22);

	}
	
	@Test 
	public void testConstructor() {
		pm = new PaqueteDeMovimientos();
	}
}
