package object_programming_3.lab1.ui.view;

import javax.swing.*;
import java.awt.*;

public class CityInfoFrame extends JFrame {

    private static final String TITLE = "City Info";
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 1000;

    private CityInfoTopPanel cityInfoTopPanel;
    private WikiBottomPanel wikiBottomPanel;

    public CityInfoFrame() {
        setFrameUp();
        initializeComponents();
    }

    private void setFrameUp() {
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initializeComponents() {
        cityInfoTopPanel = new CityInfoTopPanel();
        wikiBottomPanel = new WikiBottomPanel();

        add(cityInfoTopPanel, BorderLayout.NORTH);
        add(wikiBottomPanel, BorderLayout.CENTER);
    }

    public CityInfoTopPanel getCityInfoTopPanel() {
        return cityInfoTopPanel;
    }

    public WikiBottomPanel getWikiBottomPanel() {
        return wikiBottomPanel;
    }
}
