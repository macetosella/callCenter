package ar.com.uca.callcenter.entity;

import ar.com.uca.callcenter.CallDispatcher;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class OperatorTest extends TestCase {
	public static Test suite(){
		return new TestSuite( OperatorTest.class );
	}

	public void testOperador(){
		Call llamada = new Call("llamada test");
		llamada.setTimeLength(5);
		CallDispatcher dispatcher = new CallDispatcher();
		Operator operator = new Operator( "operator test");
		try {
			operator.employeeAvailable(llamada);
			Thread.sleep(6000);
			assertTrue(dispatcher.getIdleEmployes().size()==1);
		} catch (InterruptedException e) {
			e.printStackTrace();
			fail();
		}
		
	}
}
