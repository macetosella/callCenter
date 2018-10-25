package ar.com.uca.callcenter;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

import ar.com.uca.callcenter.entity.AbstractEmployee;
import ar.com.uca.callcenter.entity.Call;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class CallDispatcher extends Thread{

	BlockingQueue<AbstractEmployee> IdleEmployes;
	BlockingQueue<Call> calls;

	public CallDispatcher(){
		BasicConfigurator.configure();
		IdleEmployes = new PriorityBlockingQueue<AbstractEmployee>();
		calls = new LinkedBlockingQueue<Call>();
	}

	public void dispatchCall(Call aCall) throws InterruptedException{
		Logger log = Logger.getLogger("DispatchCall |" );
		log.info("Entrando aCall " + aCall.getDescription());
		if(calls.size() == 10){
			try {
				log.error("Se llegó al limite de llamadas:"+ calls.size());
				throw new Exception("Hay más de "+ calls.size() +" llamadas, intente más tarde!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.calls.put(aCall);
	}

	public void run() {
		Call aCall;
		AbstractEmployee employee;
		try {
			Logger log = Logger.getLogger("" );
			while(true){
				aCall = calls.take();
				log.info("Esperando a tomar la llamada " + aCall.getDescription());
				employee = IdleEmployes.take();
				log.info("Empleado " + employee.getName() + " va a tomar la llamada " + aCall.getDescription());
				employee.employeeAvailable(aCall);
				this.addEmployeeAvailable(employee);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void addEmployeeAvailable(AbstractEmployee employee){
		this.IdleEmployes.add(employee);
	}
	
	public Queue<Call> getLLamadas(){
		return calls;
	}
	
	public Queue<AbstractEmployee> getIdleEmployes(){
		return IdleEmployes;
	}
}
