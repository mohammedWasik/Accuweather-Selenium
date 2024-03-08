package Accuweather_BDD.stepdefinitions;

import Accuweather_BDD.pages.CityPage;
import Accuweather_BDD.utils.JsonToObject;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import static io.qameta.allure.Allure.step;


public class CityPageSteps {
    CityPage cityPage = new CityPage();

    @Then("the city weather page header should contain the selected recent city name")
    public void the_city_weather_page_header_should_contain_the_selected_recent_city_name() {
        step("checking if the names of the recent cities are same");
        String cityExpected = JsonToObject.getEnvData().getRecentCity();
        String cityActual = cityPage.getCityName();
        Assert.assertEquals(cityActual,cityExpected,"city names are not equal");
    }
    @Then("the city weather page header should contain the city name {string}")
    public void the_city_weather_page_header_should_contain_the_city_name(String string) {
        step("checking if the names of the typed cities are same");
        String cityExpected = JsonToObject.getEnvData().getCity();
        String cityActual = cityPage.getCityName();
        Assert.assertEquals(cityActual,cityExpected,"city names are not equal");
    }

}
