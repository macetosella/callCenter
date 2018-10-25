package ar.com.uca.callcenter;

import ar.com.uca.callcenter.entity.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CallDispatcherTest extends TestCase {
	final int TIEMPO_MAX_LLAMADA_MILISEC = 10000;
   /**
     * @return the suite of tests being tested
     */
    public static Test suite(){
        return new TestSuite( CallDispatcherTest.class );
    }
    
    //Este test dura 15s
    public void testTresLLamadas(){
    	try {
    		System.out.println("-----------TEST 3 LLAMADAS--------------");
	    	CallDispatcher dispatcher = new CallDispatcher();
	    	dispatcher.start();
			dispatcher.addEmployeeAvailable(new Operator( "Operator 1"));
			Call llamada1 = new Call(" 1 ");
			llamada1.setTimeLength(5);
			Call llamada2 = new Call(" 2 ");
			llamada2.setTimeLength(5);
			Call llamada3 = new Call(" 3 ");
			llamada3.setTimeLength(5);
	    	dispatcher.dispatchCall(llamada1);
			dispatcher.dispatchCall(llamada2);
			dispatcher.dispatchCall(llamada3);

			//Las calls de este test duran 5s y como hay 1 solo operador, las calls tienen que ser atendidasen 15s.
			Thread.sleep(15000);
			
			//Al finalizar este tiempo, las llamdas deberian haber sido atendidas
			assertTrue(dispatcher.getLLamadas().isEmpty());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			fail();
		}
    	
    }
    //Este test dura 33s
    public void testDiezLLamadas(){
		System.out.println("-----------TEST 10 LLAMADAS--------------");
    	try {
	    	CallDispatcher dispatcher = new CallDispatcher();
	    	dispatcher.start();
			dispatcher.addEmployeeAvailable(new Director( "Director 1"));
			dispatcher.addEmployeeAvailable(new Supervisor( "Supervisor 1"));
			dispatcher.addEmployeeAvailable(new Operator( "Operator 1"));
			
	    	dispatcher.dispatchCall(new Call(" 1 "));
			dispatcher.dispatchCall(new Call(" 2 "));
			dispatcher.dispatchCall(new Call(" 3 "));
			dispatcher.dispatchCall(new Call(" 4 "));
			dispatcher.dispatchCall(new Call(" 5 "));
			dispatcher.dispatchCall(new Call(" 6 "));
			dispatcher.dispatchCall(new Call(" 7 "));
			dispatcher.dispatchCall(new Call(" 8 "));
			dispatcher.dispatchCall(new Call(" 9 "));
			dispatcher.dispatchCall(new Call(" 10 "));

			//Espero el tiempo maximo para que todas las calls hayan sido atendidas:
			//((cant calls * tiempo de duracion max de llamada) * cant empleados)
			Thread.sleep((TIEMPO_MAX_LLAMADA_MILISEC * 10)*3);
			
			//Al finalizar este tiempo, las llamdas deberian haber sido atendidas
			assertTrue(dispatcher.getLLamadas().isEmpty());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
			fail();
		}
    	
    }
    //Este test dura 20s
   public void testIncomingCalls(){
		System.out.println("-----------TEST INCOMING CALLS--------------");
    	try {
	    	CallDispatcher dispatcher = new CallDispatcher();
	    	dispatcher.start();
	    	dispatcher.dispatchCall(new Call(" 1 "));
			dispatcher.dispatchCall(new Call(" 2 "));
			dispatcher.dispatchCall(new Call(" 3 "));
			dispatcher.dispatchCall(new Call(" 4 "));
			dispatcher.dispatchCall(new Call(" 5 "));
			dispatcher.addEmployeeAvailable(new Operator( "Operator 1"));
			dispatcher.addEmployeeAvailable(new Operator( "Operator 2"));
			dispatcher.addEmployeeAvailable(new Operator( "Operator 3"));
			dispatcher.addEmployeeAvailable(new Supervisor( "Supervisor 1"));
			dispatcher.addEmployeeAvailable(new Operator( "Operator 4"));
			dispatcher.dispatchCall(new Call(" 6 "));
			dispatcher.addEmployeeAvailable(new Director( "Director 1"));
			dispatcher.dispatchCall(new Call(" 7 "));
			dispatcher.dispatchCall(new Call(" 8 "));
			dispatcher.addEmployeeAvailable(new Supervisor( "Supervisor 2"));
			dispatcher.dispatchCall(new Call(" 9 "));
			dispatcher.dispatchCall(new Call(" 10 "));
			dispatcher.dispatchCall(new Call(" 11 "));
			dispatcher.dispatchCall(new Call(" 12 "));
			dispatcher.addEmployeeAvailable(new Director( "Director 2"));
			dispatcher.dispatchCall(new Call(" 13 "));
			dispatcher.dispatchCall(new Call(" 14 "));
			dispatcher.dispatchCall(new Call(" 15 "));
			dispatcher.dispatchCall(new Call(" 16 "));

			//Espero el tiempo maximo para que todas las calls hayan sido atendidas:
			//((cant calls * tiempo de duracion max de llamada) / cant empleados)
			Thread.sleep((TIEMPO_MAX_LLAMADA_MILISEC * 16)*8);
			
			//Al finalizar este tiempo, las llamdas deberian haber sido atendidas
			assertTrue(dispatcher.getLLamadas().isEmpty());

		} catch (InterruptedException e) {
			e.printStackTrace();
			fail();
		}
    	
    }
}
