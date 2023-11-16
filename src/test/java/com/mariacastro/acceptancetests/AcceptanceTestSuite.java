package com.mariacastro.acceptancetests;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/", glue = "com.mariacastro", tags = "@smoke")
public class AcceptanceTestSuite {
}
