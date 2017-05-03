package dominio;

import java.io.Serializable;
/**
 *
 * <p>Clase abstracta encargada de definir los métodos y atributos de un Personaje.<br>
 * Implementa las interfaces Peleable y Serializable</p>
 *
 */
public abstract class Personaje implements Peleable, Serializable {

	protected int salud;
	protected int energia;
	protected int defensa; // depende de la destreza
	protected int ataque; // depende de la fuerza
	protected int magia; // depende de la inteligencia

	protected String nombre; // hay que agregarlo a todos los constructores
	protected String nombreRaza;

	protected int saludTope;
	protected int energiaTope;

	protected int fuerza;
	protected int destreza;
	protected int inteligencia;
	protected Casta casta;

	protected int x;
	protected int y;

	protected int experiencia;
	protected int nivel;

	protected int idPersonaje;

	protected Alianza clan = null;
	public static int tablaDeNiveles[];

	protected String[] habilidadesRaza;

	public String[] getHabilidadesRaza() {
		return habilidadesRaza;
	}

	public String[] getHabilidadesCasta() {
		return casta.getHabilidadesCasta();
	}

	public static void cargarTablaNivel() {
		Personaje.tablaDeNiveles = new int[101];
		Personaje.tablaDeNiveles[0] = 0;
		Personaje.tablaDeNiveles[1] = 0;
		for (int i = 2; i < 101; i++) {
			Personaje.tablaDeNiveles[i] = Personaje.tablaDeNiveles[i - 1] + 50;
		}
	}

	public Personaje(final String nombre, final Casta casta, final int id) {
		this.nombre = nombre;
		this.casta = casta;
		this.idPersonaje = id;
		experiencia = 0;
		nivel = 1;
		fuerza = 10;
		inteligencia = 10;
		destreza = 10;
		if (casta instanceof Guerrero) {
		  fuerza += 5;
		}
		if (casta instanceof Hechicero) {
			inteligencia += 5;
		}
		if (casta instanceof Asesino) {
			destreza += 5;
		}

		x = 0;
		y = 0;
		saludTope = 100;
		energiaTope = 100;

		ataque = this.calcularPuntosDeAtaque();
		defensa = this.calcularPuntosDeDefensa();
		magia = this.calcularPuntosDeMagia();

	}

	public Personaje(final String nombre, final int salud, final int energia,
	    final int fuerza, final int destreza, final int inteligencia,
	    final Casta casta, final int experiencia, final int nivel,
	    final int idPersonaje) {

		this.nombre = nombre;
		this.salud = salud;
		this.energia = energia;
		this.fuerza = fuerza;
		this.destreza = destreza;
		this.inteligencia = inteligencia;
		this.casta = casta;

		this.experiencia = experiencia;
		this.nivel = nivel;

		this.saludTope = this.salud;
		this.energiaTope = this.energia;

		this.idPersonaje = idPersonaje;
		this.defensa = this.calcularPuntosDeDefensa();
		this.ataque = this.calcularPuntosDeAtaque();
		this.magia = this.calcularPuntosDeMagia();
	}

	public String getNombreRaza() {
		return nombreRaza;
	}

	public void setNombreRaza(final String nombreRaza) {
		this.nombreRaza = nombreRaza;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(final int ataque) {
		this.ataque = ataque;
	}

	public int getMagia() {
		return magia;
	}

	public void setMagia(final int magia) {
		this.magia = magia;
	}

	public Alianza getClan() {
		return clan;
	}

	public void setClan(final Alianza clan) {
		this.clan = clan;
		clan.anadirPersonaje(this);
	}

	public int getSalud() {
		return salud;
	}

	public void setSalud(final int salud) {
		this.salud = salud;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(final int energia) {
		this.energia = energia;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(final int fuerza) {
		this.fuerza = fuerza;
	}

	public int getDestreza() {
		return destreza;
	}

	public void setDestreza(final int destreza) {
		this.destreza = destreza;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(final int inteligencia) {
		this.inteligencia = inteligencia;
	}

	public Casta getCasta() {
		return casta;
	}

	public void setCasta(final Casta casta) {
		this.casta = casta;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(final int experiencia) {
		this.experiencia = experiencia;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(final int nivel) {
		this.nivel = nivel;
	}

	public int getIdPersonaje() {
		return idPersonaje;
	}

	public void setIdPersonaje(final int idPersonaje) {
		this.idPersonaje = idPersonaje;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(final int defensa) {
		this.defensa = defensa;
	}

	public int getSaludTope() {
		return saludTope;
	}

	public void setSaludTope(final int saludTope) {
		this.saludTope = saludTope;
	}

	public int getEnergiaTope() {
		return energiaTope;
	}

	public void setEnergiaTope(final int energiaTope) {
		this.energiaTope = energiaTope;
	}
/**
 * <h3><u>Método Atacar</u></p>
 * <p>Este método recibirá un objeto del tipo Peleable al cual, el objeto llamador (un Personaje) intentará atacar.<br>
 * En caso de no poder concretar dicho ataque se retornará un int de valor 0. Si es posible el ataque, se procederá
 * y se retornará un int distinto de cero.</p>
 * @param atacado Es un Objeto del tipo Peleable al cual se intenta atacar.
 * @return En caso de No poder concretar el ataque devuelve un cero, caso contrario
 * devuelve un entero distinto de cero.
 */
	public int atacar(final Peleable atacado) {
		if (salud == 0) {
			return 0;
		}
		if (atacado.getSalud() > 0) {
			if (MyRandom.nextDouble() <= this.casta.getProbabilidadGolpeCritico() + this.destreza / 1000) {
				return atacado.serAtacado(this.golpeCritico());
			} else {
				return atacado.serAtacado(this.ataque);
			}
		}
		return 0;
	}

	public int golpeCritico() {
		return (int) (this.ataque * this.getCasta().getDanioCritico());
	}

	public void despuesDeTurno() {

	}

	public boolean puedeAtacar() {
		return energia > 10;
	}

	public int calcularPuntosDeAtaque() {
		return (int) (this.getFuerza() * 1.5);
	}

	public int calcularPuntosDeDefensa() {
		return (int) (this.getDestreza());
	}

	public int calcularPuntosDeMagia() {
		return (int) (this.getInteligencia() * 1.5);
	}

	public void restablecerSalud() {
		this.salud = this.saludTope;
	}

	public void restablecerEnergia() {
		this.energia = this.energiaTope;
	}

	public void modificarAtributos() {
		this.ataque = this.calcularPuntosDeAtaque();
		this.defensa = this.calcularPuntosDeDefensa();
		this.magia = this.calcularPuntosDeMagia();
	}

	public boolean estaVivo() {
		return salud > 0;
	}
/**
 * <h3><u>Método serAtacado </u><h3>
 * <p>Este método será el encargado de proceder a dañar al objeto llamador.<br>
 * Recibirá el daño que se pretende recibir para luego de distintas evaluaciones concretar el ataque recibido.</p>
 * <p>En caso que se pueda evitar el ataque recibido ya sea por defensa oprobabilidad
 * de evitarlo, el método devolverá un cero.
 * Caso contrario se procede a recibir el ataque y luego retornar el daño final.</p>
 * @param danio Es el daño que se pretende recibir (int).
 * @return Se devuelve un int representando el daño recibido (si NO hubo daño sera cero).
 */
	public int serAtacado(final int danio) {
	  int auxDanio = danio;
		if (MyRandom.nextDouble() >= this.getCasta().getProbabilidadEvitarDanio()) {
		  auxDanio -= this.defensa;
			if (auxDanio > 0) {
				if (salud <= auxDanio) {
					auxDanio = salud;
					salud = 0;
				} else {
					salud -= auxDanio;
				}
				return auxDanio;
			}
			return 0;
		}
		return 0;
	}

	public int serRobadoSalud(final int danio) {
	  int auxDanio = danio;
	  auxDanio -= this.defensa;
		if (auxDanio <= 0) {
			return 0;
		}
		if ((salud - auxDanio) >= 0) {
			salud -= auxDanio;
		} else {
		  auxDanio = salud; // le queda menos salud que el daño inflingido
			salud = 0;
		}
		return auxDanio;
	}

	public int serDesernegizado(final int danio) {
	  int auxDanio = danio;
	  auxDanio -= this.defensa;
		if (auxDanio <= 0) {
			return 0;
		}
		if ((this.energia - auxDanio) >= 0) {
			this.energia -= auxDanio;
		} else {
		  auxDanio = energia; // le queda menos energia que el daño inflingido
			this.energia = 0;
		}
		return auxDanio;
	}

	public void serCurado(final int salud) {
		if ((this.salud + salud) <= this.saludTope) {
			this.salud += salud;
		} else {
			this.salud = this.saludTope;
		}
	}

	public void serEnergizado(final int energia) {
		if ((this.energia + energia) <= this.energiaTope) {
			this.energia += energia;
		} else {
			this.energia = this.energiaTope;
		}
	}

	public void crearAlianza(final String nombreAlianza) {
		this.clan = new Alianza(nombreAlianza);
		this.clan.anadirPersonaje(this);
	}

	public void salirDeAlianza() {
		if (this.clan != null) {
			this.clan.eliminarPersonaje(this);
			this.clan = null;
		}
	}

	public boolean aliar(Personaje nuevoAliado) {
		if (this.clan == null) {
			Alianza a = new Alianza("Alianza 1");
			this.clan = a;
			a.anadirPersonaje(this);
		}

		if (nuevoAliado.clan == null) {
			nuevoAliado.clan = this.clan;
			this.clan.anadirPersonaje(nuevoAliado);
			return true;
		} else {
			return false;
		}
	}

	public void AsignarPuntosSkills(final int fuerza, final int destreza, final int inteligencia) {
		if (this.fuerza + fuerza <= 200) {
			this.fuerza += fuerza;
		}
		if (this.destreza + destreza <= 200) {
			this.destreza += destreza;
		}
		if (this.inteligencia + inteligencia <= 200) {
			this.inteligencia += inteligencia;
		}
		this.modificarAtributos();
	}

	public void subirNivel() {

		int acumuladorExperiencia = 0;
		if (this.nivel == 100) {
			return;
		}
		while (this.nivel != 100
				&& (this.experiencia >= Personaje.tablaDeNiveles[this.nivel + 1] + acumuladorExperiencia)) {
			acumuladorExperiencia += Personaje.tablaDeNiveles[this.nivel + 1];
			this.nivel++;
			this.modificarAtributos();
			this.saludTope += 25;
			this.energiaTope += 20;
		}
		this.experiencia -= acumuladorExperiencia;
	}

	public boolean ganarExperiencia(final int exp) {
		this.experiencia += exp;

		if (experiencia >= Personaje.tablaDeNiveles[this.nivel + 1]) {
			subirNivel();
			return true;
		}
		return false;
	}

	public int otorgarExp() {
		return this.nivel * 40;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public double distanciaCon(final Personaje p) {
		return Math.sqrt(Math.pow(this.x - p.x, 2) + Math.pow(this.y - p.y, 2));
	}

	public boolean habilidadCasta1(final Peleable atacado) {
		return this.getCasta().habilidad1(this, atacado);
	}

	public boolean habilidadCasta2(final Peleable atacado) {
		return this.getCasta().habilidad2(this, atacado);
	}

	public boolean habilidadCasta3(final Peleable atacado) {
		return this.getCasta().habilidad3(this, atacado);
	}

	public abstract boolean habilidadRaza1(Peleable atacado);

	public abstract boolean habilidadRaza2(Peleable atacado);
}
