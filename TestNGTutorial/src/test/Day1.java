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
	
	/*We can separet our tests in groups. So we can execute them separatelly. After sinalize this in the front of
	 * the @Test anotation, we can call onli this test by passing in the xml file the tag groups, identifiyng the 
	 * group by name. So it will execute only test methods that are part of the group*/
	
	@Test(groups=("smokeTest"))
	public void SecondTestCase() {
		System.out.println("Hello Second Test");
	}

}
