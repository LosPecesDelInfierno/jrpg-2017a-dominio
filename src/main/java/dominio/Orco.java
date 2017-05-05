package dominio;
/**
 *
 * Clase que define un Personaje del tipo "Orco", por lo tanto extiende
 * a la clase abstracta Personaje.
 * (NO tiene variables miebro propias)
 *
 */
public class Orco extends Personaje {

  /**
   * <h3>Constructor de Orco</h3>
   * @param nombre del personaje
   * @param casta del personaje
   * @param id del personaje
   */
	public Orco(final String nombre, final Casta casta, final int id) {
		super(nombre, casta, id);
		saludTope += 10;
		salud = saludTope;
		energia = energiaTope;
		nombreRaza = "Orco";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Golpe Defensa";
		habilidadesRaza[1] = "Mordisco de Vida";
	}

	/**
	 * <h3>Constructor de Orco</h3>
	 * @param nombre del personaje
	 * @param salud del personaje
	 * @param energia del personaje
	 * @param fuerza del personaje
	 * @param destreza del personaje
	 * @param inteligencia del personaje
	 * @param casta del personaje
	 * @param experiencia del personaje
	 * @param nivel del personaje
	 * @param idPersonaje del personaje
	 */
	public Orco(final String nombre, final int salud, final int energia,
	    final int fuerza, final int destreza, final int inteligencia,
	    final Casta casta, final int experiencia, final int nivel,
	    final int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje);
		nombreRaza = "Orco";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Golpe Defensa";
		habilidadesRaza[1] = "Mordisco de Vida";
	}

	// Golpe Defensa
	/**
	 * <h3><u>Golpe Defensa</u></h3>
	 * Intenta un golpe usando el valor de su defensa
	 * (provoca un daño de hasta un max igual al doble del valor de la defensa del Orco).<p>
	 * En caso de poder realizarse se reduce la energia en 10 y se devuelve true.<br>
	 * Caso contrario devuelve false y no se pierde energia.
	 *
	 * @param atacado Peleable a ser atacado por el Orco.
	 * @return true en caso de realizarse el ataque, false en caso contrario.
	 */
	public boolean habilidadRaza1(final Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			if (atacado.serAtacado(this.getDefensa() * 2) > 0) {
				return true;
			}
		}
		return false;
	}

	// Mordisco de Vida
	/**
	 * <h3><u>Mordisco de Vida</u></h3>
	 * Siempre que la energia del Orco lo permita.<br>
	 * Si luego de un ataque de un Orco a un objeto Peleable, el daño causado es mayor que cero;
	 * dicho objeto recupera vida por el mismo valor de daño que hubiese causado el Orco.
	 * @param atacado Peleable mordido por el Orco.
	 * @return true en caso de realizarse la mordida, false en caso contrario.
	 */
	public boolean habilidadRaza2(final Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			int danioCausado = atacado.serAtacado(this.getFuerza());
			if (danioCausado > 0) {
				this.serCurado(danioCausado);
				return true;
			}
		}
		return false;
	}
}
