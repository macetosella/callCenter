package ar.com.uca.callcenter.entity;

public class Operator extends AbstractEmployee {
	public Operator(String name){
		super(name);
		super.typeEmployee = TypeEmployee.OPERATOR;
	}



}
