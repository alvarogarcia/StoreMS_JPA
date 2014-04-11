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
@Table(name="TTIPOSVEHICULO")
public class TipoVehiculo implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;

	private String nombre;
	private Double precioHora = 0.0;
	
	@OneToMany(mappedBy = "tipo")
	private Set<Vehiculo> vehiculos = new HashSet<Vehiculo>();
	
	public TipoVehiculo() {}
	
	

	public TipoVehiculo(String nombre, double precioHora) {
		this.nombre = nombre;
		this.precioHora = precioHora;
	}
	
	public Set<Vehiculo> getVehiculos(){
		return Collections.unmodifiableSet(vehiculos);
	}

	public void addVehiculo(Vehiculo v){
		v._setTipoVehiculo(this);
		vehiculos.add(v);
		
	}
	
	public void removeVehiculo(Vehiculo v){
		vehiculos.remove(v);
		v._setTipoVehiculo(null);
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecioHora() {
		return precioHora;
	}

	public void setPrecioHora(double precioHora) {
		this.precioHora = precioHora;
	}



	@Override
	public String toString() {
		return "TipoVehiculo [nombre=" + nombre + ", precioHora=" + precioHora
				+ "]";
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
		TipoVehiculo other = (TipoVehiculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	
	
	
	

}
