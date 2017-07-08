package dominio;

import java.util.HashMap;
import java.util.Map;

public class Item {
	private int id;
	private String nombre;
	private int idTipoItem;
	private int fuerzaRequerida;
	private int destrezaRequerida;
	private int inteligenciaRequerida;
	private Map<Integer, ModificadorItem> modificadores;
	private String foto;

	public Item() {
	}

	public Item(final int id, final String nombre, final int idTipoItem, final int fuerzaRequerida,
			final int destrezaRequerida, final int inteligenciaRequerida, final String foto) {
		this.id = id;
		this.nombre = nombre;
		this.idTipoItem = idTipoItem;
		this.fuerzaRequerida = fuerzaRequerida;
		this.destrezaRequerida = destrezaRequerida;
		this.inteligenciaRequerida = inteligenciaRequerida;
		this.foto = foto;
		this.modificadores = new HashMap<Integer, ModificadorItem>();
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public int getIdTipoItem() {
		return idTipoItem;
	}

	public int getFuerzaRequerida() {
		return fuerzaRequerida;
	}

	public int getDestrezaRequerida() {
		return destrezaRequerida;
	}

	public int getInteligenciaRequerida() {
		return inteligenciaRequerida;
	}

	public String getFoto() {
		return foto;
	}

	public String getDescripcionItem() {
		String descripcion = this.nombre + " (";
		for (ModificadorItem modificador : this.modificadores.values()) {
			descripcion += modificador.toString() + ", ";
		}
		return descripcion.substring(0, descripcion.length() - 2) + ")";
	}

	public void addModificador(final ModificadorItem modificador) {
		this.modificadores.put(modificador.getAtributoModificable(), modificador);
	}

	public int incrementar(final int valor, final int atributo) {
		ModificadorItem aux = this.modificadores.get(atributo);
		if (aux != null) {
			return aux.incrementar(valor);
		}
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Item other = (Item) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}
}
