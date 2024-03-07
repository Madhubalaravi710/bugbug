package com.test.cucumber.StepDefinition;

import org.apache.log4j.Logger;
import com.test.common.exception.POMEventException;
import com.test.common.exception.POMPageException;
import com.test.common.listeners.FireEvent;
import com.test.pom.common.PomEventsMethodDefinition;
import com.test.pom.pages.input.Pg02_NewProjectPage;
import cucumber.api.java.en.Then;


public class Pg02_NewProjectCreationPageSD extends PomEventsMethodDefinition
{
	
	public static Logger scenariolog = Logger.getLogger("ScenarioLog");
	public static Logger errorlog = Logger.getLogger("ErrorLog");
	FireEvent FireEventobject = new FireEvent();
	Pg02_NewProjectPage NewProjectpage = new Pg02_NewProjectPage();

	

	@Then("^user enters \"([^\"]*)\" and \"([^\"]*)\" to create new Project$")
	public void createNewProject(String projectNameValue, String HomePageURLValue) throws Throwable 
	{		
		try
		{
			NewProjectpage.clickNewProjectButton();
			NewProjectpage.enterProjectName(projectNameValue);	
			NewProjectpage.enterHomeURL(HomePageURLValue);
			NewProjectpage.clickCreateProjectButton();
			
		}
		catch(POMEventException e)
		{
			try 
			{
				FireEventobject.takeScreenshot();
			} 
			catch (POMEventException e1) 
			{
				errorlog.info("Error in Taking ScreenShot in new Project creation Page", e1);
				throw new POMPageException("Error in Taking ScreenShot in Bugbug new Project creation Page", e1);				
			}
			errorlog.info("Error in Bugbug new Project creation page", e);
			throw new POMPageException("Error in new Project creation Page", e);
		}		
		scenariolog.info("New Project has been created in Bugbug");
	}
	
	
	
}
