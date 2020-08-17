package pl.wkos.metrics;

import pl.wkos.textstats.TextStats;

public class Main {
    public static void main(String[] args) {
        WeightMetrics metrics = MetricsConverter.countWeight(178,"gram");
        System.out.println(metrics);
        System.out.println(TextStats.numberOfAllSigns("ala ma kota\n\tas"));
        System.out.println(TextStats.numberOfSignsWithoutWhiteSpaces("ala ma kota\n\tas"));
        System.out.println(TextStats.numberOfWords("ala ma kota\n\tas"));
    }
}
