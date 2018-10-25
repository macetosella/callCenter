package ar.com.uca.callcenter.entity;

public class Director extends AbstractEmployee {

	public Director(String nombre){
		super(nombre);
		this.typeEmployee = TypeEmployee.DIRECTOR;
	}



}
