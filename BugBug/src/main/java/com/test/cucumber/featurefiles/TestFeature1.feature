Feature: BugBug Flow

		@NewProject
		Scenario Outline: To do a Quick Project in BugBug
		
		Given user opens browser "chrome" and enter the "https://app.bugbug.io/sign-in/"
		Then user enter "madhubalaravi710@gmail.com" and "Madhubala@7" and click on login button
		Then user enters "<ProjectName>" and "<HomepageURL>" to create new Project
		Then enter "<NewTestName>" and select Screensize and create test by clicking create test button
		Then enter "<HomepageURL>" page to be tested and click Start Recording button
		Then Add the BugBug Extension to the chrome
		
 Examples:
|	S.No	|			ProjectName  |  HomepageURL     | NewTestName | 
| 1     |     Project1     |http://google.com | Test1       |