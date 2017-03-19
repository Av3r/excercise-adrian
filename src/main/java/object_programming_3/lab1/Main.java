package object_programming_3.lab1;

import object_programming_3.lab1.service.Service;
import object_programming_3.lab1.ui.controller.CityInfoController;
import object_programming_3.lab1.ui.model.CityInfoModel;

public class Main {

    public static void main(String[] args) {
        Service s = new Service("Poland");
        String weatherJson = s.getWeather("Warsaw");
        Double rate1 = s.getRateFor("USD");
        Double rate2 = s.getNBPRate();
        // ...
        CityInfoModel model = new CityInfoModel(weatherJson,rate1,rate2,"Warsaw");
        CityInfoController controller = new CityInfoController(model);
        controller.showCityInfoFrame();
    }

}
