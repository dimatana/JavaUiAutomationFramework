package com.elefant;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/com/elefant/features",
        glue = "com.elefant.stepdefinitions",
        tags = "@run1",
        plugin = {"pretty", "json:target/cucumber-reports/cucumber.json", "html:target/cucumber-reports/cucumber.html"}
)

public class CucumberTestRunner {
}
