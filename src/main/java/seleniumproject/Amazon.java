package seleniumproject;

import java.time.Duration;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.sql.Connection;
import java.sql.PreparedStatement;
import database.DBConnection;

public class Amazon {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

       
        driver.get("https://www.amazon.in");

       
        WebElement searchBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("twotabsearchtextbox")
                )
        );

        searchBox.sendKeys("macbook pro");

        
        WebElement searchButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("nav-search-submit-button")
                )
        );

        searchButton.click();

      
        WebElement clickProduct = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "(//h2[.//span[contains(.,'Apple 2026 MacBook Pro')]]/ancestor::a[1])[1]"
                        )
                )
        );

        String parentWindow = driver.getWindowHandle();

        clickProduct.click();

     
        wait.until(
                ExpectedConditions.numberOfWindowsToBe(2)
        );

      
        Set<String> windows = driver.getWindowHandles();

        for (String window : windows) {

            if (!window.equals(parentWindow)) {

                driver.switchTo().window(window);

                break;
            }
        }

      
        wait.until(
                ExpectedConditions.urlContains("/dp/")
        );

        System.out.println("Current URL: " + driver.getCurrentUrl());

        System.out.println("Page Title: " + driver.getTitle());

        System.out.println(
                "Windows: " + driver.getWindowHandles().size()
        );
        String productUrl = driver.getCurrentUrl();
        String pageTitle = driver.getTitle();

        String productName = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("productTitle")
                )
        ).getText();

        System.out.println("Product Name: " + productName);
        System.out.println("Page Title: " + pageTitle);
        System.out.println("Product URL: " + productUrl);


        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement addToCart = wait1.until(
            ExpectedConditions.elementToBeClickable(
                By.id("add-to-cart-button")
            )
        );

        addToCart.click();

        System.out.println("Add to Cart clicked!");
        String cartStatus = "Added";
        String sql = "INSERT INTO products "
                + "(product_name, page_title, product_url, cart_status) "
                + "VALUES (?, ?, ?, ?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, productName);
            ps.setString(2, pageTitle);
            ps.setString(3, productUrl);
            ps.setString(4, cartStatus);

            ps.executeUpdate();

            System.out.println("Product inserted into MySQL successfully!");

            ps.close();
            con.close();

        } catch (Exception e) {

            e.printStackTrace();
        }


        WebElement addedMessage = wait1.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//h1[normalize-space()='Added to cart']")
                )
        );

        System.out.println(
                "Message: " + addedMessage.getText()
        );

    

        WebElement goToCart = wait1.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(
                                "//a[contains(@href,'sw_gtc') and normalize-space()='Go to Cart']"
                        )
                )
        );

        System.out.println(
                "Go to Cart link found: " + goToCart.isDisplayed()
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                goToCart
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                goToCart
        );

        wait1.until(
                ExpectedConditions.urlContains("/cart")
        );

        System.out.println("Cart page opened successfully!");

        System.out.println(
                "Current URL: " + driver.getCurrentUrl()
        );

      

        WebElement proceedToBuy = wait1.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.name("proceedToRetailCheckout")
                )
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                proceedToBuy
        );

        wait1.until(
                ExpectedConditions.elementToBeClickable(
                        proceedToBuy
                )
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                proceedToBuy
        );

        System.out.println("Proceed to Buy clicked!");

      

        WebElement emailBox = wait1.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("ap_email_login")
                )
        );

        emailBox.sendKeys("aarthiganesan2805@gmail.com");

        System.out.println("Email entered!");

        // Continue button
        WebElement continueButton = wait1.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//span[@id='continue']//input[@type='submit']"
                        )
                )
        );

        continueButton.click();

        System.out.println("Continue clicked!");

       

        WebElement signInAnother = wait1.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//a[contains(@class,'signin-with-another-account')]"
                        )
                )
        );

        signInAnother.click();

        System.out.println(
                "Sign in with another account clicked!"
        );

      
        WebElement email = wait1.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("ap_email_login")
                )
        );

        email.sendKeys("aarthiganesan2805@gmail.com");

        
        WebElement continueButton1 = wait1.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath(
                                "//span[@id='continue']//input[@type='submit']"
                        )
                )
        );

        continueButton1.click();

        System.out.println("Second Continue clicked!");

        WebElement intentionButton = wait1.until(
        	    ExpectedConditions.elementToBeClickable(
        	        By.xpath("//input[@aria-labelledby='intention-submit-button-announce']")
        	    )
        	);

        	((JavascriptExecutor) driver).executeScript(
        	    "arguments[0].click();",
        	    intentionButton
        	);
        	
        	WebElement mobileNumber = wait1.until(
        	        ExpectedConditions.visibilityOfElementLocated(
        	                By.id("ap_phone_number")
        	        )
        	);

        	mobileNumber.sendKeys("8220836053");
        	
        	WebElement firstName = wait1.until(
        	        ExpectedConditions.visibilityOfElementLocated(
        	                By.id("ap_customer_name")
        	        )
        	);

        	firstName.sendKeys("Aarthi");

        	WebElement lastName = wait1.until(
        	        ExpectedConditions.visibilityOfElementLocated(
        	                By.id("ap_customer_name")
        	        )
        	);

        	lastName.sendKeys("Ganesan");

        	System.out.println("First name and Last name entered!");
        	
        	WebElement verifyNumber = wait1.until(
        	        ExpectedConditions.elementToBeClickable(
        	                By.id("continue")
        	        )
        	);

        	verifyNumber.click();

        	System.out.println("Verify Number clicked!");
       
        	WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));

        	System.out.println("Please complete the puzzle manually...");

        
        	WebElement checkbox = wait2.until(
        	        ExpectedConditions.elementToBeClickable(
        	                By.cssSelector("i.a-icon.a-icon-checkbox")
        	        )
        	);

        	System.out.println("Puzzle completed. Checkbox found!");

        	((JavascriptExecutor) driver).executeScript(
        	        "arguments[0].click();",
        	        checkbox
        	);

        	System.out.println("Checkbox clicked successfully!");
        	System.out.println("Checkbox clicked!");
        	
        	WebElement continueButton2 = wait2.until(
        	        ExpectedConditions.elementToBeClickable(
        	                By.xpath("//span[@id='auth-create-account-btn-announce']/..")
        	        )
        	);

        	continueButton2.click();

        	System.out.println("Continue button clicked!");
        	
        	WebElement otp = wait2.until(
        	        ExpectedConditions.elementToBeClickable(
        	                By.xpath("//input[@name='code']")
        	        )
        	);
        	otp.sendKeys("287034");

        	
        	
        
    }
}