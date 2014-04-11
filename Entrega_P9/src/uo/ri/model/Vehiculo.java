package uo.ri.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="TVEHICULOS")
public class Vehiculo implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;

	private String matricula;
	private String modelo;
	private String marca;

	@ManyToOne
	private Cliente cliente;
	@ManyToOne
	private TipoVehiculo tipo;
	@OneToMany(mappedBy = "vehiculo")
	private Set<Averia> averias = new HashSet<Averia>();
	private Integer num_averias = 0;
	
	public Vehiculo() {}
	
	
	
	public Vehiculo(String matricula, String modelo, String marca) {
		super();
		this.matricula = matricula;
		this.modelo = modelo;
		this.marca = marca;
	}
	
	public Cliente getCliente(){
		return cliente;
	}

	public Long getId(){
		return id;
	}
	
	public Set<Averia> getAverias(){
		return Collections.unmodifiableSet(averias);
	}
	
	
	public TipoVehiculo getTipo(){
		return tipo;
	}
	
	void _setTipoVehiculo(TipoVehiculo tV){
		this.tipo = tV;
	}


	void _setCliente(Cliente cliente){
		this.cliente = cliente;
	}
	
	public void addAveria(Averia a){
		a._setVehiculo(this);
		averias.add(a);
		num_averias++;
	}
	
	public void removeAveria(Averia a){
		a._setVehiculo(null);
		averias.remove(a);
		num_averias--;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public TipoVehiculo getTipoVehiculo(){
		return tipo;
		
	}

	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", marca=" + marca
				+ ", modelo=" + modelo + "]";
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
		Vehiculo other = (Vehiculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	

}
