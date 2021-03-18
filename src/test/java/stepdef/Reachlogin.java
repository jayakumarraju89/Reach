package stepdef;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Reachlogin {
	
	public static WebDriver driver;	
	

	public  Reachlogin() throws InterruptedException {
		driver = Hooks.driver;
		Thread.sleep(2000);
} 
	
	
/*	@Given("enter user name and password and click on login button")
	public void enter_user_name_and_password_and_click_on_login_button() {
		
	}	*/

	@Given("verify login sucessful and and landed in tenant tab")
	public void verify_login_sucessful_and_and_landed_in_tenant_tab() throws InterruptedException {
		if (driver.getPageSource().contains("List of Tenants")) {
			System.out.println("Login successful");
		}
		else {
			System.out.println("Login failed");
		}		
		Thread.sleep(2000);
	}

	@When("search for sampleTd as tenant in search filter")
	public void search_for_sampleTd_as_tenant_in_search_filter() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement tenantfilter = driver.findElement(By.xpath("//input[@class='form-control input-sm']"));
/*		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].scrollIntoView(true);", tenantfilter);
		js.executeScript("arguments[0].click()", tenantfilter);	*/
		
		driver.findElement(By.xpath("//input[@class='form-control input-sm']")).sendKeys("sampletd");
		driver.findElement(By.xpath("//button[@class='btn btn-success dropdown-toggle']")).click();
		Thread.sleep(3000);
	}

	@When("click on sampleTd entry from the list")
	public void click_on_sampleTd_entry_from_the_list() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//a[@class='btn btn-green btn-xs'])[2]")).click();		
	}

	@When("verify SampleTD tenant page is opened")
	public void verify_SampleTD_tenant_page_is_opened() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if (driver.getPageSource().contains("SampleTD")) {
			System.out.println("Page got opened successfully");
		} else {
			System.out.println("error");
		}
	}

	@When("Navigate to the Tenant url and click on the url")
	public void navigate_to_the_Tenant_url_and_click_on_the_url() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement tenanturl = driver.findElement(By.xpath("//*[@id=\"company-info\"]/div[2]/div[3]/p/a"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", tenanturl);
		js.executeScript("arguments[0].click()", tenanturl);
		Thread.sleep(5000);
	    ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTb.get(1));
	}

	@When("Verify a new tenant login page opened")
	public void verify_a_new_tenant_login_page_opened() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		if (driver.getPageSource().contains("Log In")) {
			System.out.println("Login url launched");
		} else {
			System.out.println("Url not launched");
		}
		Thread.sleep(5000);
	}

	@When("Enter email and password then click on login button")
	public void enter_email_and_password_then_click_on_login_button() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("shanmugapriya@reach24.net");
		driver.findElement(By.xpath("(//input[@class='form-control'])[2]")).sendKeys("welcome123");
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();	
		Thread.sleep(3000);
	}
	
	@Then("Get count from open tab and validate with total entries")
	public void get_count_from_open_tab_and_validate_with_total_entries() throws InterruptedException {
		
		
		
		WebElement open = driver.findElement(By.xpath("(//span[@class='badge'])[2]"));
		String count = open.getText();
		System.out.println("Open count = " + count);
		WebElement showing = driver.findElement(By.xpath("//div[@class='dataTables_info']"));
		String count1 = showing.getText();
		System.out.println("Showing count = " + count1);
		Thread.sleep(3000);
	/*	Pattern p = Pattern.compile("[^\\d]*[\\d]+[^\\d]+[\\d]+[^\\d]+([\\d]+)");
		Matcher  m = p.matcher(count1);
        if (m.find()) {
            System.out.println(m.group()); // second matched digits
        }	*/
	}

	@Then("Get count from submitted tab and validate with total entries")
	public void get_count_from_submitted_tab_and_validate_with_total_entries() throws InterruptedException {
		driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//a[@data-toggle ='tab'])[3]")).click();
		WebElement open = driver.findElement(By.xpath("(//span[@class='badge'])[3]"));
		String count = open.getText();
		System.out.println("Open count = " + count);
		Thread.sleep(2000);
		WebElement showing = driver.findElement(By.xpath("(//div[@class='col-md-6'])[2]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", showing);
		js.executeScript("arguments[0].click()", showing);
		String count1 = showing.getText();
		System.out.println("Showing count = " + count1);
		Thread.sleep(3000);
		
	}



		

}
