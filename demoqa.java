package Test.cucumber;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.And;
import io.cucumber.java.en.And.Ands;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class demoqa {
	ChromeDriver driver;
	@Given("User launches the browser and opens DemoQA website")
	public void website_lunch() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\www.abcom.in\\\\Downloads\\\\chromedriver-win64 (1)\\\\chromedriver-win64\\\\chromedriver.exe");
		
	       driver=new ChromeDriver();
	      driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	      
	      driver.get("https://demoqa.com/");
	      Thread.sleep(1000);
	
	}
	@When("User clicks on the elements section")
	public void Element()
	{
		 driver.findElement(By.xpath("//h5[text()='Elements']/ancestor::div[@class='card mt-4 top-card']")).click();
	}
	
	@When("User clicks on the Check box  option from the sidebar")
	public void sidebar_checkbox()
	{
		driver.findElement(By.xpath("//*[@id=\"item-1\"]/span")).click();
	}
	@And("User selects the home  checkbox")
	public void home()
	{
		 WebElement homeLabel = driver.findElement(By.cssSelector("label[for='tree-node-home']"));
	      homeLabel.click();
	}
	@Then("Home checkbox should be selected successfully")
	public void  done()
	{
		WebElement checkboxInput = driver.findElement(By.id("tree-node-home"));
        if (checkboxInput.isSelected()) {
            System.out.println("✅ Home checkbox is selected.");
        } else {
            System.out.println("❌ Home checkbox is NOT selected.");
        }
        driver.close();
		
	}
	
	@When("User clicks on the Radio button option from the sidebar")
	public  void Radio_radiobutton()
	{
		driver.findElement(By.xpath("//*[@id=\"item-2\"]/span")).click();
	}
	@And("User selects the Yes Radio button")
	public void Radio_yes()
	{
		 driver.findElement(By.cssSelector("label[for='yesRadio']")).click();
	}
	
	@Then("Yes radio button  should be selected successfully")
	public void done_selected()
	{
		 WebElement YesRadio = driver.findElement(By.id("yesRadio"));
	      if(YesRadio.isSelected())
	      {
	    	  System.out.println("Radio button is selected ");
	      }  else {
	    		  System.out.println(" Radio button not selected");    
	    	  }
	      driver.close();
	}
	@When("User clicks on the Text Box option from the sidebar")
	public void Text_box()
	{
		driver.findElement(By.xpath("//*[@id=\"item-0\"]/span")).click();
}
	@And("Enter the Full Name")
	public void Full_name()
	{
		driver.findElement(By.id("userName")).sendKeys("Tanvi Kindre");
}
	@And("Enter the Email id")
	public void Email()
	{
		driver.findElement(By.id("userEmail")).sendKeys("kindretanvi62@gmail.com");
}
	@And("Enter the Current Address")
	public void CA()
	{
		driver.findElement(By.id("currentAddress")).sendKeys("Balaji Negar Gurudatta society flat No.2 Pune 411043");
}
	@And("Enter the Permnent Adddress")
	public void PA()
	{
		driver.findElement(By.id("permanentAddress")).sendKeys("Balaji Negar Gurudatta society flat No.2 Pune 411043");
}
	@Then("User clicks the Submit button and data saved correctly")
	public  void Submit()
	{
		//driver.findElement(By.id("submit")).click();
		 WebElement submitButton = driver.findElement(By.id("submit"));
	       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
	       submitButton.click();
	       driver.close();
}
	@And("User clicks on the web tables option from the sidebar")
	public void web_tables()
	{
		driver.findElement(By.xpath("//*[@id=\"item-3\"]/span")).click();
	}
	@And("User clicks on the Add button")
	public void Add()
	{
		driver.findElement(By.id("addNewRecordButton")).click();
	}
	@And("User fills the registration form with valid data")
	public void fill_data()
	{
		driver.findElement(By.id("firstName")).sendKeys("tanushri");
		driver.findElement(By.id("lastName")).sendKeys("kindre");
		driver.findElement(By.id("userEmail")).sendKeys("tanvi.k@gmail.com");
		driver.findElement(By.id("age")).sendKeys("21");
		driver.findElement(By.id("salary")).sendKeys("12000");
		driver.findElement(By.id("department")).sendKeys("QA");
	}
	@And("User clicks on the Submit button")
	public void submit2()
	{
		driver.findElement(By.id("submit")).click();
	}
	@Then("Newly added record should be visible in the Web Table")
	public void table()
	{
		WebElement tableBody = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]"));
	    String tableText = tableBody.getText();

	    Assert.assertTrue(tableText.contains("tanushri"));
	    Assert.assertTrue(tableText.contains("kindre"));
	    driver.close();
		}
	
	@And("User clicks on the Edit  button for a record")
	public void edit()
	{
		driver.findElement(By.className("mr-2")).click();
	}
	@And("User selects the last name field and edits it with new data")
	public void lastname_edit()
	{
		driver.findElement(By.id("lastName")).clear();
		driver.findElement(By.id("lastName")).sendKeys("kokare");
	}
	@Then("User clicks on the submit button")
	public void submit3()
	{
		driver.findElement(By.id("submit")).click();
	}
	@And("The newly added data should be shown in the table")
	public void tabledata()
	{
		String updatedLastName = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[1]/div[2]/div[1]/div/div[2]")).getText();
		
	    // Assert that the updated last name is the one entered
	    Assert.assertEquals(updatedLastName, "kokare", "Last name  updated correctly.");
	    driver.close();
	}
	@And("User click on button option")
	public void button()
	{
		driver.findElement(By.xpath("//*[@id=\"item-4\"]/span")).click();
	}
	@And("button should be coorectly click and message should be appear")
	public void button_click()
	{
		WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickBtn).perform();
        driver.close();
	}
	@And("User selects the  form  section")
	public  void Form()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");

		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[2]/span")).click();
		
	}
	@And("user select the Pratice form sub menue")
	public void Pratice_form() {
		driver.findElement(By.xpath("//span[text()='Practice Form']")).click();//pratice form
	}
	@And("User fill the Pratice form with the valid data")
	public void Fill_praticeform() throws InterruptedException {
		
		driver.findElement(By.id("firstName")).sendKeys("Tanu");
		driver.findElement(By.id("lastName")).sendKeys("kindre");
		driver.findElement(By.id("userEmail")).sendKeys("tanu@gmail.com");
		
		Thread.sleep(1000);
		WebElement genderRadio = driver.findElement(By.cssSelector("label[for='gender-radio-2']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", genderRadio);
		genderRadio.click();
        driver.findElement(By.id("userNumber")).sendKeys("7709117877");
        WebElement checkbox1 = driver.findElement(By.cssSelector("label[for='hobbies-checkbox-3']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox1);
		checkbox1.click();
		WebElement fileInput = driver.findElement(By.id("uploadPicture")); //browse file
        fileInput.sendKeys("C:\\Users\\www.abcom.in\\Downloads\\sampleFile.jpeg");
		 driver.findElement(By.id("currentAddress")).sendKeys("balaji negar");
		
		
		driver.findElement(By.id("dateOfBirthInput")).click();//Birth date 

		// Select Month
		WebElement monthDropdown = driver.findElement(By.className("react-datepicker__month-select"));
		Select selectMonth = new Select(monthDropdown);
		selectMonth.selectByVisibleText("March");  // Example: May

		// Select Year
		WebElement yearDropdown = driver.findElement(By.className("react-datepicker__year-select"));
		Select selectYear = new Select(yearDropdown);
		selectYear.selectByVisibleText("2004"); // Example: 1995

		// Select Date
		driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[4]/div[1]")).click(); // Example: 15th of the month
		
		driver.findElement(By.id("react-select-3-input")).sendKeys("Rajasthan",Keys.ENTER);
		driver.findElement(By.id("react-select-4-input")).sendKeys("jaipur",Keys.ENTER);
		driver.findElement(By.id("subjectsInput")).sendKeys("Qa test");
	}
	@Then("The form should submmited successfully")
	public void submit4() throws InterruptedException {
		
		driver.findElement(By.id("submit")).click();
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ESCAPE).build().perform();
        driver.close();
	}
	@And("user select the alert box")
	public void Alert()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("document.getElementById('fixedban').style.display='none';");
	    WebElement menuCard = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[3]/span/div/div[1]/span"));
	    js.executeScript("arguments[0].scrollIntoView(true);", menuCard);

	    // Now click it
	    menuCard.click();
	    
		//driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[1]/div/div/div[3]/span/div/div[1]/span")).click();//menue
		driver.findElement(By.xpath("//span[text()='Alerts']")).click();
	}
	@When("User clicks the simple alert button")
	public void simple_alert()
	{
		driver.findElement(By.id("alertButton")).click();
	}
	@Then("A simple alert appears and user accepts it")
	public void simple_click() throws InterruptedException
	{
		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
	}
	@When("User clicks the confirm alert button")
	public void Confirm_Alert() throws InterruptedException
	{
		driver.findElement(By.id("confirmButton")).click();
		Thread.sleep(5000);
	}
	@Then("A confirm alert appears and user clicks OK")
	public void Alert_click()
	{
		Alert alert2 = driver.switchTo().alert();
		alert2.accept();//accept  Alert
	}
	@Then("Confirm result should show You selected Ok")
	public void confirm_show()
	{
		
		
		WebElement resultText = driver.findElement(By.id("confirmResult"));
	    String actualMessage = resultText.getText();
	    String expectedMessage = "You selected Ok";
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	@When("User clicks the prompt alert button")
	public void PromtAlert()
	{
		driver.findElement(By.id("promtButton")).click();
	}
	@Then("A prompt alert appears and user enters Tanvi and accepts it")
	public void Alert_value() throws InterruptedException
	{

		Alert alert3 = driver.switchTo().alert();
		alert3.sendKeys("Tanvi");
		Thread.sleep(1000);
		alert3.accept();
	}
	@Then("Prompt result should show You entered Tanvi")
	public void Aler_show()
	{
		
		
		WebElement promptResult = driver.findElement(By.id("promptResult"));
		String promptMessage = promptResult.getText();
		String expectedPromptMessage = "You entered Tanvi";
		
	}
	@Then("user click on timer button ")
	public void timealert() throws InterruptedException {
	driver.findElement(By.id("timerAlertButton")).click(); // alert box 5sec
    Thread.sleep(5000);
	Alert alert1 = driver.switchTo().alert();
	alert1.accept();
	driver.close();
}
}
	

	



