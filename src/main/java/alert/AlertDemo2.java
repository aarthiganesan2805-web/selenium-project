package alert;


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
import org.openqa.selenium.support.ui.Select;

public class AlertDemo2 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
			
		driver.get("http://127.0.0.1:5500/test.html");	
		
		WebElement enterFname = driver.findElement(By.id("fname"));
		enterFname.sendKeys("Sergio");
		
		WebElement enterlname = driver.findElement(By.id("lname"));
		enterlname.sendKeys("Ramos");
		
		WebElement enterEmail = driver.findElement(By.id("email"));
		enterEmail.sendKeys("Sergioramos@gmail.com");
		
		WebElement enterPassword = driver.findElement(By.id("password"));
		enterPassword.sendKeys("Sergiomail4");
		
		WebElement enterPhone = driver.findElement(By.id("phone"));
		enterPhone.sendKeys("7904706872");
		
		WebElement enterDOB = driver.findElement(By.id("dob"));
		enterDOB.sendKeys("30.03.1985");
		
		WebElement selectGender = driver.findElement(By.id("male"));
		selectGender.click();
		
		WebElement selectSkills = driver.findElement(By.id("selenium"));
		selectSkills.click();
		
		WebElement selectSkills2 = driver.findElement(By.id("manual"));
		selectSkills2.click();
		
		WebElement selectDept = driver.findElement(By.id("department"));
		Select dept = new Select(selectDept);
		dept.selectByIndex(1);
		
		WebElement selectCountry = driver.findElement(By.id("country"));
		Select country = new Select(selectCountry);
		country.selectByIndex(3);
		
		WebElement enterAddress = driver.findElement(By.id("address"));
		enterAddress.sendKeys("Santiago Bernabeu, Madrid");
		
		WebElement clickRegister = driver.findElement(By.id("submitBtn"));
		clickRegister.click();
		
		driver.findElement(By.id("simplealert")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		
		driver.findElement(By.id("confirmButton")).click();
		Alert confirmAlert = driver.switchTo().alert();
		System.out.println(confirmAlert.getText());
		confirmAlert.accept();


		// -------- Prompt Alert --------
		driver.findElement(By.id("promptButton")).click();
		Alert promptAlert = driver.switchTo().alert();
		System.out.println(promptAlert.getText());
		promptAlert.sendKeys("Aarthi");
		promptAlert.accept();
		
		
		try {
		TakesScreenshot ts = (TakesScreenshot) driver;
	    File source = ts.getScreenshotAs(OutputType.FILE);
	    
	    File dest = new File("C:\\Users\\Aarthi G\\OneDrive\\Desktop\\Java-Eclipse\\newScreenshHots36.png");
	    
	    
	    Files.copy(source.toPath(), dest.toPath());
	    
	    System.out.println("Screenshot saved succesfully");
		
	    } catch(IOException e) {
	    	System.out.println("Error while saving screeshot");
	    	e.printStackTrace();
	    	
	    }
		
		try {
			TakesScreenshot gs = (TakesScreenshot) driver;
			File sourcefile = gs.getScreenshotAs(OutputType.FILE);
			
			File destination = new File("C:\\Users\\\\Aarthi G\\OneDrive\\Desktop\\Java-Eclipse\\newScreTenshs4.png");
			
			Files.copy(sourcefile.toPath(), destination.toPath());
			
			System.out.println("Screenshot saveed");
			
		}catch(IOException e){
			System.out.println("Error");
			e.printStackTrace();
		}
		
		try {
			TakesScreenshot ss = (TakesScreenshot) driver;
			File src = ss.getScreenshotAs(OutputType.FILE);
			
			File desti = new File("C:\\Users\\Aarthi G\\OneDrive\\Desktop\\Java-Eclipse\\newfileFFsssss.png");
			
			Files.copy(src.toPath(), desti.toPath());
			
			System.out.println("3rd SS saved");
		
		} catch(IOException e) {
			System.out.println("Error when taking screenshot");
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			
			File destination = new File("C:\\Users\\Aarthi G\\OneDrive\\Desktop\\Java-Eclipse\\new.png");
			
			Files.copy(source.toPath(), destination.toPath());
			
			System.out.println("Ss saved succesfully");
			
			
		} catch(IOException e) {
			System.out.println("Error when taking screenshot");
			e.printStackTrace();			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			
	}
		
}
