package com.test.cucumber.StepDefinition;

import org.apache.log4j.Logger;
import com.test.common.exception.POMEventException;
import com.test.common.exception.POMPageException;
import com.test.common.listeners.FireEvent;
import com.test.pom.common.PomEventsMethodDefinition;
import com.test.pom.pages.input.Pg04_StartRecordingPage;

import cucumber.api.java.en.Then;

public class Pg04_StartRecordingPageSD extends PomEventsMethodDefinition
{
	public static Logger scenariolog = Logger.getLogger("ScenarioLog");
	public static Logger errorlog = Logger.getLogger("ErrorLog");
	FireEvent FireEventobject = new FireEvent();
	Pg04_StartRecordingPage startRecPage = new Pg04_StartRecordingPage();
	

	
	@Then("^enter \"([^\"]*)\" page to be tested and click Start Recording button$")
	public void createNewTest(String HomePageURL) throws POMPageException, InterruptedException
	{
		try 
		{
			startRecPage.enterURL(HomePageURL);	
			startRecPage.clickStartRecordingButton();
	    }
		catch (POMEventException e) 
		{
			try 
			{
				FireEventobject.takeScreenshot();
			} 
			catch (POMEventException e1) 
			{
				errorlog.info("Error in Taking ScreenShot in Start Recording Page", e1);
				throw new POMPageException("Error in Taking ScreenShot in Bugbug Start Recording Page", e1);				
			}
			errorlog.info("Error in Bugbug Start Recording page", e);
			throw new POMPageException("Error in Start Recording Page", e);
		}		
		scenariolog.info("Recording has been successfully started in Bugbug");
	}
	

}