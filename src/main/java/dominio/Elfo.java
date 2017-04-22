package dominio;
/**
 * 
 * Clase que define a un tipo de Personaje como "Elfo".
 * Por lo tanto extiende a la clase abstracta Personaje.
 *
 */
public class Elfo extends Personaje {

	public Elfo(String nombre, Casta casta, int id) {
		super(nombre, casta, id);
		energiaTope += 10;
		salud = saludTope;
		energia = energiaTope;
		nombreRaza = "Elfo";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Golpe Level";
		habilidadesRaza[1] = "Ataque Bosque";
	}

	public Elfo(String nombre, int salud, int energia, int fuerza, int destreza, int inteligencia, Casta casta,
			int experiencia, int nivel,
			int idPersonaje) {
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
	 * En caso de poder realizarse el ataque se pierde la Energia utilizada y se devuelve true, caso contrario devuelve false.
	 * 
	 * @param atacado Peleable a ser atacado por el Elfo.
	 * @return true en caso de realizarse el ataque, false en caso contrario.
	 */
	public boolean habilidadRaza1(Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			if (atacado.serAtacado(this.getFuerza() + this.getNivel() * 10) > 0)
				return true;
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
	public boolean habilidadRaza2(Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			if (atacado.serAtacado((int) (this.magia)) > 0)
				return true;
		}
		return false;
	}
}
