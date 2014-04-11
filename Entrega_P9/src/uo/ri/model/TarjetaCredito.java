package uo.ri.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("TTarjetasCredito")
public class TarjetaCredito extends MedioPago implements Serializable {
	
	private String tipo;
	@Temporal(TemporalType.DATE)
	private Date validez;
	private String numero;
	
	public TarjetaCredito(){}
	
	

	public TarjetaCredito(String tipo, Date validez, String numero) {
		super();
		this.tipo = tipo;
		this.validez = validez;
		this.numero = numero;
	}


	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Date getValidez() {
		return validez;
	}

	public void setValidez(Date validez) {
		this.validez = validez;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}



	@Override
	public String toString() {
		return "TarjetaCredito [tipo=" + tipo + ", validez=" + validez
				+ ", numero=" + numero + ", acumulado=" + super.getAcumulado() + "]";
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TarjetaCredito other = (TarjetaCredito) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}



	
	

}
