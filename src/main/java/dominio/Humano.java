package dominio;
/**
 *
 * Clase que define un Personaje del tipo "Humano", por lo tanto extiende
 * a la clase abstracta Personaje.
 * (NO tiene variables miebro propias)
 *
 */
public class Humano extends Personaje {
/**
 * <h3><u>Método Constructor por defecto</u></h3>
 * Recibe los parámetros específicos del constructor parametrizado de su clase padre (nombre, casta , id),
 * llama al constructor parametrizado padre con dichos parametros
 * y define por defecto saludTope, energiaTope, salud, energia y nombreRaza
 * @param nombre Es un String que representa el nombre del Humano a crear.
 * @param casta Variable del tipo Casta que determina a que casta pertenecerá.
 * @param id Es un int que representa el id del personaje.
 */
	public Humano(final String nombre, final Casta casta, final int id) {
		super(nombre, casta, id);
		saludTope += 5;
		energiaTope += 5;
		salud = saludTope;
		energia = energiaTope;
		nombreRaza = "Humano";
	}

	/**
	 * <h3>Constructor parametrizado de Humano</h3>
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
	public Humano(final String nombre, final int salud, final int energia,
	    final int fuerza, final int destreza, final int inteligencia,
	    final Casta casta, final int experiencia,
	    final int nivel, final int idPersonaje) {
		super(nombre, salud, energia, fuerza, destreza, inteligencia, casta, experiencia, nivel, idPersonaje);
		nombreRaza = "Humano";

		habilidadesRaza = new String[2];
		habilidadesRaza[0] = "Incentivar";
		habilidadesRaza[1] = "Golpe Fatal";
	}

	// Incentivar
	/**
	 * <h3>Incentivar</h3>
	 * Implementacion del método abstracto habilidad1 declarado en la clase abstracta Casta.
	 * @param atacado
	 * @return boolean
	 */
	public boolean habilidadRaza1(final Peleable atacado) {
		if (this.getEnergia() > 10) {
			this.setEnergia(this.getEnergia() - 10);
			atacado.setAtaque(atacado.getAtaque() + this.getMagia());
			return true;
		}
		return false;
	}

	// Golpe Fatal
	/**
	 * <h3><u>Golpe Fatal</u></h3>
	 * Intenta un golpe fatal (provoca hasta un max de la mitad de la vida del objeto Peleable atacado).<p>
	 * En caso de poder realizarse, se reduce la energía a la mitad retornando un boolean true.<br>
	 * Caso contrario devuelve false y se piede la energía.
	 *
	 * @param atacado Peleable a ser atacado por el Humano.
	 * @return true en caso de realizarse el ataque, false en caso contrario.
	 */
	public boolean habilidadRaza2(final Peleable atacado) {
		if (this.getEnergia() > 10) {
			if (atacado.serAtacado(atacado.getSalud() / 2) > 0) {
				this.setEnergia(this.getEnergia() / 2);
				return true;
			}
		}
		this.setEnergia(this.getEnergia() - 10);
		return false;
	}
}
