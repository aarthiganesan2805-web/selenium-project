package alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alertdemo {

    public static void main(String[] args) {
    	
        WebDriver driver = new ChromeDriver();
        
        driver.get("http://127.0.0.1:5500/index.html");
        
        driver.findElement(By.id("simplealert")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        
    }
}