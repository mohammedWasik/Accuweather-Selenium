package Accuweather_BDD.pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.By;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HomePage extends Form {
    private final IElementFactory elementFactory = AqualityServices.getElementFactory();

    private final By PolicyAcceptCLass = By.xpath("//div[contains(@class,'policy-accept')]");
    private final ILabel PolAccept =elementFactory.getLabel(PolicyAcceptCLass,"Policy Banner");

    private  final By InputPAth = By.xpath("//input[contains(@class,'search-input')]");
    private  final ITextBox Input = elementFactory.getTextBox(InputPAth,"Input Field");



    private final By RecentCityXpath = By.xpath("//div[contains(@class,'recent-location-name')][1]");
    private final ILabel RecentCity = elementFactory.getLabel(RecentCityXpath,"Recent City");
    private final By searchBarXpath = By.xpath("//div[contains(@class,'featured-search-bar')]");
    private final ITextBox searchBar = elementFactory.getTextBox(searchBarXpath, "search bar");
    private final By currentLocationXpath = By.xpath("//div[contains(@class,'current-location-result')]");
    private final ILabel currentLocation = elementFactory.getLabel(currentLocationXpath, "current location");

    private final By searchBarResultXpath = By.xpath("//div[contains(@class,'search-results')]");
    private final ILabel searchBarResult = elementFactory.getLabel(searchBarResultXpath,"search results list");

    private final By SearchResultNamePath = By.xpath("//p[contains(@class,'search-bar-result__name')]");
    private final ILabel SearchResultSelectFirst = elementFactory.getLabel(SearchResultNamePath,"search result first list");
    public HomePage() {
        super(By.xpath("//*[contains(@class,'header-logo')]"), "Accuweather HomePage");
    }

    public void clickSearchBar() {
        searchBar.click();
    }

    public boolean currentLocationIsDisplayed() {
        System.out.println("State =======>" + currentLocation.state().isDisplayed());
        return currentLocation.state().isDisplayed();
    }



    public void PolAcceptClick(){
        PolAccept.click();
    }
    public void InputFieldType(String city){
        Input.clearAndType(city);
    }
    public boolean SearchResultExists(){
        SearchResultSelectFirst.state().waitForDisplayed();
        return SearchResultSelectFirst.state().isDisplayed();
    }
    public void  SearchResultClick(){
        SearchResultSelectFirst.click();
    }
    public void clickRecentCity(){
        RecentCity.click();
    }
    public void saveRecentCityName(){
        String AqualityJson = "src/test/resources/bddAccuweather.json";
        try{
            // turning/mapping existing json to jsonObject
            JsonObject jsonObject = JsonParser.parseReader(new FileReader(AqualityJson)).getAsJsonObject();
            // adding name to json
            jsonObject.addProperty("recentCity", RecentCity.getText());
            // writing the changes
            try (FileWriter fileWriter = new FileWriter(AqualityJson)) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                gson.toJson(jsonObject, fileWriter);
            } catch (IOException e) {
                AqualityServices.getLogger().error(e.getMessage());
            }
        }catch (Exception e){
            AqualityServices.getLogger().error(e.getMessage());
        }
    }
public boolean searchBarResultsListsExists(){
      return searchBarResult.state().isDisplayed();
}

}
