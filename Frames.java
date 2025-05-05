package Test.cucumber;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Frames {
	
	ChromeDriver driver;
	String originalTab;
	@Given("I launch the Chrome browser and open the DemoQA website")
	public void website_lunch() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\www.abcom.in\\\\Downloads\\\\chromedriver-win64 (1)\\\\chromedriver-win64\\\\chromedriver.exe");
		
	       driver=new ChromeDriver();
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	      
	      driver.get("https://demoqa.com/");
	      Thread.sleep(1000);
	      
}
	@And("I click on Alerts, Frame & Windows section")
	public void menue()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("document.getElementById('google_ads_iframe_/21849154601,22343295815/Ad.Plus-Anchor_0__container__').style.display='none';");


		   // "Alerts, Frame & Windows"
		      WebElement element = driver.findElement(By.xpath("//div[@class='card-body']/h5[text()='Alerts, Frame & Windows']"));
		      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		      element.click();
	}
	@When("I click on Frames")
	public void frame()
	{
		driver.findElement(By.xpath("//span[text()='Frames']")).click();
	}
	@Then("I should see text inside frame1")
	public void Frame1()
	{
		 int frameCount = driver.findElements(By.tagName("iframe")).size();
		    System.out.println("Total iframes: " + frameCount);

		    // Switch to first frame by ID
		    driver.switchTo().frame("frame1");

		    // text inside the frame 
		    String frameText = driver.findElement(By.id("sampleHeading")).getText();
		    System.out.println("Text in Frame1: " + frameText);

		    // Switch back to main page
		    driver.switchTo().defaultContent();

		    
	}
	@And("I should see text inside frame2")
	public void Frame2()
	{
		driver.switchTo().frame("frame2");
	    String frameText2 = driver.findElement(By.id("sampleHeading")).getText();
	    System.out.println("Text in Frame2: " + frameText2);

	    // Switch back
	    driver.switchTo().defaultContent();
	    driver.close();
	}
	@When("I click on Nested Frames")
	public void Nested_Frame()
	{
		 WebElement element = driver.findElement(By.xpath("//span[text()='Nested Frames']"));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		    element.click();
	}
	@Then("I should see text inside the parent frame")
	public void Parent_frame()
	{
		 int frameCount1 = driver.findElements(By.tagName("iframe")).size();
		    System.out.println("Total iframes: " + frameCount1);
		    
		    driver.switchTo().frame("frame1");
		    String frametext1= driver.findElement(By.tagName("body")).getText();
		    System.out.println("Text in Parent frame : " + frametext1);
		    //No switch back bacause in same frame 
		    
		    driver.switchTo().frame(0);
	}
	@And("I should see text inside the child frame")
	public void Child_frame()
	{
		
		    String childframe =driver.findElement(By.tagName("p")).getText();
		    System.out.println("Child frame :"+childframe);
		    driver.switchTo().parentFrame();
		    driver.close();
		    
	}
	@When("I click on Browser Windows section")
	public void Browse_window() {
		 WebElement element2 = driver.findElement(By.xpath("//span[text()='Browser Windows']"));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
		    element2.click();

	}
	@And("I click on the New Tab button1")
	public void Tab1() throws InterruptedException {
		
		 originalTab = driver.getWindowHandle();

		    driver.findElement(By.id("tabButton")).click(); // Open new tab
		    Thread.sleep(1000);
		    Set<String> tabs = driver.getWindowHandles();
		    for (String handle : tabs) {
		        if (!handle.equals(originalTab)) {
		            driver.switchTo().window(handle);
		            break;
		        }
		    }


	}
	
	@Then("The new tab should open and display the heading")
	public void heading1() throws InterruptedException {
		 Thread.sleep(1000);
		 
		    WebDriverWait wait = new WebDriverWait(driver, 10); // 
		    WebElement sampleHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sampleHeading")));

		    String text = sampleHeading.getText();
		    System.out.println("Text in New Tab: " + text);

	}
	@And("I close the new tab and return to the original tab")
	public void close_window1()
	{
		
		 String currentWindow = driver.getWindowHandle(); // current (new) tab

		    driver.close(); // Close current tab

		    // Switch back to the original tab
		    for (String handle : driver.getWindowHandles()) {
		        if (!handle.equals(currentWindow)) {
		            driver.switchTo().window(handle);
		            break;
		        }
		    }
		}
  // Back to original tab
		
		    
	
	@When("I click on the New Window button2")
	public void new1() {
		  driver.findElement(By.id("windowButton")).click(); //click on  new window
		    

		    Set<String> allWindows = driver.getWindowHandles();
		    for (String handle : allWindows) {
		        if (!handle.equals(originalTab)) {
		            driver.switchTo().window(handle);
		            break;
		        }
		    }
		
	}
	@Then("The  new window should open and display the heading")
	public void Heading2() {
		 String  headingWindow = driver.findElement(By.id("sampleHeading")).getText();
		    System.out.println("Text in New Window: " + headingWindow);		
	}
	@And("I close the new window and return to the original window")
	public void close_original2() {
		driver.close(); // Close new window
	    driver.switchTo().window(originalTab); // Return to original tab
		
	}
	@When("I click on the New Window Message button3")
	public void window_message ()
	{
		driver.findElement(By.id("messageWindowButton")).click(); // Click on New Window Message

		Set<String> allWindows2 = driver.getWindowHandles();
		for (String handle : allWindows2) {
		 if (!handle.equals(originalTab)) {
		     driver.switchTo().window(handle);
		     break;
		 }
		}

	}
	@Then("The message window should open and display a text message")
	public void Heading3() throws InterruptedException {
		System.out.println("Switched to message window.");
		Thread.sleep(2000); 
	}
	@And("I close the message window and return to the original window")
	public void close_original3() {
		driver.close();

		//Switch back to original window
		driver.switchTo().window(originalTab);
		driver.quit();
	}
	
	
}
