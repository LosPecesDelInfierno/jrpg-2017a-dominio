package dominio;

import java.util.LinkedList;
/**
 * Clase encargada de agrupar con un nombre especÃ­fico de alianza a los personajes que estan
 * aliados.
 *
 */
public class Alianza {

	private String nombre;
	private LinkedList<Personaje> aliados;
/**
 * <h3><u>Constructor de una Alianza</u></h3>
 * <p>Se recibirÃ¡ un nombre (String) para definir la Alianza y
 * se asociarÃ¡ el miembro "aliados" a un nuevo LinkedList de personajes.<br>
 * Es importante saber dicho nombre no tiene la posibilidad de ser modificado luego de creada la Alianza.</p>
 * @param nombre Es un String que servira de nombre de la Alianza a crear.
 */
	public Alianza(final String nombre) {
		this.nombre = nombre;
		this.aliados = new LinkedList<Personaje>();
	}

/**
 * <h3>getAliados</h3>
 * Retorna lista de aliados.
 * @return aliados pertenecientes a la alianza
 */
	public LinkedList<Personaje> getAliados() {
		return (LinkedList<Personaje>) aliados.clone();
	}

/**
 * <h3>Metodo obtenerNombre</h3>
 * Metodo que devuelve el nombre de la alianza.
 * @return nombre de la alianza
 */
	public String obtenerNombre() {
		return nombre;
	}

	/**
	 * <h3><u>MÃ©todo eliminarPersonaje</u></h3>
	 * <p>MÃ©todo encargado de la eliminaciÃ³n de un personaje de la alianza llamadora del mÃ©todo.</p>
	 * @param pj Objeto (de tipo Personaje) a eliminar del LinkedList compuesto por personajes aliados entre sÃ­.
	 */
	public void eliminarPersonaje(final Personaje pj) {
		aliados.remove(pj);
	}

/**
 * <h3>Metodo anadirPersonaje</h3>
 * Metodo encargado de anadir un personaje a la alianza
 * @param pj Personaje a agregar
 */
	public void anadirPersonaje(final Personaje pj) {
		aliados.add(pj);
	}
}
