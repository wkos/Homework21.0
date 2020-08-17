package pl.wkos.metrics;

public class LengthMetrics {
    private double milimeters;
    private double centimeters;
    private double meters;

    public LengthMetrics() {}

    public LengthMetrics(double milimeters, double centimeters, double meters) {
        this.milimeters = milimeters;
        this.centimeters = centimeters;
        this.meters = meters;
    }

    public double getMilimeters() {
        return milimeters;
    }

    public void setMilimeters(double milimeters) {
        this.milimeters = milimeters;
    }

    public double getCentimeters() {
        return centimeters;
    }

    public void setCentimeters(double centimeters) {
        this.centimeters = centimeters;
    }

    public double getMeters() {
        return meters;
    }

    public void setMeters(double meters) {
        this.meters = meters;
    }

    @Override
    public String toString() {
        return "LengthMetrics{" +
                "milimeters=" + milimeters +
                ", centimeters=" + centimeters +
                ", meters=" + meters +
                '}';
    }
}
