package Accuweather_BDD.utils;


import Accuweather_BDD.models.BDDAccuweatherJsonHandler;
import aquality.selenium.browser.AqualityServices;
import com.google.gson.Gson;
import lombok.experimental.UtilityClass;

import java.io.FileReader;

@UtilityClass
public  class JsonToObject {
    public static final String RESOURCE_FILE_PATH = System.getProperty("user.dir")+ "/src/test/resources/";

    private static final String ACCUWEATHER_BDD = RESOURCE_FILE_PATH+"bddAccuweather.json";
    private static Gson gson = new Gson();


    public static BDDAccuweatherJsonHandler getEnvData() {
        try {
            return gson.fromJson(new FileReader(ACCUWEATHER_BDD), BDDAccuweatherJsonHandler.class);
        }catch (Exception e){
            AqualityServices.getLogger().error(e.getMessage());
            throw  new RuntimeException(e.getMessage());
        }

    }
}
