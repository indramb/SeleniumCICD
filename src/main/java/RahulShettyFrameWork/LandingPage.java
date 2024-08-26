package RahulShettyFrameWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstracPackage.AbstractComponent;

public class LandingPage extends AbstractComponent
{
	
		WebDriver driver;
		public LandingPage(WebDriver driver)
		{
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		
		@FindBy(id="email")
		WebElement email;
		@FindBy(xpath="//input[@title='Password']")
		WebElement pswd;
		@FindBy(xpath="//button[@class='action login primary']")
		private WebElement loginButton;
		@FindBy(xpath="//div[@role='alert']")
		WebElement errortext;
		
		
		public void login(String emailid,String password)
		{
			email.sendKeys(emailid);
			pswd.sendKeys(password);
			loginButton.click();
			AddToCartPage cart=new AddToCartPage(driver);
			
		}
		public String errorHandling()
		{
			waitWebForElementToBeAppear(errortext);
			return errortext.getText();
			 
		}
		
		public void goTo()
		{
			driver.get("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jb2xsZWN0aW9ucy95b2dhLW5ldy5odG1s/");
		}

	}


