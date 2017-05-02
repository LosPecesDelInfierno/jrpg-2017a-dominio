package dominio;

import java.util.LinkedList;
/**
 * Clase encargada de agrupar con un nombre específico de alianza a los personajes que están
 * aliados.
 *
 */
public class Alianza {

	private String nombre;
	private LinkedList<Personaje> aliados;
/**
 * <h3><u>Constructor de una Alianza</u></h3>
 * <p>Se recibirá un nombre (String) para definir la Alianza y
 * se asociará el miembro "aliados" a un nuevo LinkedList de personajes.<br>
 * Es importante saber dicho nombre no tiene la posibilidad de ser modificado luego de creada la Alianza.</p>
 * @param nombre Es un String que servirá de nombre de la Alianza a crear.
 */
	public Alianza(final String nombre) {
		this.nombre = nombre;
		this.aliados = new LinkedList<Personaje>();
	}

/**
 * <h3>getAliados</h3>
 * Retorna lista de aliados.
 * @return aliados
 */
	public LinkedList<Personaje> getAliados() {
		return aliados;
	}

/**
 * <h3>Metodo setAliados</h3>
 * Metodo encargado de setear la lista de aliados.
 * @param aliados
 */
	public void setAliados(final LinkedList<Personaje> aliados) {
		this.aliados = aliados;
	}

/**
 * <h3>Metodo obtenerNombre</h3>
 * Metodo que devuelve el nombre de la alianza.
 * @return
 */
	public String obtenerNombre() {
		return nombre;
	}

	/**
	 * <h3><u>Método eliminarPersonaje</u></h3>
	 * <p>Método encargado de la eliminación de un personaje de la alianza llamadora del método.</p>
	 * @param pj Objeto (de tipo Personaje) a eliminar del LinkedList compuesto por personajes aliados entre sí.
	 */
	public void eliminarPersonaje(final Personaje pj) {
		aliados.remove(pj);
	}

/**
 * <h3>Metodo anadirPersonaje</h3>
 * Metodo encargado de anadir un personaje a la alianza
 * @param pj
 */
	public void anadirPersonaje(final Personaje pj) {
		aliados.add(pj);
	}
}
