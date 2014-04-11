package uo.ri.business.impl.cash;

import java.util.List;

import uo.ri.business.impl.Command;
import uo.ri.model.Averia;
import uo.ri.model.Factura;
import uo.ri.persistence.AveriaFinder;
import uo.ri.persistence.util.Jpa;

import alb.util.BusinessException;



public class CreateInvoiceFor implements Command{

	private List<Long> idsAveria;

	public CreateInvoiceFor(List<Long> idsAveria) {
		this.idsAveria = idsAveria;
	}

	public Factura execute() throws BusinessException {
		List<Averia> averias = AveriaFinder.findByIds(idsAveria);
		Factura factura = new Factura(averias);
		Jpa.getManager().persist(factura);
		
		return factura;
	}

}
