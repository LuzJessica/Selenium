package test;

import org.testng.annotations.Test;

public class Day4 {
	
	@Test
	public void WebLoginCarLoan() {
		//selenium
		System.out.println("WEBCAR");
	}
	
	@Test
	public void MobileLoginCarLoan() {
		//appium
		System.out.println("MOBILECAR");
	}
	
	@Test(groups=("smokeTest"))
	public void APILoginCarLoan() {
		//rest api
		System.out.println("APICAR");
	}

}
