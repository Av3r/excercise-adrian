package object_programming_2.lab10;

public class Offer {

    private String locale;
    private String country;
    private String startDate;
    private String endDate;
    private String place;
    private String price;
    private String currency;

    public Offer(String locale,
                 String country,
                 String startDate,
                 String endDate,
                 String place,
                 String price,
                 String currency) {
        this.locale = locale;
        this.country = country;
        this.startDate = startDate;
        this.endDate = endDate;
        this.place = place;
        this.price = price;
        this.currency = currency;
    }

    public String getLocale() {
        return locale;
    }

    public String getCountry() {
        return country;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getPlace() {
        return place;
    }

    public String getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "locale='" + locale + '\'' +
                ", country='" + country + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", place='" + place + '\'' +
                ", price='" + price + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
