package ar.com.uca.callcenter.entity;

import org.apache.log4j.Logger;

public abstract class AbstractEmployee implements Comparable<AbstractEmployee>{

	protected TypeEmployee typeEmployee;
	protected String name;
	private Call answeredCall;

	private static final int TYPE_TIME = 1000;

	
	public AbstractEmployee(String name){

		this.name = name;
	}
	
	public int getPriority(){
		return this.typeEmployee.getPriority();
	}
	
	public int compareTo(AbstractEmployee otherEmployee) {
		if (this.getPriority() < otherEmployee.getPriority()){
			return -1;
		}
		if (this.getPriority() > otherEmployee.getPriority()){
			return 1;
		}
		return 0;	
	}

	public void employeeAvailable(Call eCall){
		this.answeredCall = eCall;
		this.answer();
	}

	public void answer() {
        try {
			Logger log = Logger.getLogger("" );
			Thread.sleep(TYPE_TIME * answeredCall.getTimeLength());
			log.info("Llamada " + answeredCall.getDescription() + " finalizada. Duracion :" + answeredCall.getTimeLength() + "s");
      	  	
			log.info("Empleado " + this.getName() + " disponible");
		} catch (InterruptedException e) {
			Logger log = Logger.getLogger("" );
        	log.error("Error atendiendo llamada " + answeredCall.getDescription());
			e.printStackTrace();
		} 
	}	

	public String getName() {
		return name;
	}

}
