package dominio;

/**
 *
 * Personaje no jugable, "manejado por la cpu".
 *
 */
public class NonPlayableCharacter implements Peleable {

	private int salud;
	private int fuerza;
	private int defensa;
	private String nombre;
	private int nivel;
	private static final int dificultadAleatoria = -1;

	public NonPlayableCharacter(final String nombre, final int nivel, final int dificultadNPC) {
		this.nombre = nombre;
		this.nivel = nivel;
		int dificultad;
		if (dificultadNPC == dificultadAleatoria) {
			dificultad = MyRandom.nextInt(3);
		} else {
			dificultad = dificultadNPC;
		}
		switch (dificultad) {
		case 0:
			this.fuerza = 10 + (nivel - 1) * 3; // 30%
			this.salud = 30 + (nivel - 1) * 15;
			this.defensa = 2 + (nivel - 1) * 1;
			break;
		case 1:
			this.fuerza = 20 + (nivel - 1) * 6; // 50%
			this.salud = 40 + (nivel - 1) * 20;
			this.defensa = 5 + (nivel - 1) * 2;
			break;
		case 2:
			this.fuerza = 30 + (nivel - 1) * 10; // 50%
			this.salud = 50 + (nivel - 1) * 25;
			this.defensa = 4 + (nivel - 1) * 4;
			break;
		default:
	    break;
		}
	}

	public int otorgarExp() {
		return this.nivel * 30;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(final int fuerza) {
		this.fuerza = fuerza;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(final int nivel) {
		this.nivel = nivel;
	}

	public boolean estaVivo() {
		return salud > 0;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(final int defensa) {
		this.defensa = defensa;
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(final int salud) {
		this.salud = salud;
	}
	/**
	 * <h3><u>Método atacar</u></h3>
	 * Método encargado de realizar un ataque por parte de un personaje no manejado por un jugador.<p>
	 * Pseudo-aleatoriamente puede ser un 50% más fuerte, en caso de que el numero aleatorio sea menor
	 * a la probalidad que tiene los NPC de lograr un golpe crítico.
	 * @param atacado Es el Peleable a atacar por parte del NPC.
	 * @return Un int que representa el daño causado, (si no se logra el ataque el retorno es 0)
	 */
	public int atacar(final Peleable atacado) {
		if (MyRandom.nextDouble() <= 0.15) { // los NPC tienen 15% de golpes criticos
			return atacado.serAtacado((int) (this.getAtaque() * 1.5));
		} else {
			return atacado.serAtacado(this.getAtaque());
		}
	}
/**
 * <h3><u>Método serAtacado</u></h3>
 * Método encargado de recepcionar un ataque por parte de un personaje no manejado por un jugador.<p>
 * Si la defensa es mayor o se esquiva el golpe el NPC no recibe daño alguno.
 * @param danio Es el daño a recibir por parte del NPC.
 * @return Un int que representa el daño causado, (si no se logra el ataque el retorno es 0)
 */
	public int serAtacado(int danio) {
		if (MyRandom.nextDouble() >= 0.15) {
			danio -= this.getDefensa() / 2;
			if (danio > 0) {
				salud -= danio;
				return danio;
			}
			return 0; // no le hace daño ya que la defensa fue mayor
		}
		return 0; // esquivo el golpe
	}

	public void despuesDeTurno() { }

	public void ganarExperiencia(final int exp) {

	}

	@Override
	public int getAtaque() {
		return fuerza;
	}

	@Override
	public void setAtaque(final int ataque) {
		this.fuerza = ataque;
	}
}
