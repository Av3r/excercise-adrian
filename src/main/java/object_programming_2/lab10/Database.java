package object_programming_2.lab10;

import com.google.common.collect.Lists;
import object_programming_2.lab10.offer.FormattedOffer;
import object_programming_2.lab10.ui.controller.OfferController;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private final static String USER = "postgres";
    private final static String PASSWORD = "postgres";

    private String url;
    private TravelData travelData;

    public Database(String url, TravelData travelData) {
        this.url = url;
        this.travelData = travelData;
    }

    public void create() {
        try {
            prepareDatabase();
            insertData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void prepareDatabase() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(url, USER, PASSWORD);

        String sqlDrop = "DROP TABLE IF EXISTS OFFER";

        String sqlCreate = "CREATE TABLE IF NOT EXISTS OFFER"
                + "  (ID               SERIAL PRIMARY KEY,"
                + "   COUNTRY          VARCHAR(30),"
                + "   START_DATE       VARCHAR(20),"
                + "   END_DATE         VARCHAR(20),"
                + "   PLACE            VARCHAR(30),"
                + "   AMOUNT           VARCHAR(20),"
                + "   CURRENCY         VARCHAR(10))";

        Statement stmt = connection.createStatement();

        stmt.execute(sqlDrop);
        stmt.execute(sqlCreate);
    }

    private void insertData() throws Exception {
        List<FormattedOffer> allFormattedOffers = travelData.getAllFormatedOffers();

        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(url, USER, PASSWORD);

        for (FormattedOffer offer : allFormattedOffers) {
            String insertTableSQL = "INSERT INTO OFFER"
                    + "(COUNTRY, START_DATE, END_DATE, PLACE, AMOUNT, CURRENCY) VALUES"
                    + "(?,?,?,?,?,?)";

            PreparedStatement statement = connection.prepareStatement(insertTableSQL);
            statement.setString(1, offer.getCountry());
            statement.setString(2, offer.getStartDate());
            statement.setString(3, offer.getEndDate());
            statement.setString(4, offer.getPlace());
            statement.setString(5, offer.getPrice());
            statement.setString(6, offer.getCurrency());
            statement.executeUpdate();
        }
    }

    private List<FormattedOffer> findAll() {
        try {
            List<FormattedOffer> allFormattedOffers = new ArrayList<>();

            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, USER, PASSWORD);

            String query = "SELECT * FROM OFFER";
            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                FormattedOffer formattedOffer = new FormattedOffer(
                        rs.getString("COUNTRY"),
                        rs.getString("START_DATE"),
                        rs.getString("END_DATE"),
                        rs.getString("PLACE"),
                        rs.getString("AMOUNT"),
                        rs.getString("CURRENCY")
                );
                allFormattedOffers.add(formattedOffer);
            }
            return allFormattedOffers;
        } catch (Exception e) {
            e.printStackTrace();
            return Lists.newArrayList();
        }

    }

    public void showGui() {
        SwingUtilities.invokeLater(() -> {
            List<FormattedOffer> formattedOffers = findAll();
            OfferController offerController = new OfferController(formattedOffers);
            offerController.showGui();
        });
    }

}
