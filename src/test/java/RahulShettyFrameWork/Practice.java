package RahulShettyFrameWork;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {

	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

		
//		WebDriverWait driver2=new WebDriverWait(driver,20);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jb2xsZWN0aW9ucy95b2dhLW5ldy5odG1s/");
		driver.findElement(By.id("email")).sendKeys("indramb1234@gmail.com");
		driver.findElement(By.xpath("//input[@title='Password']")).sendKeys("73535429@Ip");
		driver.findElement(By.xpath("//button[@class='action login primary']")).click();
//		driver.findElement(By.xpath("//div[contains(@class,'product-item-info')]//button")).click();
//		driver.findElement(By.cssSelector(".item.product.product-item")).click();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,450)");
		
//		JavascriptExecutor jsExec = (JavascriptExecutor) driver;
//		jsExec.executeScript("document.getElementById('id').scrollTop += 100");
		
//		WebElement ele =driver.findElement(By.xpath("//div[contains(@class,'product-item-info')]"));

//		WebElement i=		driver.findElement(By.xpath("//div[contains(@class,'product-item-info')]//button"));
//		wait.until(ExpectedConditions.elementToBeClickable(i));
//		driver.findElement(By.xpath("//div[contains(@class,'product-item-info')]//div//button")).click();
//String temp	=	driver.findElement(By.xpath("//div[contains(@class,'product-item-info')]//div//strong/a")).getText();
//System.out.println(temp);	
		List<WebElement> item=driver.findElements(By.xpath("//div[contains(@class,'product-item-info')]//div//strong"));
//		Actions action = new Actions(driver);
		WebElement prod=item.stream().filter(product->product.findElement(By.cssSelector("a")).getText()
				.equals("Echo Fit Compression Short")).findFirst().orElse(null); 
		Actions action = new Actions(driver);
		action.moveToElement(prod).build().perform();
		WebDriverWait waitt=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		prod.findElement(By.xpath("//div[contains(@class,'product-item-info')]//button")).click();
		Thread.sleep(10000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,550)");
//		waitt.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='swatch-attribute size']//div[@class='swatch-option text']")));
		driver.findElement(By.xpath("//div[@class='swatch-attribute size']//div[@class='swatch-option text']")).click();
		;
//		System.out.println("size"+temp1);
		driver.findElement(By.xpath("//div[@class='swatch-attribute color']//div[@class='swatch-option color']")).click();
		
		driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();
		Thread.sleep(9000);
String suuccessmsg =	driver.findElement(By.xpath("//div[@role='alert']")).getText();
		System.out.println("success msg  "+suuccessmsg);
	
	}

}
