package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class prgm4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
		//valid credentials
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(5000);
		//selecting dropdown low to high
		WebElement LowtoHigh=driver.findElement(By.className("product_sort_container"));
		Select LtoH = new Select(LowtoHigh);
		
		LowtoHigh.click();
		LtoH.selectByContainsVisibleText("Price (low to high)");
		
		//selecting cheapest and expensive product
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']")).click();
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']")).click();
		
		
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		//verifying the least product
		WebElement leastPro= driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Onesie']"));
		if(leastPro.getText().equals("Sauce Labs Onesie"))
		{
			System.out.println("least product only");
		}
		//verifying the expensive product
		WebElement ExpPro= driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Fleece Jacket']"));
		if(ExpPro.getText().equals("Sauce Labs Fleece Jacket"))
		{
			System.out.println("expensive only");
		}
		
		//checkout
		driver.findElement(By.id("checkout")).click();
		driver.findElement(By.id("first-name")).sendKeys("jeba");
		driver.findElement(By.id("last-name")).sendKeys("jebas");
		driver.findElement(By.id("postal-code")).sendKeys("573116");
		driver.findElement(By.id("continue")).click();
		Thread.sleep(3000);
		// clicking the **Finish** button.
		driver.findElement(By.id("finish")).click();
		Thread.sleep(3000);
		//Verify that the checkout was successful by checking for the **"Thank You"** message.  
		WebElement Tq=driver.findElement(By.tagName("h2"));
		//WebElement Tq=driver.findElement(By.xpath("//h2[normalize-space()='Thank you for your order!']"));
		if(Tq.getText().equals("Thank you for your order!"))
		{
			System.out.println("thank you msg is successfull");
		}
		Thread.sleep(3000);
		//logout
				driver.findElement(By.id("react-burger-menu-btn")).click();
		        driver.findElement(By.id("logout_sidebar_link")).click();
		        
		        driver.quit();
	}

}
/*
### **Scenario: Sort Products, Add Multiple Items to Cart, and Complete Checkout**  
#### **Test Steps:**  
1. Open the browser and navigate to [SauceDemo](https://www.saucedemo.com/).  
2. Enter valid credentials:  
   - **Username:** `standard_user`  
   - **Password:** `secret_sauce`  
3. Click the **Login** button.  
4. Sort the products by **Price (Low to High)**.  
5. Add the **cheapest and most expensive** product to the cart.  
6. Navigate to the cart and verify both products are present.  
7. Proceed to **checkout**, enter the required details (**First Name, Last Name, Zip Code**), and continue.  
8. Verify that the correct items are displayed on the checkout page.  
9. Complete the purchase by clicking the **Finish** button.  
10. Verify that the checkout was successful by checking for the **"Thank You"** message.  
11. Logout from the application.  

*/
