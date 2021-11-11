import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Selenium\\SeleniumCourse\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String username = "jessicaluz";
		String wrongPassword = "testPassword";

		//setting time to selenium so it can waits for a response and will not show error when could not access an object thar is not ready yet
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		/*
		 * To find elements we need go to go the web page and click on the element we want to inspect, click with right button
		 * and click inspect. This will show us the attributes of the element and then we need to find an attribute that
		 * is supported by Selenium.
		 * In the exemple below we are inspecting the email and password fields. 
		 * For this, the locator that we find was the id and name, respectively. 
		 * So we will use this to access the elements and make some action.
		 * What the example do is, after finding the elements, set the email and password in the fields and, after that
		 * click on the Login Button to start session.
		 * */

		// Login Window

		driver.findElement(By.id("inputUsername")).sendKeys(username);
		driver.findElement(By.name("inputPassword")).sendKeys(wrongPassword);
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();

		/* Putting this because, as the changing windows is too fast, 
		   we need this time so the selenium does not make confusion with the reset password button
		 */
		Thread.sleep(2000);

		// Forgot Login Window

		String newPassword = Locators.getPassword(driver);		
		driver.findElement(By.cssSelector("button.go-to-login-btn")).click();
		Thread.sleep(2000);


		// Login using the new password

		driver.findElement(By.xpath("//form/input[@placeHolder='Username']")).sendKeys("jessicaluz");
		driver.findElement(By.xpath("//form/input[@placeHolder='Password']")).sendKeys(newPassword);
		driver.findElement(By.xpath("//div/form/div/span/input[@id='chkboxOne']")).click();
		driver.findElement(By.xpath("//div/form/div/span/input[@id='chkboxTwo']")).click();
		driver.findElement(By.className("signInBtn")).click();
		
		// Logout by clicking in logout button
		
		driver.findElement(By.cssSelector("button.logout-btn")).click();

	}


	//Getting the password dinamically by another method
	public static String getPassword(WebDriver driver) {
		driver.findElement(By.xpath("//input[@placeHolder='Name']")).sendKeys("Jessica");
		//The line bellow has the [2] argument because the attribute type = Text is not unique
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("jessicaluz@gec.inatel.br");
		driver.findElement(By.cssSelector("input[placeHolder='Phone Number']")).sendKeys("+5519997351423");
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		String passwordReset  = (driver.findElement(By.cssSelector("form p")).getText());
		String resetPassword = passwordReset.substring(31, 49);
		return resetPassword;
	}

}
