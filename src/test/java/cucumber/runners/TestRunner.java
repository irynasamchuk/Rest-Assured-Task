package cucumber.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(
        features = "src/test/java/cucumber/features",
        glue = {"cucumber/steps"},
        snippets = SnippetType.CAMELCASE,
        tags = {"API"},
        plugin = {
//                "pretty",
                "html:target/cucumber-reports/advanced-reports",
                "json:target/cucumber-reports/CucumberTestReport.json"
//                "rerun:target/cucumber-reports/rerun.txt"
        })

public class TestRunner extends AbstractTestNGCucumberTests {
}
