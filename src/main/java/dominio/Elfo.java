package dominio;
/**
 * <h3>Clase Elfo</h3>
 * <p>Clase que define a un tipo de Personaje como "Elfo".<br>
 * Por lo tanto extiende a la clase abstracta Personaje.</p>
 *
 */
public class Elfo extends Personaje {

  /**
   * <h3>Constructor de Elfo</h3>
   * @param nombre del pesonaje
   * @param casta del pesonaje
   * @param id  del perosnaje
   */
	public Elfo(final String nombre, final Casta casta, final int id) {
		super(nombre, casta, id);
		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Golpe Level";
		habilidadesRaza[1] = "Ataque Bosque";
		setearAtributosRaza(0, 10, "Elfo");
	}

	/**
	 * <h3>Constructor de Elfo</h3>
	 * @param nombre del personaje
	 * @param salud del personaje
	 * @param energia del personaje
	 * @param fuerza del personaje
	 * @param destreza del personaje
	 * @param inteligencia del personaje
	 * @param casta del personaje
	 * @param experiencia del personaje
	 * @param nivel del pj
	 * @param idPersonaje del personaje
	 */
	public Elfo(final String nombre, final int salud, final int energia,
	    final int fuerza, final int destreza, final int inteligencia,
	    final Casta casta, final int experiencia, final int nivel,
	    final int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta,
				experiencia, nivel, idPersonaje);
		nombreRaza = "Elfo";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Golpe Level";
		habilidadesRaza[1] = "Ataque Bosque";
	}

	// Golpe Level
	/**
	 * <h3><u>Golpe Level</u></h3>
	 * Intenta un golpe utilizando la fuerza del Elfo + el nivel de dicho Personaje.<br>
	 * En caso de poder realizarse el ataque se pierde la Energia utilizada y se devuelve true,
	 * caso contrario devuelve false.
	 *
	 * @param atacado Peleable a ser atacado por el Elfo.
	 * @return boolean true en caso de realizarse el ataque, false en caso contrario.
	 */
	public boolean habilidadRaza1(final Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.serDesenergizado(10);
			if (atacado.serAtacado(this.getFuerza() + this.getNivel() * 10) > 0) {
				return true;
			}
		}
		return false;
	}

	// Ataque Bosque
	/**
	 * <h3><u>Golpe Bosque</u></h3>
	 * Intenta un golpe utilizando la magia del Elfo como daño a causar.<br>
	 * En caso de poder realizarse el ataque se pierde la Energia utilizada
	 * y se devuelve true, caso contrario devuelve false.
	 * @param atacado Peleable a ser atacado por el Elfo.
	 * @return true en caso de realizarse el ataque, false en caso contrario.
	 */
	public boolean habilidadRaza2(final Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.serDesenergizado(10);
			if (atacado.serAtacado((int) (this.magia)) > 0) {
				return true;
			}
		}
		return false;
	}
}
