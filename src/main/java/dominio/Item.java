package dominio;

import java.util.HashMap;
import java.util.Map;

/**
*
* <p>
* Clase que define los atributos de un Item que puede ser equipado por los Personajes
* </p>
*
*/
public class Item {
	private int id;
	private String nombre;
	private int idTipoItem;
	private int fuerzaRequerida;
	private int destrezaRequerida;
	private int inteligenciaRequerida;
	private Map<Integer, ModificadorItem> modificadores;
	private String foto;

	/**
	 * <h3>Contructor de Item</h3>
	 */
	public Item() {
	}

	/**
	 * <h3>Contructor de Item</h3>
	 *
	 * @param id
	 *            del item
	 * @param nombre
	 *            del item
	 * @param idTipoItem
	 *            del item
	 * @param fuerzaRequerida
	 *            del item
	 * @param destrezaRequerida
	 *            del item
	 * @param inteligenciaRequerida
	 *            del item
	 * @param foto
	 *            del item
	 */
	public Item(final int id, final String nombre, final int idTipoItem, final int fuerzaRequerida,
			final int destrezaRequerida, final int inteligenciaRequerida, final String foto) {
		this.id = id;
		this.nombre = nombre;
		this.idTipoItem = idTipoItem;
		this.fuerzaRequerida = fuerzaRequerida;
		this.destrezaRequerida = destrezaRequerida;
		this.inteligenciaRequerida = inteligenciaRequerida;
		this.foto = foto;
		this.modificadores = new HashMap<Integer, ModificadorItem>();
	}

	/**
	 * <h3>Metodo getId</h3>
	 *
	 * @return id del Item
	 */
	public int getId() {
		return id;
	}


	/**
	 * <h3>Metodo getNombre</h3>
	 *
	 * @return nombre del item
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * <h3>Metodo getIdTipoItem</h3>
	 *
	 * @return id del tipo de Item
	 */
	public int getIdTipoItem() {
		return idTipoItem;
	}


	/**
	 * <h3>Metodo getFuerzaRequerida</h3>
	 *
	 * @return fuerza que requiere el Item
	 */
	public int getFuerzaRequerida() {
		return fuerzaRequerida;
	}

	/**
	 * <h3>Metodo getDestrezaRequerida</h3>
	 *
	 * @return destreza que requiere el Item
	 */
	public int getDestrezaRequerida() {
		return destrezaRequerida;
	}

	/**
	 * <h3>Metodo getInteligenciaRequerida</h3>
	 *
	 * @return inteligencia que requiere el Item
	 */
	public int getInteligenciaRequerida() {
		return inteligenciaRequerida;
	}

	/**
	 * <h3>Metodo getFoto</h3>
	 *
	 * @return foto del Item
	 */
	public String getFoto() {
		return foto;
	}

	/**
	 * <h3>Metodo getDescripcionItem</h3>
	 *
	 * @return descripcion del Item
	 */
	public String getDescripcionItem() {
		String descripcion = this.nombre + " (";
		for (ModificadorItem modificador : this.modificadores.values()) {
			descripcion += modificador.toString() + ", ";
		}
		return descripcion.substring(0, descripcion.length() - 2) + ")";
	}

	/**
	 * <h3>Metodo addModificador</h3> 
	 * agrega un modificador de atributos al Item
	 * 
	 * @param modificador
	 * 					del item
	 * 						
	 */
	public void addModificador(final ModificadorItem modificador) {
		this.modificadores.put(modificador.getAtributoModificable(), modificador);
	}

	/**
	 * <h3>Metodo incrementar</h3>
	 *
	 *@param valor
	 *			del Item
	 *@param atributo
	 *			del Personaje
	 *@return valor que va a incrementar el item a cada atributo en particular
	 */
	public int incrementar(final int valor, final int atributo) {
		ModificadorItem aux = this.modificadores.get(atributo);
		if (aux != null) {
			return aux.incrementar(valor);
		}
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Item other = (Item) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}
}
