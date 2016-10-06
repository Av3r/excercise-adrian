package object_programming_2.lab1.country_table.ui.model;

import com.google.common.collect.Iterables;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CountryTableModel extends AbstractTableModel {

    private Iterable<String> headers;
    private List<Country> countries;

    public CountryTableModel(Iterable<String> headers, List<Country> countries) {
        this.headers = headers;
        this.countries = countries;
    }

    @Override
    public String getColumnName(int column) {
        String[] headersArray = Iterables.toArray(headers, String.class);
        return headersArray[column];
    }

    @Override
    public int getRowCount() {
        return countries.size();
    }

    @Override
    public int getColumnCount() {
        return Iterables.size(headers);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Country country = countries.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return country.getName();
            case 1:
                return country.getCapital();
            case 2:
                return country.getPopulation();
            case 3:
                return new ImageIcon(country.getImagePath());
            default:
                return null;
        }
    }
}
