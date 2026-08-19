package selenium;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;





public class Sample {

public static void main(String[] args) throws IOException {
 
	WebDriver driver =new ChromeDriver();
	driver.get("http://127.0.0.1:5500/test.html");

	WebElement firstName=driver.findElement(By.id("fname"));
	firstName.sendKeys("Aarthi");
	
	WebElement lastName=driver.findElement(By.id("fname"));
	lastName.clear();
	
	WebElement getTexts=driver.findElement(By.id("submitBtn"));
	String text=getTexts.getText();
	System.out.println(text);
	
	WebElement value=driver.findElement(By.id("resetBtn"));
	String texts=value.getAttribute("id");
	System.out.println(texts);
	
	WebElement clickButton=driver.findElement(By.id("submitBtn"));
	clickButton.click();
	
//handling
	WebElement button=driver.findElement(By.id("resetBtn"));
	System.out.println(button.isEnabled());	
	
   WebElement buttons=driver.findElement(By.id("resetBtn"));
	System.out.println(buttons.isDisplayed());
	
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	
	File dest=new File("C:\\Users\\Aarthi G\\OneDrive\\Desktop\\htmlselenium\\Screenshotimg1.png");
	
	Files.copy(src.toPath(), dest.toPath());
	System.out.println("Screenshot saved successfully");
	//alert
	
	driver.findElement(By.id("simplealert")).click();
    Alert alert = driver.switchTo().alert();
    System.out.println(alert.getText());
    alert.accept();
    
    driver.findElement(By.id("confirmButton")).click();

    Alert al1 = driver.switchTo().alert();

    System.out.println(al1.getText());

    al1.dismiss();


    driver.findElement(By.id("promptButton")).click();

    Alert al2 = driver.switchTo().alert();

    System.out.println(al2.getText());

    al2.sendKeys("Aarthi");

    al2.accept();
    

	
//navigate
driver.get("https://www.flipkart.com/");

driver.navigate().to("http://127.0.0.1:5500/test.html");
driver.navigate().back();
driver.navigate().forward();
driver.navigate().refresh();





	
	

	}

}
