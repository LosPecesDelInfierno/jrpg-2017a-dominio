package testMensajeria;

import org.junit.Assert;
import org.junit.Test;

import mensajeria.Comando;
import mensajeria.PaqueteMovimiento;

public class TestPaqueteMovimiento {
	PaqueteMovimiento pm;

	@Test
	public void testConstructor1() {
		pm = new PaqueteMovimiento();
		Assert.assertEquals(Comando.MOVIMIENTO, pm.getComando());
	}

	@Test
	public void testConstructor2() {
		pm = new PaqueteMovimiento(29);
		Assert.assertEquals(29, pm.getIdPersonaje());
	}

	@Test
	public void testConstructor3() {
		pm = new PaqueteMovimiento(12, (float) 18.2, (float) 20.2);
		Assert.assertEquals(12, pm.getIdPersonaje());
		Assert.assertTrue(Float.valueOf((float) 18.2).equals(Float.valueOf(pm.getPosX())));
		Assert.assertTrue(Float.valueOf((float) 20.2).equals(Float.valueOf(pm.getPosY())));
	}

	@Test
	public void testSeters() {
		pm = new PaqueteMovimiento();
		pm.setComando(Comando.FINALIZARCOMERCIO);
		pm.setDireccion(23);
		pm.setFrame(2);
		pm.setIdPersonaje(29);
		pm.setIp("192.122.333");
		pm.setMensaje("mensaje");
		pm.setPosX((float) 11.2);
		pm.setPosY((float) 11.4);

		Assert.assertEquals(Comando.FINALIZARCOMERCIO, pm.getComando());
		Assert.assertEquals(23, pm.getDireccion());
		Assert.assertEquals(2, pm.getFrame());
		Assert.assertEquals(29, pm.getIdPersonaje());
		Assert.assertEquals("192.122.333", pm.getIp());
		Assert.assertEquals("mensaje", pm.getMensaje());
		Assert.assertTrue(Float.valueOf((float) 11.2).equals(Float.valueOf(pm.getPosX())));
		Assert.assertTrue(Float.valueOf((float) 11.4).equals(Float.valueOf(pm.getPosY())));
	}

}
