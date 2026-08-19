package ScreenshotDemo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotDemo {

    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();

        driver.get("http://127.0.0.1:5500/test.html");

        // Take screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // Destination path
        File destination = new File("C:\\Users\\Aarthi G\\OneDrive\\Desktop\\Java-Eclipse\\screenshotselenium.png");

        // Copy screenshot
        Files.copy(source.toPath(), destination.toPath());

        System.out.println("Screenshot saved successfully");

        
    }
}