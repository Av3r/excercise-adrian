package object_programming_2.lab10.ui.model;

import object_programming_2.lab10.offer.FormattedOffer;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class OfferTableModel extends AbstractTableModel {

    private List<FormattedOffer> formattedOffers = new ArrayList<>();

    public OfferTableModel(List<FormattedOffer> formattedOffers) {
        this.formattedOffers = formattedOffers;
    }

    @Override
    public int getRowCount() {
        return formattedOffers.size();
    }

    @Override
    public int getColumnCount() {
        return getColumnLabels().length;
    }

    @Override
    public String getColumnName(int column) {
        return getColumnLabels()[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return formattedOffers.get(rowIndex).getCountry();
            case 1:
                return formattedOffers.get(rowIndex).getStartDate();
            case 2:
                return formattedOffers.get(rowIndex).getEndDate();
            case 3:
                return formattedOffers.get(rowIndex).getPlace();
            case 4:
                return formattedOffers.get(rowIndex).getPrice();
            case 5:
                return formattedOffers.get(rowIndex).getCurrency();
            default:
                return "";
        }
    }

    private String[] getColumnLabels() {
        return new String[]{
                "Kraj",
                "Data wyjazdu",
                "Data powrotu",
                "Miejsce",
                "Cena",
                "Symbol"
        };
    }
}
