package dominio;

public class ModificadorItem {
	private int atributoModificable;
	private int valor;
	private boolean esPorcentaje;
	
	public ModificadorItem(int idAtributoModificable, int valor, boolean esPorcentaje) {
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
	
	public int incrementar(int valorInicial) {
		if(this.esPorcentaje) {
			return valorInicial + (valorInicial * this.valor / 100);
		}
		return valorInicial + this.valor;
	}
	
	public int decrementar(int valorInicial) {
		if(this.esPorcentaje && valorInicial != 0) {
			return valorInicial - (valorInicial * this.valor / 100);
		}
		else if(valorInicial > this.valor) {
			return valorInicial - this.valor;
		}
		return 0;
	}
}
