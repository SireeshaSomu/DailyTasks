package com.employeedirectory;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = { "stepdefinitions" }, plugin = { "pretty",
		"html:target/html", "json:target/report.json" })
public class TestRunner {

}
