package testMensajeria;

import org.junit.Assert;
import org.junit.Test;

import mensajeria.Comando;
import mensajeria.PaqueteBatalla;

public class TestPaqueteBatalla {
	PaqueteBatalla pb = new PaqueteBatalla();
	
	@Test
	public void testTurno() {
		Assert.assertFalse(pb.isMiTurno());
		pb.setMiTurno(true);
		Assert.assertTrue(pb.isMiTurno());
	}
	
	@Test
	public void Seters() {
		Assert.assertEquals(Comando.BATALLA, pb.getComando());
		pb.setId(29);
		pb.setIdEnemigo(12);
		Assert.assertEquals(29, pb.getId());
		Assert.assertEquals(12, pb.getIdEnemigo());
	}
}
