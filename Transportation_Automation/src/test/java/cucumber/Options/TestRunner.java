package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(features="src/test/java/features/reports.feature",glue={"stepDefinitions"},plugin="json:target/jsonReports/cucumber-report.json",tags={"@GetWaypointReport"},strict = true)
@RunWith(Cucumber.class)
public class TestRunner {

}

//tags={"@CreatePOI"}

//features="src/test/java/features"