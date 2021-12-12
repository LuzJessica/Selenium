import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {

		String driverPath = "C:\\Users\\user\\Desktop\\Selenium\\SeleniumCourse\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);

		WebDriver driver = new ChromeDriver();
		driver.get("http://www.rahulshettyacademy.com/AutomationPractice/");

		/* Java have some methods that call URLS and get the status code 
		 * The first step is call all urls links tied up to the links using selenium 
		 * If the status code is > 400, then the link is not working
		 */

		List<WebElement> links  = driver.findElements(By.cssSelector("li[class*='gf-li'] a"));
		
		/*When we use only Assert class, we stop or test once we found something that failure. SoftAssert guarantee that all elements of list
		 * will be checked
		 */
		SoftAssert a = new SoftAssert();

		for(WebElement link : links) {

			String url = link.getAttribute("href");

			HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responseCode = conn.getResponseCode();
			System.out.println(responseCode);
			a.assertTrue(responseCode < 400,"The link with Text " + link.getText() + "is broken with code "+ responseCode);
		}

		a.assertAll();
	}

}

