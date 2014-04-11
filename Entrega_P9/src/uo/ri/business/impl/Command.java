package uo.ri.business.impl;

import alb.util.BusinessException;

public interface Command {
	
	public Object execute() throws BusinessException;

}
