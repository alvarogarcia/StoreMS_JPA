package uo.ri.amp.business.impl;

import java.util.List;

import alb.util.BusinessException;

import uo.ri.amp.business.ProviderService;
import uo.ri.amp.business.impl.admin.AddProvider;
import uo.ri.amp.business.impl.admin.AddReplacementToProvider;
import uo.ri.amp.business.impl.admin.CheckWhatProviderToUpdate;
import uo.ri.amp.business.impl.admin.CheckWhatReplacementToUpdateOrDelete;
import uo.ri.amp.business.impl.admin.DeleteProvider;
import uo.ri.amp.business.impl.admin.DeleteReplacementFromProvider;
import uo.ri.amp.business.impl.admin.FindProviderByCode;
import uo.ri.amp.business.impl.admin.FindReplacementByCode;
import uo.ri.amp.business.impl.admin.UpdateProvider;
import uo.ri.amp.business.impl.admin.UpdateReplacementFromProvider;
import uo.ri.amp.business.impl.CommandExecutor;
import uo.ri.model.Proveedor;
import uo.ri.model.Repuesto;
import uo.ri.model.RepuestosProveedor;

/**
 * @author Álvaro García
 * 
 */
public class ProviderServiceImpl implements ProviderService {

	CommandExecutor cE = new CommandExecutor();

	@Override
	public void addProvider(String providerName) throws BusinessException {
		cE.execute(new AddProvider(providerName));

	}

	@Override
	public void deleteProvider(Long providerCode) throws BusinessException {
		cE.execute(new DeleteProvider(providerCode));

	}

	@Override
	public void updateProvider(Long providerCode, String providerName)
			throws BusinessException {
		cE.execute(new UpdateProvider(providerCode, providerName));
	}

	@Override
	public void addReplacementToProvider(Long replacementCode,
			Long providerCode, Double price) throws BusinessException {
		cE.execute(new AddReplacementToProvider(replacementCode, providerCode,
				price));

	}

	@Override
	public void deleteReplacementFromProvider(Long replacementCode,
			Long providerCode) throws BusinessException {
		cE.execute(new DeleteReplacementFromProvider(replacementCode,
				providerCode));

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RepuestosProveedor> checkWhatReplacementToUpdateOrDelete(
			Long replacementCode, Long providerCode, boolean isReplacementCode)
			throws BusinessException {
		return (List<RepuestosProveedor>) cE
				.execute(new CheckWhatReplacementToUpdateOrDelete(
						replacementCode, providerCode, isReplacementCode));
	}

	@Override
	public void updateReplacementFromProvider(Long replacementCode,
			Long providerCode, Double newPrice) throws BusinessException {
		cE.execute(new UpdateReplacementFromProvider(replacementCode,
				providerCode, newPrice));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proveedor> checkWhatProviderToUpdate(
			String nameProviderBeforeUpdating) throws BusinessException {
		return (List<Proveedor>) cE.execute(new CheckWhatProviderToUpdate(
				nameProviderBeforeUpdating));
	}

	@Override
	public Repuesto findReplacementByCode(Long idReplacement)
			throws BusinessException {
		return (Repuesto) cE.execute(new FindReplacementByCode(idReplacement));
	}

	@Override
	public Proveedor findProviderByCode(Long providerCode)
			throws BusinessException {
		return (Proveedor) cE.execute(new FindProviderByCode(providerCode));
	}

}
