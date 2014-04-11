package uo.ri.model;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;


import uo.ri.model.types.AveriaStatus;
import uo.ri.model.types.FacturaStatus;

import alb.util.BusinessException;
import alb.util.date.DateUtil;


@SuppressWarnings("serial")
@Entity
@Table(name="TFACTURAS", uniqueConstraints=@UniqueConstraint(columnNames="NUMERO"))
public class Factura implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private Long numero = 0L;
	@Temporal(TemporalType.DATE)
	private Date fecha;
	@Column(name="iva")
	private Double ivaPercentage = 0.0;
	private Double importe = 0.0;
	@Enumerated(EnumType.STRING)
	private FacturaStatus status;
	
	@OneToMany(mappedBy = "factura")
	private Set<Cargo> cargos = new HashSet<Cargo>();
	@OneToMany(mappedBy = "factura")
	private Set<Averia> averias = new HashSet<Averia>();
	
	public Factura(){}
	
	public Factura(List<Averia> averias) throws BusinessException{
		comprobarAveriasTerminadas(averias);
		this.averias = new HashSet<Averia>(averias);
		setFecha(new Date());
		setStatus(FacturaStatus.SIN_ABONAR);
		
		pasarAveriasAFacturadas();
	}
	
	

	public Factura(Long numero, Date fecha, double ivaPercentage,
			double importe, FacturaStatus status) {

		super();
		
		this.numero = numero;
		this.fecha = fecha;
		this.ivaPercentage = ivaPercentage;
		this.importe = importe;
		this.status = status;
		pasarAveriasAFacturadas();
	}
	
	public Factura(Date fecha, List<Averia> averias) throws BusinessException{
		comprobarAveriasTerminadas(averias);

		setFecha(fecha);
		this.averias = new HashSet<Averia>(averias);
		setStatus(FacturaStatus.SIN_ABONAR);
		pasarAveriasAFacturadas();
	}

	public void addCargo(MedioPago mP, double importe){
		cargos.add(new Cargo(this, mP, importe));
		
	}
	
	public Set<Averia> getAverias(){
		return Collections.unmodifiableSet(averias);
	}
	
	public Set<Cargo> getCargos(){
		return Collections.unmodifiableSet(cargos);
	}
	
	public void removeCargo(MedioPago mP, double importe){
		cargos.remove(new Cargo(this, mP, importe));
	}
	

	
	public void addAveria(Averia a){
		a._setFactura(this);
		averias.add(a);
		
	}
	
	public void removeAveria(Averia a){
		a._setFactura(null);
		averias.remove(a);
		
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
		// Según la fecha, establezco el IVA
		
		ivaPercentage = DateUtil.fromString("1/7/2012").before(fecha) ? 21.0
				: 18.0;
	}

	public double getIvaPercentage() {
		return ivaPercentage;
	}
	
	public double getIva(){
		return ivaPercentage;
	}

	public void setIvaPercentage(double ivaPercentage) {
		this.ivaPercentage = ivaPercentage;
	}
	
	public void pasarAveriasAFacturadas(){
		for(Averia averia : averias){
			averia.setStatus(AveriaStatus.FACTURADA);
		}
	}
	
	public void calcularImporte(){
		Double totalImporte = 0.0;
		for(Averia averia : averias){
			averia.calcularImporte();
			totalImporte += averia.getImporte();
		}
		

		totalImporte += (totalImporte * (ivaPercentage/100));
		
		importe = Math.rint(totalImporte*100)/100;
	}
	

	public double getImporte() {
		calcularImporte();
		return importe;
	}
	
	

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public FacturaStatus getStatus() {
		return status;
	}

	public void setStatus(FacturaStatus status) {
		this.status = status;
	}
	
	public void comprobarAveriasTerminadas(List<Averia> averias) throws BusinessException{
		for(Averia averia : averias){
			if(averia.getStatus() != AveriaStatus.TERMINADA)
				throw new BusinessException("Avería no terminada");
		}
	}




	@Override
	public String toString() {
		return "Factura [numero=" + numero + ", fecha=" + fecha
				+ ", ivaPercentage=" + ivaPercentage + ", importe=" + importe
				+ ", status=" + status + "]";
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
		Factura other = (Factura) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
