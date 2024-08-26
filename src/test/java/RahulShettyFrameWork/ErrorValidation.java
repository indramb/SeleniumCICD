package RahulShettyFrameWork;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import components.BaseTest;

public class ErrorValidation extends BaseTest
{
	@Test(groups= {"ErrorHanlding"})
	public void submitOrder() throws IOException
	{
		LandingPage landing = launchApplication();
		
		landing.login("indramb1234@gmail.com","73535429r@Ip");
		Assert.assertEquals("The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.",landing.errorHandling());
	}

}
