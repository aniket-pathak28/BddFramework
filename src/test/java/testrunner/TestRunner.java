package testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="/Demo/src/test/resources/RatesExchange.feature"
		, glue={"testrunner"} 
		,tags = {"@Test3"} )
public class TestRunner {

}
