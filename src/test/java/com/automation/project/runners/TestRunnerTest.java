package com.automation.project.runners;

import io.cucumber.junit.platform.engine.Cucumber;
import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.*;

//@Suite
@Cucumber
@IncludeEngines("cucumber")
@SelectClasspathResource("features") // caută în src/test/resources/features
@ConfigurationParameter(
        key = Constants.GLUE_PROPERTY_NAME,
        value = "com.automation.project.steps," +
                "com.automation.project.hooks," +
                "com.automation.project.context"
)
@ConfigurationParameter(
        key = Constants.PLUGIN_PROPERTY_NAME,
        value = "pretty, html:target/evidence/cucumber-report/report.html,json:target/cucumber-report/cucumber.json, summary"
)
@ConfigurationParameter(
        key = Constants.FILTER_TAGS_PROPERTY_NAME,
        value = "@LoginFunctionality" // schimbabil ușor
)
public class TestRunnerTest {
}