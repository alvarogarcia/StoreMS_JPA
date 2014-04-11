package uo.ri.model;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sun.istack.internal.NotNull;

import alb.util.date.DateUtil;

import uo.ri.model.types.AveriaStatus;



@SuppressWarnings("serial")
@Entity
@Table(name="TAVERIAS")
public class Averia implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	private String descripcion;
	@Temporal(TemporalType.DATE)
	private Date fecha = DateUtil.today();
	private Double importe = 0.0;
	@Enumerated(EnumType.STRING)
	private AveriaStatus status;
	
	@ManyToOne
	private Vehiculo vehiculo;
	@ManyToOne
	private Factura factura;
	@ManyToOne
	private Mecanico mecanico;
	@OneToMany(mappedBy = "averia")
	private Set<Intervencion> intervenciones = new HashSet<Intervencion>();

	public Averia() {
	}

	public Averia(String descripcion, Date fecha, double importe,
			AveriaStatus status) {
		super();
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.importe = importe;
		this.status = status;
	}
	
	public Averia(String descripcion){
		super();
		this.descripcion = descripcion;
	}
	
	public Factura getFactura(){
		return factura;
	}
	
	public Set<Intervencion> getIntervenciones(){
		return Collections.unmodifiableSet(intervenciones);
	}
	
	void _setVehiculo(Vehiculo vehiculo){
		this.vehiculo = vehiculo;
	}
	
	void _setFactura(Factura f){
		this.factura = f;
	}
	
	
	
	void _setMecanico(Mecanico m){
		this.mecanico = m;
		m.addAveria(this);
	}
	
	
	
	public void addIntervencion(Intervencion i){
		intervenciones.add(i);
		i._setAveria(this);
	}
	
	public void removeIntervencion(Intervencion i){
		intervenciones.remove(i);
		i._setAveria(null);
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getImporte() {
		return importe;
	}
	
	

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public AveriaStatus getStatus() {
		return status;
	}

	public void setStatus(AveriaStatus status) {
		this.status = status;
	}
	

	public Vehiculo getVehiculo(){
		return vehiculo;
	}
	
	public void calcularImporte(){
		Double totalIntervenciones = 0.0;
		for(Intervencion intervencion : intervenciones)
			totalIntervenciones += intervencion.getImporte();
		importe = totalIntervenciones;
	}

	
	@Override
	public String toString() {
		return "Averia [descripcion=" + descripcion + ", fecha=" + fecha
				+ ", importe=" + importe + ", status=" + status + "]";
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
		Averia other = (Averia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
