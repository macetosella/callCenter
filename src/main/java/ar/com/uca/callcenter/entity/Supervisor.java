package ar.com.uca.callcenter.entity;

public class Supervisor extends AbstractEmployee {

	public Supervisor(String name){
		super(name);
		super.typeEmployee = TypeEmployee.SUPERVISOR;
	}

}
