package uo.ri.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name="TMECANICOS")
public class Mecanico implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;

	private String nombre;
	private String apellidos;
	
	@OneToMany(mappedBy = "mecanico")
	private Set<Averia> averias = new HashSet<Averia>();
	@OneToMany(mappedBy = "mecanico")
	private Set<Intervencion> intervenciones = new HashSet<Intervencion>();
	
	public Mecanico(){}
	

	public Mecanico(String nombre, String apellidos) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
	}
	
	public Set<Intervencion> getIntervenciones(){
		return Collections.unmodifiableSet(intervenciones);
	}
	
	public void addIntervencion(Intervencion i){
		i._setMecanico(this);
		intervenciones.add(i);
		
	}
	
	public void removeIntervencion(Intervencion i){
		i._setMecanico(null);
		intervenciones.remove(i);
		
	}
	
	public void addAveria(Averia a){
		a._setMecanico(this);
		averias.add(a);
		
	}
	
	public void removeAveria(Averia a){
		a._setMecanico(null);
		averias.remove(a);
		
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}



	@Override
	public String toString() {
		return "Mecanico [nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}


	


	public Long getId() {
		return id;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mecanico other = (Mecanico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
	

}
