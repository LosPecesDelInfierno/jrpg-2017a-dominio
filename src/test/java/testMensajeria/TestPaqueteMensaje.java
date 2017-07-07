package testMensajeria;

import org.junit.Assert;
import org.junit.Test;

import mensajeria.PaqueteMensaje;

public class TestPaqueteMensaje {
	PaqueteMensaje pm;

	@Test
	public void testConstructor1() {
		pm = new PaqueteMensaje(2, 23, "mensaje");
		Assert.assertEquals("mensaje", pm.getContenido());
		Assert.assertEquals(2, pm.getIdEmisor());
		Assert.assertEquals(23, pm.getIdDestinatario());
		Assert.assertFalse(pm.esDifusion());
	}

	@Test
	public void testConstructor2() {
		pm = new PaqueteMensaje(22, "mensaje");
		Assert.assertEquals("mensaje", pm.getContenido());
		Assert.assertEquals(22, pm.getIdEmisor());
		Assert.assertTrue(pm.esDifusion());
	}

}
