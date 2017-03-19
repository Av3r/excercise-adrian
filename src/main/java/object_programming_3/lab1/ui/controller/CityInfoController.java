package object_programming_3.lab1.ui.controller;

import object_programming_3.lab1.ui.model.CityInfoModel;
import object_programming_3.lab1.ui.view.CityInfoFrame;
import object_programming_3.lab1.ui.view.CityInfoTopPanel;
import object_programming_3.lab1.ui.view.WikiBottomPanel;

public class CityInfoController {

    private CityInfoModel model;
    private CityInfoFrame cityInfoFrame;

    public CityInfoController(CityInfoModel model) {
        this.model = model;
        initializeComponents();
    }

    private void initializeComponents() {
        cityInfoFrame = new CityInfoFrame();
        setCityInfoToTopPanel();
        setCityToWikiPanel();
    }

    public void showCityInfoFrame() {
        cityInfoFrame.setVisible(true);
    }

    private void setCityInfoToTopPanel() {
        CityInfoTopPanel panel = cityInfoFrame.getCityInfoTopPanel();
        panel.setWeatherJson(model.getWeatherJson());
        panel.setRate(model.getRate());
        panel.setNbpRate(model.getNbpRate());
    }

    private void setCityToWikiPanel() {
        WikiBottomPanel panel = cityInfoFrame.getWikiBottomPanel();
        panel.showWikiPage(model.getCity());
    }
}
