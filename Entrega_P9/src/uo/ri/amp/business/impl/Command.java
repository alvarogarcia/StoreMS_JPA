package uo.ri.amp.business.impl;

import alb.util.BusinessException;

/**
 * @author alvaroastur4
 * 
 */
public interface Command {

	public Object execute() throws BusinessException;

}
