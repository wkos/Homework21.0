package pl.wkos.metrics;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/length-metrics-converter")
public class LengthMetricsConverterServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String meters = request.getParameter("meters");
        String centimeters = request.getParameter("centimeters");
        String millimeters = request.getParameter("millimeters");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        if (oneFieldFilled(meters, centimeters, millimeters)) {
            LengthMetrics lengthMetrics = getLengthMetrics(meters, centimeters, millimeters);

            writer.println("<h3>" + lengthMetrics.getMeters() + "m = " +
                    lengthMetrics.getCentimeters() + "cm = " +
                    lengthMetrics.getMilimeters() + "mm</h3>");
        } else {
            writer.println("<h3>Musi być wypełnione dokłądnie jedno pole</h3>);");
        }
    }

    private LengthMetrics getLengthMetrics(String meters, String centimeters, String millimeters) {
        LengthMetrics lengthMetrics;
        if (meters != null && !"".equals(meters)) {
            lengthMetrics = MetricsConverter.countLength(Double.parseDouble(meters), "meters");
        } else if (centimeters != null && !"".equals(centimeters)) {
            lengthMetrics = MetricsConverter.countLength(Double.parseDouble(centimeters), "centimeters");
        } else {
            lengthMetrics = MetricsConverter.countLength(Double.parseDouble(millimeters), "millimeters");
        }
        return lengthMetrics;
    }

    private boolean oneFieldFilled(String meters, String centimeters, String millimeters) {
        int numberOfFilledFields = 0;
        if (meters != null && !"".equals(meters)) {
            numberOfFilledFields++;
        }
        if (centimeters != null && !"".equals(centimeters)) {
            numberOfFilledFields++;
        }
        if (millimeters != null && !"".equals(millimeters)) {
            numberOfFilledFields++;
        }
        return numberOfFilledFields == 1;
    }
}
