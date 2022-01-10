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
	
	/*As we see, when we run a Test Class, the methods are executed by name, in alphabetical order
	 * but, in a real scenario, could be difficult to just put the names of test to execute in alphabetical
	 * order, what can impact if the test should be executed in a specific order. To fix this we can 
	 * sinalize in front of the @Test anotation that one test depends on another on to execute*/
	@Test(dependsOnMethods={"Demo"})
	public void atestThatDependsOnFirstMethod() {
		System.out.println("Test to execute after Demo method");
	}
	
	/*If for example we know that some method will fail and we are waiting for fixes, we can skip the test
	 * so our test execution will not fail. We can do that using the enabled dependency*/
	
	@Test(enabled=false)
	public void testToSkip() {
		System.out.println("Skips this test for while");
	}
	
	/*for API test cases, sometime request takes more time than expected. In this case is better to pss some timeout parameter
	 * to do not fail our test*/
	
	@Test(timeOut=1000)
	public void testWithTimeOut(){
		System.out.println("This test will wait 1 second to execute before fail");	
	}

}
