package object_programming_3.lab1.service;

public class Service {

    private String country;

    private OpenWeatherService openWeatherService;

    public Service(String country) {
        this.country = country;
        this.openWeatherService = new OpenWeatherService();
    }

    public String getWeather(String city) {
        return openWeatherService.getWeatherFor(city);
    }

    public Double getRateFor(String currency) {
        return -1.0;
    }

    public Double getNBPRate() {
        return -2.0;
    }
}
