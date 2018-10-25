package ar.com.uca.callcenter.entity;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class LlamadaTest extends TestCase {
	public static Test suite(){
		return new TestSuite( LlamadaTest.class );
	}
	public static void testLlamada(){
		Call llamada	= new Call("llamada test");
		assertTrue(llamada.getTimeLength()>= Call.MIN_TIME_LENGHT);
		assertTrue(llamada.getTimeLength()<=Call.MAX_TIME_LENGHT);
	}
}
