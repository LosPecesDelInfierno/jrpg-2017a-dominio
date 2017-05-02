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
   * @param nombre
   * @param casta
   * @param id
   */
	public Elfo(final String nombre, final Casta casta, final int id) {
		super(nombre, casta, id);
		energiaTope += 10;
		salud = saludTope;
		energia = energiaTope;
		nombreRaza = "Elfo";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Golpe Level";
		habilidadesRaza[1] = "Ataque Bosque";
	}

	/**
	 * <h3>Constructor de Elfo</h3>
	 * @param nombre
	 * @param salud
	 * @param energia
	 * @param fuerza
	 * @param destreza
	 * @param inteligencia
	 * @param casta
	 * @param experiencia
	 * @param nivel
	 * @param idPersonaje
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
	 * @return true en caso de realizarse el ataque, false en caso contrario.
	 */
	public boolean habilidadRaza1(final Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
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
			this.setEnergia(this.getEnergia() - 10);
			if (atacado.serAtacado((int) (this.magia)) > 0) {
				return true;
			}
		}
		return false;
	}
}
