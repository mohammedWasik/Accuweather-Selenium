package Accuweather_BDD.hooks;

import Accuweather_BDD.utils.JsonToObject;
import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

import static io.qameta.allure.Allure.step;

public class Hooks {

    protected Browser browser = AqualityServices.getBrowser();

    @Before
    public void setup() {
        step("get browser");
        browser = AqualityServices.getBrowser();
        step("maximize browser");
        browser.maximize();
        step("go to main page");
        browser.goTo(JsonToObject.getEnvData().getHost());
    }


    @After
    public void teardown(){
        step("close browser");
        browser.quit();

    }
//
//    @After
//    public void teardown(Scenario scenario) {
//        step("close browser");
//
//        // Capture screenshot if the scenario fails
//        if (scenario.isFailed()) {
//            captureScreenshot(scenario.getName());
//        }
//
//        // Quit the WebDriver
//        if (AqualityServices.getBrowser().getDriver() != null) {
//            browser.quit();
//        }
//    }
//
//    private void captureScreenshot(String scenarioName) {
//        try {
//            // Create a 'screenshots' directory if not exists
//            Path screenshotDir = Paths.get("screenshots");
//            if (!Files.exists(screenshotDir)) {
//                Files.createDirectories(screenshotDir);
//            }
//
//            // Generate a screenshot filename based on the scenario name
//            String screenshotFilename = "screenshots/" + scenarioName + "_failure.png";
//
//            // Capture screenshot and save it
//            File screenshotFile = ((TakesScreenshot) AqualityServices.getBrowser().getDriver()).getScreenshotAs(OutputType.FILE);
//            Files.copy(screenshotFile.toPath(), Paths.get(screenshotFilename));
//            System.out.println("Screenshot captured: " + screenshotFilename);
//        } catch (IOException e) {
//            System.err.println("Error capturing screenshot: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
}
