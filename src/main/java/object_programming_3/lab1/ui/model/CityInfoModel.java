package object_programming_3.lab1.ui.model;

public class CityInfoModel {

    private String weatherJson;
    private Double rate;
    private Double nbpRate;
    private String city;

    public CityInfoModel(String weatherJson, Double rate, Double nbpRate, String city) {
        this.weatherJson = weatherJson;
        this.rate = rate;
        this.nbpRate = nbpRate;
        this.city = city;
    }

    public String getWeatherJson() {
        return weatherJson;
    }

    public Double getRate() {
        return rate;
    }

    public Double getNbpRate() {
        return nbpRate;
    }

    public String getCity() {
        return city;
    }
}
