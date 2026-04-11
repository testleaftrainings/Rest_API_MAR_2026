package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		          features = {"src/test/java/features/servicenow-incident.feature:21"},
		          glue = {"step.defs"},
		          dryRun = false,
		          plugin = {
		        		  "pretty",
		        		  "html:cucumber-reports/result.html",
		        		  "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
		          },
		          tags = ""
		        )
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {

}