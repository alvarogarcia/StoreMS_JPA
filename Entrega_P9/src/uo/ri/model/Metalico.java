package uo.ri.model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;



@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("TMetalico")
public class Metalico extends MedioPago implements Serializable{
	
	public Metalico(){}

	




}
