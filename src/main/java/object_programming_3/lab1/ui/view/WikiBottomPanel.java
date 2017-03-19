package object_programming_3.lab1.ui.view;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

public class WikiBottomPanel extends JFXPanel {

    private static final String WIKI_BASE_URL = "https://en.wikipedia.org/wiki/";

    public void showWikiPage(String city){
        Platform.runLater(() -> {
            WebView webView = new WebView();
            setScene(new Scene(webView));
            webView.getEngine().load(WIKI_BASE_URL + city);
        });
    }

}
