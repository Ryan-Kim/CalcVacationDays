package com.funny;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;


public class CalcVacationDays extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String earnDaysStr = req.getParameter("earnDays");
        String carriedDaysStr = req.getParameter("carriedDays");
        String spentDaysStr = req.getParameter("spentDays");

        int earnDays = Integer.parseInt(earnDaysStr);
        int carriedDays = Integer.parseInt(carriedDaysStr);
        int spentDays = Integer.parseInt(spentDaysStr);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, -1);
        int month = cal.get(Calendar.MONTH);
        double rate = earnDays / 12;
        double remainingDays = rate * month + carriedDays - spentDays;
        int remainingDaysByThisYear = earnDays + carriedDays - spentDays;

        PrintWriter out = res.getWriter();
        out.println (
                "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" +" +
                        "http://www.w3.org/TR/html4/loose.dtd\">\n" +
                        "<html> \n" +
                        "<head> \n" +
                        "<meta http-equiv=\"Content-Type\" content=\"text/html; " +
                        "charset=ISO-8859-1\"> \n" +
                        "<title> Remaining Vacation Days  </title> \n" +
                        "</head> \n" +
                        "<body> <div align='center'> \n" +
                        "<style= \"font-size=\"12px\" color='black'\"" + "\">" +
                        "Currently " + remainingDays + " days are available <br> " +
                        remainingDaysByThisYear + " days are available by the end of this year" +
                        "</font></body> \n" +
                        "</html>"
        );
    }

}