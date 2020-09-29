package aulaTDD;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AnnotationsTest {
	
	@Before
	public void executaAntesDeCadaMetodo() {
		System.out.println("\tInício do teste");
	}
	
	@After
	public void executaDepoisDeCadaMetodo() {
		System.out.println("\t\tFim do teste");
	}
	
	@BeforeClass
	public static void executaAntesDaClasse() {
		System.out.println("Antes da classe");
	}
	
	@AfterClass
	public static void executaDepoisDaClasse() {
		System.out.println("Depois da classe");
	}
	
	@Test
	public void fazerAlgo1() {
	}
	
	@Test
	public void fazerAlgo2() {
	}
	
	@Test
	public void fazerAlgo3() {
	}
}
