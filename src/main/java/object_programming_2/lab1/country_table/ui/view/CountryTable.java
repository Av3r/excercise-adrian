package object_programming_2.lab1.country_table.ui.view;

import com.google.common.base.Splitter;
import object_programming_2.lab1.country_table.ui.model.Country;
import object_programming_2.lab1.country_table.ui.model.CountryColumns;
import object_programming_2.lab1.country_table.ui.model.CountryTableModel;

import javax.swing.*;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class CountryTable {

    private static final String SEPARATOR = "\t";

    private CountryTableModel countryTableModel;

    public CountryTable(String countriesFileName) throws IOException {
        Path filePath = Paths.get(countriesFileName);
        List<String> lines = Files.readAllLines(filePath);

        Iterable<String> headers = getHeaders(lines);
        List<Country> countries = getCountries(lines);
        countryTableModel = new CountryTableModel(headers, countries);
    }

    private List<Country> getCountries(List<String> lines) {
        return lines.stream()
                .skip(1)
                .map(this::convertToCountry)
                .collect(Collectors.toList());
    }

    private Country convertToCountry(String line) {
        Iterable<String> elements = Splitter.on(SEPARATOR).split(line);
        Iterator<String> iterator = elements.iterator();
        String name = iterator.next();
        String capital = iterator.next();
        int population = Integer.parseInt(iterator.next());
        String imagePath = iterator.next();
        return new Country(name, capital, population, imagePath);
    }

    private Iterable<String> getHeaders(List<String> lines) {
        return Splitter.on(SEPARATOR).split(lines.get(0));
    }

    //TODO pomyslec nad zaznaczaniem populacji panstw na czerwono
    public JTable create() {
        JTable jTable = new JTable(countryTableModel);
        TableColumnModel columnModel = jTable.getColumnModel();

        TableColumn imageColumn = columnModel.getColumn(CountryColumns.FLAG_INDEX);
        imageColumn.setCellRenderer(jTable.getDefaultRenderer(ImageIcon.class));

        return jTable;
    }
}
