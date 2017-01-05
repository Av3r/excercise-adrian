package object_programming_2.lab9.model;

import java.util.Arrays;

public class RateModel {

    private String label;
    private double[] values;

    public RateModel(String label, double[] doubleValues) {
        this.label = label;
        this.values = doubleValues;
    }

    public String getLabel() {
        return label;
    }

    public double[] getValues() {
        return values;
    }

    @Override
    public String toString() {
        return "RateModel{" +
                "label='" + label + '\'' +
                ", values=" + Arrays.toString(values) +
                '}';
    }
}
