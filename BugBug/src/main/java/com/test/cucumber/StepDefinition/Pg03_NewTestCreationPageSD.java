package com.test.cucumber.StepDefinition;


import org.apache.log4j.Logger;
import com.test.common.exception.POMEventException;
import com.test.common.exception.POMPageException;
import com.test.common.listeners.FireEvent;
import com.test.pom.common.PomEventsMethodDefinition;
import com.test.pom.pages.input.Pg03_NewTestCreationPage;
import cucumber.api.java.en.Then;

public class Pg03_NewTestCreationPageSD extends PomEventsMethodDefinition
{
	public static Logger scenariolog = Logger.getLogger("ScenarioLog");
	public static Logger errorlog = Logger.getLogger("ErrorLog");
	FireEvent FireEventobject = new FireEvent();
	Pg03_NewTestCreationPage NewTestCReation = new Pg03_NewTestCreationPage();
	
	@Then("^enter \"([^\"]*)\" and select Screensize and create test by clicking create test button$")
	public void createNewTest(String TestName) throws POMPageException, InterruptedException
	{
		try 
		{
			NewTestCReation.enterTestName(TestName);	
			//agencypage.selectScreenSize(ScreenSizeValue);
			NewTestCReation.clickCreateTestButton();
	    }
		catch (POMEventException e) 
		{
			try 
			{
				FireEventobject.takeScreenshot();
			} 
			catch (POMEventException e1) 
			{
				errorlog.info("Error in Taking ScreenShot in new Test creation Page", e1);
				throw new POMPageException("Error in Taking ScreenShot in Bugbug new Test creation Page", e1);				
			}
			errorlog.info("Error in Bugbug new Test creation page", e);
			throw new POMPageException("Error in new Test creation Page", e);
		}		
		scenariolog.info("New Test has been created in Bugbug");
	}
	
	
}
