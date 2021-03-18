package stepdef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	


	public static WebDriver driver;
	
	
	
	@Before
	public static void beforeScenario() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sprit\\eclipse-workspace\\reach\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("https://admin.testing.reach24.net/");
		Thread.sleep(5000);
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		
		driver.findElement(By.id("admin_user_email")).sendKeys("lp+vsadmin@reach24.net");
	    driver.findElement(By.id("admin_user_password")).sendKeys("welcome123");
	    driver.findElement(By.xpath("//button[@class='btn btn-navy btn-block']")).click();
		Thread.sleep(3000);
		
	}
	
	@After
	public static void afterScenario() {
	//	driver.close();
		
	} 

}
