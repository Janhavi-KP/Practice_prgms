package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoSuchElementException;

public class prgm1 {

	public static void main(String[] args) {
		        WebDriver driver = new ChromeDriver();
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		        try {
		            // Open website
		            driver.get("https://www.saucedemo.com/");
		            driver.manage().window().maximize();

		            // Login
		            driver.findElement(By.id("user-name")).sendKeys("standard_user");
		            driver.findElement(By.id("password")).sendKeys("secret_sauce");
		            driver.findElement(By.id("login-button")).click();

		            // Verify login success
		            WebElement productLabel = driver.findElement(By.className("title"));
		            if (productLabel.getText().equals("Products")) {
		                System.out.println("Login successful!");
		            } else {
		                System.out.println("Login failed!");
		            }

		            // Logout
		            driver.findElement(By.id("react-burger-menu-btn")).click();
		            driver.findElement(By.id("logout_sidebar_link")).click();

		            // Verify logout success
		            if (driver.findElement(By.id("login-button")).isDisplayed()) {
		                System.out.println("Logout successful!");
		            } else {
		                System.out.println("Logout failed!");
		            }

		        } catch (NoSuchElementException e) {
		            System.out.println("Element not found: " + e.getMessage());
		        } finally {
		            // Close browser
		            driver.quit();
		        }
		    }
		}
/*
Open the browser and navigate to SauceDemo.
Enter valid credentials:
Username: standard_user
Password: secret_sauce
Click the Login button.
Verify that the user has successfully logged in by checking if the Products page is displayed.
Logout from the application and verify if the login page appears again */
