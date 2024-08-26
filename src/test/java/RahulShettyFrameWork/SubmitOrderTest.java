package RahulShettyFrameWork;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import abstracPackage.AbstractComponent;
import components.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest
{
	
	@Test(dataProvider="getdata",groups= {"submitord"})
	public void productValidation(HashMap<String,String> input) throws IOException, InterruptedException
	{
		
		LandingPage landing = launchApplication();
	
	landing.login(input.get("email"),input.get("password"));
	
	AddToCartPage cart=new AddToCartPage(driver);
	cart.addProduct(input.get("prodName"));
	cart.getSize();;
	cart.getColor();
	}
	
	
@DataProvider
public Object[][] getdata() throws IOException
{
	List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\data\\submitOrder.json");
	
	return new Object[][] {{data.get(0)},{data.get(1)}};
}
	
//	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

	
//	WebDriverWait driver2=new WebDriverWait(driver,20);
	
	
//	driver.findElement(By.xpath("//div[contains(@class,'product-item-info')]//button")).click();
//	driver.findElement(By.cssSelector(".item.product.product-item")).click();
//	JavascriptExecutor js = (JavascriptExecutor) driver;
//	js.executeScript("window.scrollBy(0,450)");
	
//	JavascriptExecutor jsExec = (JavascriptExecutor) driver;
//	jsExec.executeScript("document.getElementById('id').scrollTop += 100");
	
//	WebElement ele =driver.findElement(By.xpath("//div[contains(@class,'product-item-info')]"));

//	WebElement i=		driver.findElement(By.xpath("//div[contains(@class,'product-item-info')]//button"));
//	wait.until(ExpectedConditions.elementToBeClickable(i));
//	driver.findElement(By.xpath("//div[contains(@class,'product-item-info')]//div//button")).click();
//String temp	=	driver.findElement(By.xpath("//div[contains(@class,'product-item-info')]//div//strong/a")).getText();
//System.out.println(temp);	
	
//	Actions action = new Actions(driver);
//	WebElement prod=item.stream().filter(product->product.findElement(By.cssSelector("a")).getText()
//			.equals("Echo Fit Compression Short")).findFirst().orElse(null); 
//	Actions action = new Actions(driver);
//	action.moveToElement(prod).build().perform();
//	
//	prod.findElement(By.xpath("//div[contains(@class,'product-item-info')]//button")).click();


}
