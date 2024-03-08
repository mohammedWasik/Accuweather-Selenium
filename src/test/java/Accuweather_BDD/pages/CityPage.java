package Accuweather_BDD.pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import org.openqa.selenium.By;

public class CityPage {
    private IElementFactory elementFactory = AqualityServices.getElementFactory();

    private final By CityPath = By.xpath("//*[contains(@class,'header-loc')]");
    private final ILabel CityHeader = elementFactory.getLabel(CityPath, "City Name");



    public String getCityName() {
        String[] City = CityHeader.getText().split(",");
        return City[0];
    }


}
