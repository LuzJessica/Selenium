package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day2 {
	
	/*For the cases where we have a lot of classes with a lot of testcases, to execute them in the same execution, we need to extract
	 * a xml file that represent my entire project. For it a just need to do a right click on my project and in the menu TestNG, click 
	 * again in Convert to TestNG. This will create the xml file, and once I want to execute all tests in one step, I just need
	 * to right click on the xml file and do a run as TestNG Suite!*/
	
	@Test(groups=("smokeTest"))
	public void TestDay2() {
		System.out.println("Hello Day 2");
	}
	
	/*We can set some actions to execute before tests run. For it we
	 * use the anotation @BeforeTest*/
	
	@BeforeTest
	public void preTestActions() {
		System.out.println("Before execute the test cases");
		
	}
	
	/*In another way, we can also have executions for after the test cases execution
	 * and we can do it by anotating the method with @AfterTest*/
	
	@AfterTest
	public void postTestActions() {
		System.out.println("After execute the test cases");
	}
	
	/*The execute before suite, will execute before all tests*/
	
	@BeforeSuite
	public void executeBeforeSuite() {
		System.out.println("Before execute any tests of this suite");
	}
	
	/*The execute before suite, will execute after all tests*/
	
	@AfterSuite
	public void executeAfterSuite() {
		System.out.println("After execute any tests of this suite");
	}
	
	@BeforeClass
	public void executeBeforeClass() {
		System.out.println("Before executing any method in the class Day 2");
	}
	
	@AfterClass
	public void executeAfterClass() {
		System.out.println("After executing any method in the class Day 2");
	}

	
	/*The majority between the anotations is
	 * first will be executed the @BeforeSuite instruction
	 * seconds will be executed the @BeforeTest instruction
	 * third will be executed the @BeforeClass Test instruction
	 * then  will be executed the @Test
	 * and after @AfterClass
	 * and after @AfterTest
	 * and the last one is the @AfterSuite*/
	
}
