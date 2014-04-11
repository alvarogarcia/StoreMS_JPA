package uo.ri.amp.business;

import java.util.List;

import alb.util.BusinessException;

import uo.ri.model.Proveedor;
import uo.ri.model.Repuesto;
import uo.ri.model.RepuestosProveedor;

/**
 * @author Álvaro García
 * 
 */
public interface ProviderService {

	/**
	 * Añade un proveedor a la base de datos
	 * 
	 * @param providerName
	 *            Nombre del proveedor a añadir
	 * @throws BusinessException
	 */
	public void addProvider(String providerName) throws BusinessException;

	/**
	 * Borra un proveedor de la base de datos
	 * 
	 * @param providerCode
	 *            Código del proveedor a eliminar.
	 */
	public void deleteProvider(Long providerCode) throws BusinessException;

	/**
	 * Actualiza un proveedor
	 * 
	 * @param providerCode
	 *            Código del proveedor a actualizar
	 * @param providerName
	 *            Nombre nuevo del proveedor
	 */
	public void updateProvider(Long providerCode, String providerName)
			throws BusinessException;

	/**
	 * Añade un repuesto a un proveedor
	 * 
	 * @param replacementCode
	 *            Código del repuesto
	 * @param providerCode
	 *            Código del proveedor
	 * @param price
	 *            Precio para el repuesto por parte de ese proveedor
	 */
	public void addReplacementToProvider(Long replacementCode,
			Long providerCode, Double price) throws BusinessException;

	/**
	 * Elimina un repuesto de un proveedor
	 * 
	 * @param replacementCode
	 *            Código del repuesto a eliminar
	 * @param providerCode
	 *            Código del proveedor del que se va a eliminar el repuesto
	 */
	public void deleteReplacementFromProvider(Long replacementCode,
			Long providerCode) throws BusinessException;

	/**
	 * 
	 * @param replacementCode
	 *            Código del repuesto
	 * @param providerCode
	 *            Código del proveedor
	 * @param isReplacementCode
	 *            Si vale true se comprueba por código de repuesto. En caso
	 *            contrario, por código de proveedor
	 * @return Devuelve una lista con los repuestos de cada proveedor filtrados
	 *         por código de repuesto O por código de proveedor
	 */
	public List<RepuestosProveedor> checkWhatReplacementToUpdateOrDelete(
			Long replacementCode, Long providerCode, boolean isReplacementCode)
			throws BusinessException;

	/**
	 * @param nameProviderBeforeUpdating
	 *            Nombre del proveedor por el que se va a filtrar
	 * @return Lista que contiene los datos de cada uno de los
	 *         proveedores cuyo nombre es el pasado por parámetro
	 */
	public List<Proveedor> checkWhatProviderToUpdate(
			String nameProviderBeforeUpdating) throws BusinessException;

	/**
	 * Actualiza el repuesto de un proveedor. El único item que se puede
	 * modificar es el precio.
	 * 
	 * @param replacementCode
	 *            Código del repuesto
	 * @param providerCode
	 *            Código del proveedor
	 * @param newPrice
	 *            Nuevo precio
	 * @throws BusinessException
	 */
	public void updateReplacementFromProvider(Long replacementCode,
			Long providerCode, Double newPrice) throws BusinessException;

	/**
	 * Encuentra y devuelve un objeto de tipo Repuesto buscando por su id
	 * 
	 * @param idReplacement
	 *            id del repuesto a buscar
	 * @return
	 * @throws BusinessException
	 */
	public Repuesto findReplacementByCode(Long idReplacement)
			throws BusinessException;

	/**
	 * Encuentra y devuelve un proveedor buscando por código
	 * 
	 * @param providerCode
	 *            Código del proveedor
	 * @return
	 * @throws BusinessException
	 */
	public Proveedor findProviderByCode(Long providerCode)
			throws BusinessException;
}
