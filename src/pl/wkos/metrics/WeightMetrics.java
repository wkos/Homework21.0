package pl.wkos.metrics;

public class WeightMetrics {
    private double milligrams;
    private double grams;
    private double kilograms;

    public WeightMetrics() {

    }

    public WeightMetrics(double milligrams, double grams, double kilograms) {
        this.milligrams = milligrams;
        this.grams = grams;
        this.kilograms = kilograms;
    }

    public double getmilligrams() {
        return milligrams;
    }

    public void setmiligrams(double miligrams) {
        this.milligrams = miligrams;
    }

    public double getgrams() {
        return grams;
    }

    public void setgrams(double grams) {
        this.grams = grams;
    }

    public double getkilograms() {
        return kilograms;
    }

    public void setkilograms(double kilograms) {
        this.kilograms = kilograms;
    }

    @Override
    public String toString() {
        return "WeightMetrics{" +
                "milligrams=" + milligrams +
                ", grams=" + grams +
                ", kilograms=" + kilograms +
                '}';
    }
}
