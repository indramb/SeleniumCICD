package RahulShettyFrameWork;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage 
{
	WebDriver driver;
	public AddToCartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	By productBy=By.cssSelector("a");
	By addToCart=By.xpath("//div[contains(@class,'product-item-info')]//button");
	By selectsiz=By.xpath("//div[@class='swatch-option text']");
	By selectClr=By.xpath("//div[@class='swatch-option color']");
	@FindBy(xpath="//div[contains(@class,'product-item-info')]//div//strong")
	List<WebElement> list;
	@FindBy(xpath="//div[@class='swatch-attribute size']//div[@class='swatch-option text']")
	WebElement SizeList;
	@FindBy(xpath="//div[@class='swatch-attribute color']//div[@class='swatch-option color']")
	WebElement clrList;
	@FindBy(xpath="//button[@title='Add to Cart']")
	WebElement clicCartbtn;
	public WebElement  getprodName(String products)
	{
		WebElement prod=list.stream().filter(product->product.findElement(productBy).getText()
				.equals(products)).findFirst().orElse(null); 
		return prod;
	}
	public void addProduct(String products)
	{
		WebElement prod=getprodName(products);
		Actions action = new Actions(driver);
		action.moveToElement(prod).build().perform();
		prod.findElement(addToCart).click();
	}
	public void getSize() throws InterruptedException
	{
		Thread.sleep(7000);
		SizeList.click();
//	WebElement sizee=SizeList.stream().filter(siz->siz.findElement(selectsiz).getText().equals(size)).findFirst().orElse(null);
//	return sizee;		
	}
//	public void selectsiz(String size) throws InterruptedException
//	{
//		WebElement sizz=getSize(size);
//		Thread.sleep(6000);
//		sizz.findElement(selectsiz).click();
//	}
	public void getColor() throws InterruptedException
	{
		Thread.sleep(7000);
		clrList.click();
		clicCartbtn.click();
		
//	WebElement sizclr=clrList.stream().filter(siz->siz.findElement(selectClr).getAttribute(attrib).equals(clor)).findFirst().orElse(null);
//	return sizclr;		
	}
//	public void selectclr(String attrib,String clor) throws InterruptedException
//	{
//		WebElement clrr=getColor(attrib,clor);
//		Thread.sleep(6000);
//		clrr.findElement(selectClr).click();
//	}
}
