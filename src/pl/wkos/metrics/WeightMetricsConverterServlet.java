package pl.wkos.metrics;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/WeightMetricsConverter")
public class WeightMetricsConverterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String kilograms = request.getParameter("kilograms");
        String grams = request.getParameter("grams");
        String milligrams = request.getParameter("milligrams");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        if (oneFieldFilled(kilograms, grams, milligrams)) {
            WeightMetrics weightMetrics = getWeightMetrics(kilograms, grams, milligrams);
            writer.println("<h3>" + weightMetrics.getkilograms() + "kg = " +
                    weightMetrics.getgrams() + "g = " +
                    weightMetrics.getmilligrams() + "mg</h3>");
        } else {
            writer.println("<h3>Musi być wypełnione dokłądnie jedno pole</h3>);");
        }
    }

    private WeightMetrics getWeightMetrics(String kilograms, String grams, String milligrams) {
        WeightMetrics weightMetrics;
        if (kilograms != null && !"".equals(kilograms)) {
            weightMetrics = MetricsConverter.countWeight(Double.parseDouble(kilograms), "kilograms");
        } else if (grams != null && !"".equals(grams)) {
            weightMetrics = MetricsConverter.countWeight(Double.parseDouble(grams), "grams");
        } else {
            weightMetrics = MetricsConverter.countWeight(Double.parseDouble(milligrams), "milligrams");
        }
        return weightMetrics;
    }

    private boolean oneFieldFilled(String kilograms, String grams, String milligrams) {
        int numberOfFilledFields = 0;
        if (kilograms != null && !"".equals(kilograms)) {
            numberOfFilledFields++;
        }
        if (grams != null && !"".equals(grams)) {
            numberOfFilledFields++;
        }
        if (milligrams != null && !"".equals(milligrams)) {
            numberOfFilledFields++;
        }
        return numberOfFilledFields == 1;
    }
}
