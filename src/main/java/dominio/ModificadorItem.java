package dominio;

public class ModificadorItem {
	private int atributoModificable;
	private int valor;
	private boolean esPorcentaje;

	public ModificadorItem(final int idAtributoModificable, final int valor, final boolean esPorcentaje) {
		this.atributoModificable = idAtributoModificable;
		this.valor = valor;
		this.esPorcentaje = esPorcentaje;
	}

	public int getAtributoModificable() {
		return atributoModificable;
	}

	public int getValor() {
		return valor;
	}

	public boolean isEsPorcentaje() {
		return esPorcentaje;
	}

	@Override
	public String toString() {
		String val = (this.valor > 0 ? "+" : "") + this.valor + (this.esPorcentaje ? "%" : "");
		return val + " de " + AtributoModificable.getNombre(this.atributoModificable);
	}

	public int incrementar(final int valorInicial) {
		if (this.esPorcentaje) {
			return (valorInicial * this.valor / 100);
		}
		return this.valor;
	}
}
