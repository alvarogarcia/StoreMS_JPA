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
@Table(name="TCLIENTES")
public class Cliente implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre;
	private String apellidos;
	private String dni;
	@OneToMany(mappedBy = "cliente")
	private Set<Vehiculo> vehiculos = new HashSet<Vehiculo>();
	@OneToMany(mappedBy = "cliente")
	private Set<MedioPago> mediosPago = new HashSet<MedioPago>();
	
	public Cliente(){}
	
	
	
	public Cliente(String nombre, String apellidos, String dni) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
	}

	
	public Long getId(){
		return id;
	}
	
	public Set<MedioPago> getMediosPago(){
		return Collections.unmodifiableSet(mediosPago);
	}
	
	public Set<Vehiculo> getVehiculos(){
		return Collections.unmodifiableSet(vehiculos);
	}


	// MÉTODOS DE MANTENIMIENTO
	public void addVehiculo(Vehiculo v){
		v._setCliente(this);
		vehiculos.add(v);
		
	} 
	
	public void removeVehiculo(Vehiculo v){
		v._setCliente(null);
		vehiculos.remove(v);
		
	}
	
	
	public void addMedioPago(MedioPago mP){
		mediosPago.add(mP);
		mP._setCliente(this);
	}
	
	public void removeMedioPago(MedioPago mP){
		mediosPago.remove(mP);
		mP._setCliente(null);
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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
		return "Cliente [nombre=" + nombre + ", apellidos=" + apellidos
				+ ", dni=" + dni + "]";
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	

	
}
