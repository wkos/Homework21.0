package pl.wkos.metrics;

public class MetricsConverter {
    public static LengthMetrics countLength(double value, String metric) {
        LengthMetrics lengthMetrics = new LengthMetrics();
        switch (metric) {
            case "meters":
                lengthMetrics.setMeters(value);
                lengthMetrics.setCentimeters(value * 100);
                lengthMetrics.setMilimeters(value * 1000);
                break;
            case "millimeters":
                lengthMetrics.setMeters(value / 1000);
                lengthMetrics.setCentimeters(value / 10);
                lengthMetrics.setMilimeters(value);
                break;
            case "centimeters":
                lengthMetrics.setMeters(value / 100);
                lengthMetrics.setCentimeters(value);
                lengthMetrics.setMilimeters(value * 10);
                break;
            default:
                System.out.println("Nie podałeś parametru");
        }
        return lengthMetrics;
    }
    public static WeightMetrics countWeight(double value, String metric) {
        WeightMetrics metrics = new WeightMetrics();
        switch (metric) {
            case "kilograms":
                metrics.setkilograms(value);
                metrics.setgrams(value * 1000);
                metrics.setmiligrams(value * 1000000);
                break;
            case "milligrams":
                metrics.setkilograms(value / 1000000);
                metrics.setgrams(value / 1000);
                metrics.setmiligrams(value);
                break;
            case "grams":
                metrics.setkilograms(value / 1000);
                metrics.setgrams(value);
                metrics.setmiligrams(value * 1000);
                break;
            default:
                System.out.println("Nie podałeś parametru");
        }
        return metrics;
    }
}
