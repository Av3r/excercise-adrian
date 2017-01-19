package object_programming_2.lab10.ui.controller;

import object_programming_2.lab10.offer.FormattedOffer;
import object_programming_2.lab10.ui.model.OfferTableModel;
import object_programming_2.lab10.ui.view.OfferFrame;

import java.util.List;

public class OfferController {

    private OfferFrame offerFrame;

    public OfferController(List<FormattedOffer> formattedOffers) {
        OfferTableModel offerTableModel = new OfferTableModel(formattedOffers);
        this.offerFrame = new OfferFrame(offerTableModel);
    }

    public void showGui() {
        offerFrame.setVisible(true);
    }
}
