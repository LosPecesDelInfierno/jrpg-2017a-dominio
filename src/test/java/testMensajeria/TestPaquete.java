package testMensajeria;

import org.junit.Assert;
import org.junit.Test;

import mensajeria.Comando;
import mensajeria.Paquete;

public class TestPaquete {

	@Test
	public void testConstructor1() {
		Paquete p = new Paquete("mensaje", "nick", "192.129.399", 2);
		Assert.assertEquals("mensaje", p.getMensaje());
		Assert.assertEquals("192.129.399", p.getIp());
		Assert.assertEquals(2, p.getComando());
	}

	@Test
	public void testConstructor2() {
		Paquete p = new Paquete("mensaje", 2);
		Assert.assertEquals("mensaje", p.getMensaje());
		Assert.assertEquals(2, p.getComando());
	}

	@Test
	public void testConstructor3() {
		Paquete p = new Paquete(6);
		Assert.assertEquals(6, p.getComando());
	}

	@Test
	public void testComandos() {
		Comando c = new Comando();
		Assert.assertEquals(c.ATACAR, 9);
	}

}
