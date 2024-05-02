package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/assessment.feature", glue = {"steps","assessment.web.ui.utility"},
        monochrome = true,
        dryRun = false,
        plugin = {"pretty", "junit:target/JUnitReports.xml", "json:target/JSONReports", "html:src/test/Reports/HTMLReports.html"}

)
public class TestRunner {
}
