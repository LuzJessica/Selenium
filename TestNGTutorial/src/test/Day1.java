package test;

import org.testng.annotations.Test;

public class Day1 {

	/* To run TestNG classes we don't need the method plubic static void main because the TestNG frameworks
	 * runs above the java compiler, so it works like this in the background. That is the reason that we dont need
	 * this method. But we need the @Test anotation above each method to indicate that is a TestNG execution*/
	
	@Test
	public void Demo() {
		System.out.println("Hello TestNG");
	}

}
