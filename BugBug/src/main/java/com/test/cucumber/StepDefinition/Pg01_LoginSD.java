package com.test.cucumber.StepDefinition;

import org.apache.log4j.Logger;
import com.test.pom.common.PomEventsMethodDefinition;
import com.test.common.exception.POMEventException;
import com.test.common.exception.POMPageException;
import com.test.common.listeners.FireEvent;
import com.test.pom.common.DriversHandling;
import com.test.pom.pages.input.Pg01_LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Pg01_LoginSD extends PomEventsMethodDefinition
{
	public static Logger scenariolog = Logger.getLogger("ScenarioLog");
	public static Logger errorlog = Logger.getLogger("ErrorLog");
	FireEvent FireEventobject = new FireEvent();
	Pg01_LoginPage loginpage= new Pg01_LoginPage();
	
	@Given("^user opens browser \"([^\"]*)\" and enter the \"([^\"]*)\"$")
	public void userOpenBrowser(String Browser, String URL) throws Throwable
	{
		DriversHandling.initialization(Browser, URL);
		scenariolog.info("BugBug Browser Launched");
	}
	

	@Then("^user enter \"([^\"]*)\" and \"([^\"]*)\" and click on login button$")
	public void SuccessfulLogin(String username,String password) throws POMPageException
	{	
		Pg01_LoginPage loginpage= new Pg01_LoginPage();
		try
		{
			loginpage.enterUserName(username);
			loginpage.enterPwd(password);
			loginpage.clickLoginbtn();	
		}
		catch(POMEventException e)
		{
			try 
			{
				FireEventobject.takeScreenshot();
			} 
			catch (POMEventException e1) 
			{
				errorlog.info("Error in Taking ScreenShot in Bugbug Sign up Page" , e1);
				throw new POMPageException("Error in Taking ScreenShot in Bugbug Sign up Page", e1);				
			}
			errorlog.info("Error in Bugbug Sign up page", e);
			throw new POMPageException("Error in Bugbug Sign up Page", e);
		}		
		scenariolog.info("Signed up in Bugbug");
	}
	
}
