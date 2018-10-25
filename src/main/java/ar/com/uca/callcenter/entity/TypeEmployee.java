package ar.com.uca.callcenter.entity;

public enum TypeEmployee {
	OPERATOR(1),
	SUPERVISOR(2),
	DIRECTOR(3);
	private int priority;
	
	TypeEmployee(int prority){
		this.priority =prority;
	}
	
	public int getPriority(){
		return priority;
	}
}
