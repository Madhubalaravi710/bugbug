package com.test.common.listeners;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class LogListener implements Listener
{
    public static Logger eventlog = Logger.getLogger("SeleniumEventLog");
    public void beforeClickElement(WebElement element) 
    {
        eventlog.info("WebElement is about to be clicked = "+element);
    }
  
    public void afterClickElement() 
    {
        eventlog.info("WebElement is clicked");
    }
    
    public void beforeDropdown() 
    {
        eventlog.info("Dropdown value is about to be selected");
    }
  
    public void afterDropdown() 
    {
        eventlog.info("Dropdown value is selected");
    }
   
    public void beforeEnterTextWithoutEnter() 
    {
        eventlog.info("Text value is about to be entered without enter");
    }
  
    public void afterEnterTextWithoutEnter() 
    {
        eventlog.info("Text value is entered without enter");
    }
    
    public void beforeTakeScreenShot() 
    {
        eventlog.info("Before taking screenshot");
    }
    
    public void afterTakeScreenShot() 
    {
        eventlog.info("Screenshot taken");
    }
    
	public void beforeScreenShot() 
	{
		eventlog.info("Before Taking Screenshot");
	}
	
	public void afterScreenShot() 
	{
		eventlog.info("After Taking Screenshot");
	}
	
	public void beforeThreadWait()
	{
		eventlog.info("Before Thread Wait");
	}
	
	public void afterThreadWait()
	{
		eventlog.info("After Thread Wait");
	}
	
	public void beforeSyncWait()
	{
		eventlog.info("Before Sync Wait");
	}
	
	public void afterSyncWait()
	{
		eventlog.info("After Sync Wait");
	}
	
	 public void onException(Throwable throwable) 
	  {
	        throwable.getStackTrace();
	        eventlog.error(throwable);
	    }
	 
		public void onError(Exception e) 
		{
			eventlog.info("Error Message :::::::::");
			eventlog.info(e.getMessage());
			eventlog.info("Error Cause :::::::::");
			eventlog.info(e.getCause());
		}
}
 