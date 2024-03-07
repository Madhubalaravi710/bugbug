package com.test.cucumber.StepDefinition;

import java.awt.AWTException;

import org.apache.log4j.Logger;
import com.test.common.exception.POMEventException;
import com.test.common.exception.POMPageException;
import com.test.common.listeners.FireEvent;
import com.test.pom.common.PomEventsMethodDefinition;
import com.test.pom.pages.input.Pg05_AddExtension;

import cucumber.api.java.en.Then;

public class Pg05_AddExtensionPageSD extends PomEventsMethodDefinition
{
	public static Logger scenariolog = Logger.getLogger("ScenarioLog");
	public static Logger errorlog = Logger.getLogger("ErrorLog");
	FireEvent FireEventobject = new FireEvent();
	Pg05_AddExtension AddExtensionpage = new Pg05_AddExtension();
	

	
	@Then("^Add the BugBug Extension to the chrome$")
	public void addExtensionToTheChrome() throws POMPageException, InterruptedException, AWTException
	{
		try 
		{	
			AddExtensionpage.clickgoToChromeWebStoreButton();			
			AddExtensionpage.switchBWtabsAndClickaddToChromeButton();
			AddExtensionpage.clickgoToExtensionSettingButton();
			AddExtensionpage.clickincognitoToggle();
			AddExtensionpage.clickcontinueButton();
	    }
		catch (POMEventException e) 
		{
			try 
			{
				FireEventobject.takeScreenshot();
			} 
			catch (POMEventException e1) 
			{
				errorlog.info("Error in Taking ScreenShot when Adding Extension to the chrome", e1);
				throw new POMPageException("Error in Taking ScreenShot when Adding Extension to the chrome", e1);				
			}
			errorlog.info("Error when Adding Extension to the chrome", e);
			throw new POMPageException("Error when Adding Extension to the chrome", e);
		}		
		scenariolog.info("Extension has been successfully added to the chrome");
	}
	

}