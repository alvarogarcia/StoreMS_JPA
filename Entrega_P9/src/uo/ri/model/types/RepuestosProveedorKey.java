package uo.ri.model.types;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RepuestosProveedorKey implements Serializable {

	Long repuesto;
	Long proveedor;
	
	public RepuestosProveedorKey(Long repuesto, Long proveedor){
		this.repuesto = repuesto;
		this.proveedor = proveedor;
	}
	
	public RepuestosProveedorKey(){}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((proveedor == null) ? 0 : proveedor.hashCode());
		result = prime * result
				+ ((repuesto == null) ? 0 : repuesto.hashCode());
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
		RepuestosProveedorKey other = (RepuestosProveedorKey) obj;
		if (proveedor == null) {
			if (other.proveedor != null)
				return false;
		} else if (!proveedor.equals(other.proveedor))
			return false;
		if (repuesto == null) {
			if (other.repuesto != null)
				return false;
		} else if (!repuesto.equals(other.repuesto))
			return false;
		return true;
	}
	
	
}
