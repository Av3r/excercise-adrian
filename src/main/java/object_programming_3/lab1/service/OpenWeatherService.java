package object_programming_3.lab1.service;

import org.springframework.web.client.RestTemplate;

public class OpenWeatherService {

    //TODO usunac sample jak bedzie APID
    //TODO ogarnac Jackson
    private static final String BASE_URL_FORMAT = "http://samples.openweathermap.org/data/2.5/weather?q=%s&appid=%s";
    private static final String APP_ID = "b1b15e88fa797225412429c1c50c122a1";

    public String getWeatherFor(String city) {
        String url = String.format(BASE_URL_FORMAT, city, APP_ID);
        RestTemplate restTemplate = new RestTemplate();
        String weather = restTemplate.getForObject(url, String.class);
        return weather;
    }
}
