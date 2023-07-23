package runner;

import io.cucumber.testng.CucumberOptions;
import tests.TestBase;

@CucumberOptions (features = "src/test/java/features" 
, glue= {"stepDefinations"}
,plugin = {"pretty","html:target/cucumber-report.html" 
		,"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm","json:target/cucumber-report.json"} 
,tags = "@register")
public class TestRunner extends TestBase 
{

}
