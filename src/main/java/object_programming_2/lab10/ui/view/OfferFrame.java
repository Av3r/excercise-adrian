package object_programming_2.lab10.ui.view;

import object_programming_2.lab10.ui.model.OfferTableModel;

import javax.swing.*;

public class OfferFrame extends JFrame {

    private static final String TITLE = "Offers";
    private static final int HEIGHT = 400;
    private static final int WIDTH = 600;

    public OfferFrame(OfferTableModel offerTableModel) {
        setFrameUp();
        initComponents(offerTableModel);
    }

    private void setFrameUp() {
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initComponents(OfferTableModel offerTableModel) {
        JTable offerTable = new JTable(offerTableModel);
        JScrollPane scrollPane = new JScrollPane(offerTable);
        add(scrollPane);
    }

}
