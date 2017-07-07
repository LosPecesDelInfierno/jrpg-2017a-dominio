package testMensajeria;

import org.junit.Assert;
import org.junit.Test;

import mensajeria.PaqueteUsuario;

public class TestPaqueteUsuario {

	PaqueteUsuario pu = new PaqueteUsuario();

	@Test
	public void testConstructor() {
		PaqueteUsuario p = new PaqueteUsuario("User1", "contraseña");
		Assert.assertEquals("User1", p.getUsername());
		Assert.assertEquals("contraseña", p.getPassword());
		Assert.assertFalse(p.isInicioSesion());
	}

	@Test
	public void testSetters() {
		pu.setComando(2);
		pu.setInicioSesion(true);
		pu.setIp("192.231.111");
		pu.setMensaje("Hola");
		pu.setPassword("passwordPrueba");
		pu.setUsername("UsuarioPrueba");

		Assert.assertEquals(2, pu.getComando());
		Assert.assertTrue(pu.isInicioSesion());
		Assert.assertEquals("192.231.111", pu.getIp());
		Assert.assertEquals("Hola", pu.getMensaje());
		Assert.assertEquals("UsuarioPrueba", pu.getUsername());
		Assert.assertEquals("passwordPrueba", pu.getPassword());

	}
}
