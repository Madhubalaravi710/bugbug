package com.test.common.listeners;

import java.io.IOException;
import java.util.LinkedList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.test.common.exception.POMEventException;
import com.test.pom.common.PomEventsMethodDefinition;
import com.test.pom.common.PomEvents;


	public class FireEvent implements PomEvents
	{
	 protected static PomEvents pomevents = null;
	 protected static Listener listener = null; 
	 protected LinkedList<Listener> listeners1 = new LinkedList<Listener>();
	 
	public FireEvent()
	{
		pomevents = new PomEventsMethodDefinition();
		listener = new LogListener();
		listeners1.add((Listener) listener);
	}
	
	public void addListener(Listener listener)
	{
    listeners1.add((Listener) listener);
	}
	
	public boolean removeListener(Listener listener)
	{
	    return listeners1.remove(listener);
	}
	
	public void ClickElement(WebElement element) throws POMEventException 
	{
		for (Listener listen : listeners1)
            listen.beforeClickElement(element);
		try
		{
        pomevents.ClickElement(element);
		}
		catch(POMEventException e)
        {
            for (Listener listen : listeners1)
                listen.onError(e);
            throw new POMEventException(e);
        }
		
        for (Listener listen : listeners1)
            listen.afterClickElement();
	}
	
	public void switchBetweenTabs(String Tab) throws POMEventException 
	{
		pomevents.switchBetweenTabs(Tab);
	}

	public void Dropdown(WebElement element, String value) throws POMEventException 
	{
		for (Listener listen : listeners1)
            listen.beforeDropdown();
        try
        {
        	pomevents.Dropdown(element, value);
        }
        catch(POMEventException e)
        {
            for (Listener listen : listeners1)
                listen.onError(e);
            throw new POMEventException(e);
        }
        for (Listener listen : listeners1)
            listen.afterDropdown();
	}

	
	public void EnterTextWithoutEnter(WebElement element, String value) throws POMEventException 
	{
		for (Listener listen : listeners1)
            listen.beforeEnterTextWithoutEnter();
        try
        {
        	pomevents.EnterTextWithoutEnter(element, value);
        }
        catch(POMEventException e)
        {
            for (Listener listen : listeners1)
                listen.onError(e);
            throw new POMEventException(e);
        }
        for (Listener listen : listeners1)
            listen.afterEnterTextWithoutEnter();
	}
	
	
	public void takeScreenShot() throws IOException, POMEventException 
	{
		for (Listener listen : listeners1)
            listen.beforeTakeScreenShot();
        try
        {
        	pomevents.takeScreenShot();
        }
        catch(POMEventException e)
        {
            for (Listener listen : listeners1)
                listen.onError(e);
            throw new POMEventException(e);
        }
        for (Listener listen : listeners1)
            listen.afterTakeScreenShot();
	}

	public void takeScreenshot() throws POMEventException 
	{
		for (Listener listen : listeners1)
            listen.beforeScreenShot();
        try
        {
        	pomevents.takeScreenshot();
        }
        catch(POMEventException e)
        {
            for (Listener listen : listeners1)
                listen.onError(e);
            throw new POMEventException(e);
        }
        for (Listener listen : listeners1)
            listen.afterScreenShot();
		
	}

	public void SyncWait(int time) throws POMEventException
	{
		for (Listener listen : listeners1)
            listen.beforeSyncWait();
        try
        {
        	pomevents.SyncWait(time);
        }
        catch(POMEventException e)
        {
            for (Listener listen : listeners1)
                listen.onError(e);
            throw new POMEventException(e);
        }
        for (Listener listen : listeners1)
            listen.afterSyncWait();
		
	}

	public void ThreadWait(int time) throws POMEventException 
	{
		for (Listener listen : listeners1)
            listen.beforeThreadWait();
        try
        {
        	pomevents.ThreadWait(time);
        }
        catch(POMEventException e)
        {
            for (Listener listen : listeners1)
                listen.onError(e);
            throw new POMEventException(e);
        }
        for (Listener listen : listeners1)
            listen.afterThreadWait();
	}

	public void JSToggleBox(WebElement incognitoToggle, WebDriver Driver1) throws POMEventException 
	{
		pomevents.JSToggleBox(incognitoToggle, Driver1);
	}
		
}
