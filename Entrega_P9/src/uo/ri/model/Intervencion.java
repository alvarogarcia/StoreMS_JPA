package uo.ri.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import uo.ri.model.types.IntervencionKey;



@SuppressWarnings("serial")
@Entity
@IdClass(IntervencionKey.class)
@Table(name="TINTERVENCIONES")
public class Intervencion implements Serializable {

	private Integer minutos = 0;
	
	@Id @ManyToOne
	private Averia averia;
	@Id @ManyToOne
	private Mecanico mecanico;
	
	@OneToMany(mappedBy = "intervencion")
	private Set<Sustitucion> sustituciones = new HashSet<Sustitucion>();
	
	public Intervencion(){}
	
	

	public Intervencion(int minutos) {
		super();
		this.minutos = minutos;
	}
	
	public void addSustitucion(Sustitucion sustitucion){
		sustituciones.add(sustitucion);
	}
	
	public void addSustitucion(Repuesto r){
		sustituciones.add(new Sustitucion(r, this));
	}
	
	public Set<Sustitucion> getSustituciones(){
		return Collections.unmodifiableSet(sustituciones);
	}

	public Mecanico getMecanico(){
		return mecanico;
	}
	
	public Averia getAveria(){
		return averia;
	}
	
	void _setAveria(Averia averia){
		this.averia = averia;
	}

	void _setMecanico(Mecanico mecanico){
		this.mecanico = mecanico;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}
	
	public double getImporte(){
		Double importeSustituciones = 0.0;
		for(Sustitucion s : sustituciones)
			importeSustituciones += s.getImporte();
		Double importeManoObra = (minutos*1.0/60.0)*(averia.getVehiculo().getTipoVehiculo().getPrecioHora());
		return Math.rint((importeSustituciones + importeManoObra)*100)/100;
	}

	


	@Override
	public String toString() {
		return "Intervencion [minutos=" + minutos + "]";
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((averia == null) ? 0 : averia.hashCode());
		result = prime * result
				+ ((mecanico == null) ? 0 : mecanico.hashCode());
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
		Intervencion other = (Intervencion) obj;
		if (averia == null) {
			if (other.averia != null)
				return false;
		} else if (!averia.equals(other.averia))
			return false;
		if (mecanico == null) {
			if (other.mecanico != null)
				return false;
		} else if (!mecanico.equals(other.mecanico))
			return false;
		return true;
	}



	

	

}
