package object_programming_2.lab9.controller;

import object_programming_2.lab9.model.Model1;
import object_programming_2.lab9.model.RateModel;
import object_programming_2.lab9.reflect.ReflectionInjector;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Controller {

    private static final String YEARS_TEXT = "LATA";
    private static final String REPLACE_CHAR = ".";
    private static final String REPLACEMENT = ",";
    private static final String RATE_LABEL_PREFIX = "tw";
    private static final int LINES_TO_SKIP = 1;

    private String modelName;
    private Model1 model1;

    public Controller(String modelName) {
        this.modelName = modelName;
        model1 = new Model1();
    }


    public Controller readDataFrom(String fName) {
        try {
            List<String> lines = readAllLines(fName);
            int[] years =  getAllYears(lines);
            List<RateModel> rateModels = getRateModels(lines, years.length);

            ReflectionInjector reflectionInjector = new ReflectionInjector(model1,years,rateModels);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public Controller runModel() {
        return this;
    }

    public void runScriptFromFile(String fname) {

    }

    public void runScript(String script){

    }

    public String getResultsAsTsv() {
        return " ";
    }

    private List<String> readAllLines(String fName) throws IOException {
        Path filePath = Paths.get(fName);
        return Files.readAllLines(filePath);
    }

    private int[] getAllYears(List<String> lines){
        String firstLine = lines.iterator().next();
        Scanner scanner = new Scanner(firstLine);
        scanner.skip(YEARS_TEXT);

        List<Integer> years = new ArrayList<>();
        while (scanner.hasNextInt()){
            years.add(scanner.nextInt());
        }
        return years.stream()
                .mapToInt(Integer::intValue).toArray();
    }

    private List<RateModel> getRateModels(List<String> lines, int years) {
        return lines.stream()
                .skip(LINES_TO_SKIP)
                .map(line -> line.replace(REPLACE_CHAR, REPLACEMENT))
                .map(line -> mapToRateModel(line, years))
                .collect(Collectors.toList());
    }

    private RateModel mapToRateModel(String line, int years) {
        Scanner scanner = new Scanner(line);
        String label = scanner.next();

        List<Double> values = new ArrayList<>();
        while (scanner.hasNextDouble()){
            values.add(scanner.nextDouble());
        }

        if (label.contains(RATE_LABEL_PREFIX) && values.size() < years) {
            extendValues(values, years);
        }

        double[] doubleValues = values.stream()
                .mapToDouble(Double::doubleValue)
                .toArray();
        return new RateModel(label, doubleValues);
    }

    private void extendValues(List<Double> values, int years) {
        double lastValue = values.get(values.size() - 1);
        int howManyToAdd = years - values.size();
        for (int i = 0; i < howManyToAdd; i++) {
            values.add(lastValue);
        }
    }

}
