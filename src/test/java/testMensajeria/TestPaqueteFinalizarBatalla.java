package testMensajeria;

import org.junit.Assert;
import org.junit.Test;

import mensajeria.PaqueteFinalizarBatalla;

public class TestPaqueteFinalizarBatalla {

	PaqueteFinalizarBatalla pfb = new PaqueteFinalizarBatalla();;
	
	@Test
	public void testSetId() {
		pfb.setId(23);
		Assert.assertEquals(23, pfb.getId());
	}
	
	@Test
	public void testSetIdEnemigo() {
		pfb.setIdEnemigo(44);
		Assert.assertEquals(44, pfb.getIdEnemigo());
	}
}
