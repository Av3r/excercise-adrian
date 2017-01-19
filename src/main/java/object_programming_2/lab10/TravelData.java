package object_programming_2.lab10;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TravelData {

    private static final String DATA_FILE_NAME = "data.txt";
    private static final String EMPTY = "";
    private static final String PL_SHORT_LOCALE = "pl";
    private static final String PL_LOCALE = "pl_PL";
    private static final String EN_GB_LOCALE = "en_GB";

    private OfferFactory offerFactory;
    private Path filePath;

    public TravelData(File dirPath) {
        this.offerFactory = new OfferFactory();
        this.filePath = Paths.get(dirPath.toString(), DATA_FILE_NAME);
    }

    public List<String> getOffersDescriptionsList(String locale, String dateFormat) {
        try {
            List<String> lines = Files.readAllLines(filePath);
            List<Offer> offers = offerFactory.create(lines);

            return offers.stream()
                    .map(offer -> mapToFormattedOffer(offer, locale, dateFormat))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Error while convering data", e);
        }
    }

    private String mapToFormattedOffer(Offer offer, String locale, String dateFormat) {

        String country = translateCountry(offer.getCountry(), offer.getLocale(), locale);
        String startDate = parseToDate(offer.getStartDate(), dateFormat);
        String endDate = parseToDate(offer.getEndDate(), dateFormat);
        String place = translatePlace(offer.getPlace(), offer.getLocale(), locale);
        String price = offer.getPrice();
        String currency = offer.getCurrency();

        return String.format("%s %s %s %s %s %s",
                country,
                startDate,
                endDate,
                place,
                price,
                currency);
    }

    private String parseToDate(String dateToParse, String dateFormat) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
            Date parsedDate = simpleDateFormat.parse(dateToParse);
            return simpleDateFormat.format(parsedDate);
        } catch (ParseException e) {
            return EMPTY;
        }

    }

    private String translateCountry(String country, String actualLocale, String targetLocale) {
        if ((PL_SHORT_LOCALE.equals(actualLocale) || PL_LOCALE.equals(actualLocale)) && EN_GB_LOCALE.equals(targetLocale)) {
            return CountryTranslation.traslateToEnglish(country);
        } else if (EN_GB_LOCALE.equals(actualLocale) && PL_LOCALE.equals(targetLocale)) {
            return CountryTranslation.translateToPolish(country);
        }
        return country;
    }

    private String translatePlace(String place, String actualLocale, String targetLocale) {
        if ((PL_SHORT_LOCALE.equals(actualLocale) || PL_LOCALE.equals(actualLocale)) && EN_GB_LOCALE.equals(targetLocale)) {
            return PlaceTranslation.translateToEnglish(place);
        } else if (EN_GB_LOCALE.equals(actualLocale) && PL_LOCALE.equals(targetLocale)) {
            return PlaceTranslation.translateToPolish(place);
        }
        return place;
    }
}
