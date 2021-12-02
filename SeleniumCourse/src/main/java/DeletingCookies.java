import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

public class DeletingCookies {

	public static void main(String[] args) throws IOException {

		String driverPath = "C:\\Users\\user\\Desktop\\Selenium\\SeleniumCourse\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Delete all
		driver.manage().deleteAllCookies();
		/*Delete specific cookies
		/driver.manage().deleteCookieNamed("cookieName");
		dd some cookie
		driver.manage().addCookie(null); */
		
		driver.get("http://www.google.com");
		
		//To take a screenshot from object, we have to convert the driver to screenshot object
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\user\\Desktop\\Selenium\\SeleniumCourse\\screenshot.png")); 

	}

}
