package object_programming_2.lab10;

import object_programming_2.lab10.offer.FormattedOffer;
import object_programming_2.lab10.offer.Offer;
import object_programming_2.lab10.offer.OfferFactory;
import object_programming_2.lab10.parser.CurrencyParser;
import object_programming_2.lab10.translation.CountryTranslation;
import object_programming_2.lab10.translation.PlaceTranslation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    private List<FormattedOffer> allFormatedOffers;

    public TravelData(File dirPath) {
        this.allFormatedOffers = new ArrayList<>();
        this.offerFactory = new OfferFactory();
        this.filePath = Paths.get(dirPath.toString(), DATA_FILE_NAME);
    }

    public List<String> getOffersDescriptionsList(String locale, String dateFormat) {
        try {
            List<String> lines = Files.readAllLines(filePath);
            List<Offer> offers = offerFactory.create(lines);

            return offers.stream()
                    .map(offer -> mapToFormattedOffer(offer, locale, dateFormat))
                    .map(FormattedOffer::toString)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Error while convering data", e);
        }
    }

    private FormattedOffer mapToFormattedOffer(Offer offer, String locale, String dateFormat) {
        String country = translateCountry(offer.getCountry(), offer.getLocale(), locale);
        String startDate = parseToDate(offer.getStartDate(), dateFormat);
        String endDate = parseToDate(offer.getEndDate(), dateFormat);
        String place = translatePlace(offer.getPlace(), offer.getLocale(), locale);
        String price = convertPrice(offer.getPrice(), offer.getLocale(), locale);
        String currency = offer.getCurrency();

        FormattedOffer formattedOffer = new FormattedOffer(country, startDate, endDate, place, price, currency);
        allFormatedOffers.add(formattedOffer);
        return formattedOffer;
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

    private String convertPrice(String price, String actualLocale, String targetLocale) {
        try {
            if ((PL_SHORT_LOCALE.equals(actualLocale) || PL_LOCALE.equals(actualLocale)) && EN_GB_LOCALE.equals(targetLocale)) {
                return CurrencyParser.parseFromPolishToEnglishPrice(price);
            } else if (EN_GB_LOCALE.equals(actualLocale) && PL_LOCALE.equals(targetLocale)) {
                return CurrencyParser.parseFromEnglishToPolishPrice(price);
            } else if (EN_GB_LOCALE.equals(actualLocale)) {
                return price;
            } else {
                return CurrencyParser.parseToPolishPrice(price);
            }
        } catch (ParseException e) {
            throw new RuntimeException("There was an exception while converting currency", e);
        }
    }

    public List<FormattedOffer> getAllFormatedOffers() {
        return allFormatedOffers;
    }
}
