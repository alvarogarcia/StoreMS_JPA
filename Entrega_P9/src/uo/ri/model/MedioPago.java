package uo.ri.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING)
@Table(name="TMEDIOSPAGO")
public abstract class MedioPago  { //implements Serializable
	
	@Id
	@GeneratedValue
	private Long id;
	
	private Double acumulado = 0.0;
	@ManyToOne
	private Cliente cliente;
	@OneToMany(mappedBy = "medioPago")
	private Set<Cargo> cargos = new HashSet<Cargo>();
	
	public Set<Cargo> getCargos(){
		return Collections.unmodifiableSet(cargos);
	}

	public void addCargo(Cargo cargo){
		cargo._setMedioPago(this);
		cargos.add(cargo);
		
	}
	
	public void removeCargo(Cargo cargo){
		cargo._setMedioPago(null);
		cargos.remove(cargo);
		
	}

	public Cliente getCliente(){
		return cliente;
	}

	public  double getAcumulado() {
		return acumulado;
	}

	public  void setAcumulado(double acumulado) {
		this.acumulado = acumulado;
	}

	@Override
	public String toString() {
		return "MedioPago [acumulado=" + acumulado + "]";
	}
	
	void _setCliente(Cliente cliente){
		this.cliente = cliente;
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
		MedioPago other = (MedioPago) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	

}
