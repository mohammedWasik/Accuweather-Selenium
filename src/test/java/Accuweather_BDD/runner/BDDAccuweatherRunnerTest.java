package Accuweather_BDD.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = {"src/test/java/Accuweather_BDD/features"},
        glue = {"Accuweather_BDD.stepdefinitions","Accuweather_BDD.hooks"}
)
public class BDDAccuweatherRunnerTest extends AbstractTestNGCucumberTests {

}

