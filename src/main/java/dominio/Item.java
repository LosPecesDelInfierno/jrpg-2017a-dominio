package dominio;

import java.util.Collections;
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

	public Item() { }
	
	public Item(int id, String nombre, int idTipoItem, int fuerzaRequerida, int destrezaRequerida,
			int inteligenciaRequerida, String foto) {
		this.id = id;
		this.nombre = nombre;
		this.idTipoItem = idTipoItem;
		this.fuerzaRequerida = fuerzaRequerida;
		this.destrezaRequerida = destrezaRequerida;
		this.inteligenciaRequerida = inteligenciaRequerida;
		this.foto = foto;
		this.modificadores = new HashMap<Integer,ModificadorItem>();
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
    String descripcion = "Fuerza " + getFuerzaRequerida() + 
        ", Destreza " + getDestrezaRequerida() + 
        ", Inteligencia " + getInteligenciaRequerida();
    
    return descripcion;
  }
	
	public void addModificador(ModificadorItem modificador) {
		this.modificadores.put(modificador.getAtributoModificable(), modificador);
	}
	
	public int incrementar(int valor, int atributo ) {
		ModificadorItem aux = this.modificadores.get(atributo);
		
		if( aux != null ){
			return aux.incrementar(valor);
		}
		return valor;
	}
	
	public int decrementar(int valor, int atributo) {
		ModificadorItem aux = this.modificadores.get(atributo);
		
		if( aux != null ){
			return aux.decrementar(valor);
		}
		return valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
