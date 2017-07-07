package dominio;

/**
 *
 * Clase que define a un tipo Hechicero, la misma hereda de la clase abstracta
 * Casta por lo que se definen los métodos abstractos declarados en Casta y se
 * define al nombreCasta como "Hechicero".
 *
 */
public class Hechicero extends Casta {

	/**
	 * <h3>Contructor parametrizado de Hechicero</h3>
	 * 
	 * @param probCrit
	 *            probabilidad de hacer danio critico
	 * @param evasion
	 *            capacidad de evadir
	 * @param danioCrit
	 *            danio critico que realiza
	 */
	public Hechicero(final double probCrit, final double evasion, final double danioCrit) {
		super(probCrit, evasion, danioCrit);
		this.nombreCasta = "Hechicero";
	}

	/**
	 * <h3>Constructor por defecto de Hechicero</h3>
	 */
	public Hechicero() {
		super();
		this.nombreCasta = "Hechicero";
		habilidadesCasta = new String[CANT_HABILIDADES];
		habilidadesCasta[0] = "Bola de Fuego";
		habilidadesCasta[1] = "Curar Aliado";
		habilidadesCasta[2] = "Robar Energia y Salud";
	}

	// Bola de Fuego
	/**
	 * <h3><u>Bola de Fuego</u></h3> Implementacion del método abstracto
	 * habilidad1 declarado en la clase abstracta Casta.
	 * <p>
	 * En este caso el método es el encargado de producir un ataque por Bola de
	 * Fuego por parte de un hechicero hacia un objeto Peleable.<br>
	 * Nótese que en este caso el Personaje que ataca es parámetro.
	 * 
	 * @param caster
	 *            Objeto de tipo Personaje encargado del ataque.
	 * @param atacado
	 *            Objeto de tipo Peleable a ser atacado.
	 * @return Si el caster tiene suficiente energia para realizar el ataque
	 *         devuelve un boolean true, caso contrario devuelve false.
	 */
	public boolean habilidad1(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.serDesenergizado(10);
			if (atacado.serAtacado((int) (caster.calcularPuntosDeMagia() * 1.5)) > 0) {
				return true;
			}
		}
		return false;
	}

	// Curar Aliado
	/**
	 * <h3><u>Curar Aliado</u></h3> Implementacion del método abstracto
	 * habilidad2 declarado en la clase abstracta Casta.
	 * <p>
	 * En este caso el método es el encargado de curar a un Peleable aliado, por
	 * parte de un hechicero.<br>
	 * Nótese que el Personaje que cura es parámetro.
	 * 
	 * @param caster
	 *            Objeto de tipo Personaje encargado de la sanacion.
	 * @param aliado
	 *            Objeto de tipo Peleable a ser curado.
	 * @return Si el caster tiene suficiente energia para realizar la sanación
	 *         devuelve un boolean true, caso contrario devuelve false.
	 */
	public boolean habilidad2(final Personaje caster, final Peleable aliado) {
		if (caster.getEnergia() > 10) {
			caster.serDesenergizado(10);
			if (aliado instanceof Personaje) {
				((Personaje) aliado).serCurado(caster.calcularPuntosDeMagia());
				return true;
			}
		}
		return false;
	}

	// Robar Energia y Salud
	/**
	 * <h3>Robar Energia y Salud</h3> Implementacion del método abstracto
	 * habilidad3 declarado en la clase abstracta Casta.
	 * 
	 * @param caster
	 *            De tipo Personaje encargado de obtener y setear energías.
	 * @param atacado
	 *            De tipo Peleable (no se utiliza)
	 * @return boolean
	 */
	public boolean habilidad3(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() > 10) {
			caster.serDesenergizado(10);
			if (atacado.sufreDanioExtra()) {
				int energiaRobada = ((Personaje) atacado).serDesenergizado(caster.calcularPuntosDeMagia());
				int saludRobada = ((Personaje) atacado).serRobadoSalud(caster.calcularPuntosDeMagia() / 2);
				caster.serEnergizado(energiaRobada);
				caster.serCurado(saludRobada);
				return true;
			}
		}
		return false;
	}

	@Override
	public int getBonusFuerza() {
		return 0;
	}

	@Override
	public int getBonusInteligencia() {
		return 5;
	}

	@Override
	public int getBonusDestreza() {
		return 0;
	}
}
