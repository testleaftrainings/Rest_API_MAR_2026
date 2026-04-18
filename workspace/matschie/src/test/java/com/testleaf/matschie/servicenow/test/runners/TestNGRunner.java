package com.testleaf.matschie.servicenow.test.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		          features = {"src/test/java/com/testleaf/matschie/servicenow/features/incident.feature:15"},
		          glue = {"com.testleaf.matchie.servicenow.steps"},
		          dryRun = false,
		          plugin = {
		        		  "pretty",
		        		  "html:cucumber-reports/result.html",
		        		  "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
		          }
		        )
public class TestNGRunner extends AbstractTestNGCucumberTests {

}
