package testsDominio;

import org.junit.Assert;
import org.junit.Test;

import dominio.ModificadorItem;

public class TestModificadorItem {
	ModificadorItem mi;
	
	@Test
	public void testModificadorItem() {
		mi = new ModificadorItem(1, 14, false);
		
		Assert.assertEquals(mi.getValor(), 14);
		Assert.assertFalse(mi.isEsPorcentaje());
	}
}
