package Accuweather_BDD.stepdefinitions;

import Accuweather_BDD.pages.HomePage;
import Accuweather_BDD.utils.JsonToObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static io.qameta.allure.Allure.step;

public class HomeSteps {
    HomePage homePage = new HomePage();



    @Given("the Main page is open")
    public void the_Main_page_is_open() {
        step("checking if main page is open");

        Assert.assertTrue(homePage.state().isDisplayed(),"Home Page is not open");
    }
    @When("I consent to data usage")
    public void i_consent_to_data_usage() {
        step("consenting to data usage");
        homePage.PolAcceptClick();
    }
    @When("I input {string} in the search field")
    public void i_input_in_the_search_field(String string) {
        step("typing "+ string +" in the input field");
        homePage.InputFieldType(JsonToObject.getEnvData().getCity());
    }
    @Then("the search results list should be displayed")
    public void the_search_results_list_should_be_displayed() {
        step("checking if search result is open");
        Assert.assertTrue(homePage.searchBarResultsListsExists(), "search result not shown");
    }
    @When("I click on the first search result")
    public void i_click_on_the_first_search_result() {
        step("clicking on the first result");
        homePage.SearchResultClick();
    }
    @When("I choose the first city in {string}")
    public void i_choose_the_first_city_in_Recent_locations(String string) {
        step("choosing the first city in "+string);
        homePage.saveRecentCityName();
        homePage.clickRecentCity();
    }
    @When("I click on the search field")
    public void i_click_on_the_search_field() {
        step("clicking on the search bar");
        homePage.clickSearchBar();
    }
    @Then("the {string} label should be displayed")
    public void the_label_should_be_displayed(String string) {
        step("checking if correct label is displayed");
        Assert.assertTrue(homePage.currentLocationIsDisplayed(),"current location is not displayed");
    }

}
