package object_programming_3.lab1.ui.view;

import javax.swing.*;
import java.awt.*;

public class CityInfoTopPanel extends JPanel {

    private static final int ROWS = 3;
    private static final int COLS = 2;
    private static final int HGAP = 0;
    private static final int VGAP = 10;
    private static final int BORDER_SIZE = 10;

    private JTextArea weatherTf;
    private JTextField rateTf;
    private JTextField nbpRateTf;

    public CityInfoTopPanel() {
        setPanelUp();
        initializeComponents();
    }

    private void setPanelUp() {
        setLayout(new GridLayout(ROWS, COLS, HGAP, VGAP));
        setBorder(BorderFactory.createEmptyBorder(BORDER_SIZE, BORDER_SIZE, BORDER_SIZE, BORDER_SIZE));
    }

    private void initializeComponents() {
        JLabel weatherLbl = new JLabel("Weather:");
        JLabel rateLbl = new JLabel("Rate:");
        JLabel nbpRateLbl = new JLabel("NBP Rate:");

        weatherTf = new JTextArea();
        rateTf = new JTextField();
        nbpRateTf = new JTextField();

        add(weatherLbl);
        add(weatherTf);
        add(rateLbl);
        add(rateTf);
        add(nbpRateLbl);
        add(nbpRateTf);
    }


    public void setWeatherJson(String weatherJson) {
        weatherTf.setText(weatherJson);
    }

    public void setRate(Double rate) {
        rateTf.setText(Double.toString(rate));
    }

    public void setNbpRate(Double nbpRate) {
        nbpRateTf.setText(Double.toString(nbpRate));
    }
}
