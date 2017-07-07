package testMensajeria;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import mensajeria.PaqueteDePersonajes;
import mensajeria.PaquetePersonaje;

public class TestPaqueteDePersonajes {
	PaqueteDePersonajes pdp;
	
	@Test
	public void testConstructor1() {
		pdp = new PaqueteDePersonajes();
	}
	
	@Test
	public void testPaqueteDePersonajes() {
		PaquetePersonaje pp1 = new PaquetePersonaje();
		pp1.setId(23);
		PaquetePersonaje pp2 = new PaquetePersonaje();
		pp2.setId(24);
		
		Map<Integer, PaquetePersonaje> mapa = new HashMap<>();
		mapa.put(0, pp1);
		mapa.put(1, pp2);
		
		pdp = new PaqueteDePersonajes(mapa);
		
		Assert.assertEquals(pdp.getPersonajes().get(0).getId(), 23);
		Assert.assertEquals(pdp.getPersonajes().get(1).getId(), 24);
	}
	
}
 