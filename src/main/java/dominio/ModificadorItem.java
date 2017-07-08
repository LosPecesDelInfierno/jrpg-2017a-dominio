package dominio;

/**
*
* <p>
* Clase que define los modificadores con sus atributos, que van a ser incluidos en los Items
* </p>
*
*/
public class ModificadorItem {
	private int atributoModificable;
	private int valor;
	private boolean esPorcentaje;

	/**
	 * <h3>Contructor de ModificadorItem</h3>
	 *
	 * @param idAtributoModificable
	 *            del modificador
	 * @param valor
	 *            del modificador
	 * @param esPorcentaje
	 *            del modificador
	 */
	public ModificadorItem(final int idAtributoModificable, final int valor, final boolean esPorcentaje) {
		this.atributoModificable = idAtributoModificable;
		this.valor = valor;
		this.esPorcentaje = esPorcentaje;
	}

	/**
	 * <h3>Metodo getAtributoModificable</h3>
	 *
	 * @return atributoModificable
	 */
	public int getAtributoModificable() {
		return atributoModificable;
	}

	/**
	 * <h3>Metodo getValor</h3>
	 *
	 * @return valor
	 */
	public int getValor() {
		return valor;
	}

	/**
	 * <h3>Metodo isEsPorcentaje</h3>
	 *
	 * @return esPorcentaje
	 */
	public boolean isEsPorcentaje() {
		return esPorcentaje;
	}

	@Override
	public String toString() {
		String val = (this.valor > 0 ? "+" : "") + this.valor + (this.esPorcentaje ? "%" : "");
		return val + " de " + AtributoModificable.getNombre(this.atributoModificable);
	}

	/**
	 * <h3>Metodo incrementar</h3>
	 *
	 *@param valorInicial
	 *					del atributo
	 * @return esPorcentaje
	 */
	public int incrementar(final int valorInicial) {
		if (this.esPorcentaje) {
			return (valorInicial * this.valor / 100);
		}
		return this.valor;
	}
}
