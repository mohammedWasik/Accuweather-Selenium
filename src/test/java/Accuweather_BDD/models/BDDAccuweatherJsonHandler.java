package Accuweather_BDD.models;

public class BDDAccuweatherJsonHandler {
    private String protocol;
    private String domain;
    private int  wait;
    private  String city;

    private String recentCity;

    public String getRecentCity() {
        return recentCity;
    }

    public String getProtocol() {
        return protocol;
    }
    public String getDomain() {
        return domain;
    }
    public int getWait() {
        return wait;
    }
    public String getCity() {
        return city;
    }
    public String getHost() {
        return protocol + "://" + domain;
    }

}
