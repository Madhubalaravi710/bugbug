package com.test.cucumber.runnerclass;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = { "html:target/site/cucumber-pretty","json:target/cucumber1.json" }, 
        glue = {"com/test/cucumber/StepDefinition"},
        features = {"src/main/java/com/test/cucumber/featurefiles/TestFeature1.feature"},
        monochrome = true, 
        strict = true,
        dryRun = false,
        tags = {"@NewProject"}           
)

public class TestRunner 
{
	
}
