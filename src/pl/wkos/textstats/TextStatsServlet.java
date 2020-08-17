package pl.wkos.textstats;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/text-stats")
public class TextStatsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text = request.getParameter("text");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        writer.println("<p>" + text + "</p>" +
                "<h2>Ilość słów: " + TextStats.numberOfWords(text) + "</h2>" +
                "<h2>Ilość znaków: " + TextStats.numberOfAllSigns(text) + "</h2>" +
                "<h2>Ilość znaków (bez spacji): " + TextStats.numberOfSignsWithoutWhiteSpaces(text) + "</h2>" +
                "<h2>Palindrom: " + TextStats.palindrom(text) + "</h2>");
    }
}
