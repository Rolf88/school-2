/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RolfMoikjær
 */
@WebServlet(name = "Servlet1", urlPatterns = {"/api/quote/*"})
public class Servlet1 extends HttpServlet {

    private Map<Integer, String> quotes = new HashMap() {
        {
            put(1, "Friends are kisses blown to us by angels");
            put(2, "Do not take life too seriously. You will never get out of it alive");
            put(3, "Behind every great man, is a woman rolling her eyes");
        }
    };

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String[] parts = request.getRequestURI().split("/");
//        String parameter = null;
//        if (parts.length == 5) {
//            parameter = parts[4];
//        }
//
//        JsonObject quote = new JsonObject();
//        int key = 1; //Get the second quote
//        quote.addProperty("quote", quotes.get(key));
//        String jsonResponse = new Gson().toJson(quote);
//
//        try (PrintWriter out = response.getWriter()) {
//
//            out.println(jsonResponse);
//        }
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Random ran = new Random();

        String[] parts = request.getRequestURI().split("/");
        String parameter = null;
        if (parts.length == 5) {
            parameter = parts[4];
        }

        JsonObject quote = new JsonObject();
        int key = ran.nextInt(3) + 1; //Get a random quote
        quote.addProperty("quote", quotes.get(key));
        String jsonResponse = new Gson().toJson(quote);

//        try (PrintWriter out = response.getWriter()) {
//
//            out.println(jsonResponse);
//        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Scanner jsonScanner = new Scanner(request.getInputStream());
        String json = "";
        while (jsonScanner.hasNext()) {
            json += jsonScanner.nextLine();
        }
        //Get the quote text from the provided Json
        JsonObject newQuote = new JsonParser().parse(json).getAsJsonObject();
        String quote = newQuote.get("quote").getAsString();
        Integer nextId = quotes.size();
        quotes.put(nextId++, quote);
        try (PrintWriter out = response.getWriter()) {

            out.println(quotes.get(3));
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Scanner jsonScanner = new Scanner(request.getInputStream());
        String json = "";
        while (jsonScanner.hasNext()) {
            json += jsonScanner.nextLine();
        }
        //Get the quote text from the provided Json
        JsonObject newQuote = new JsonParser().parse(json).getAsJsonObject();
        String quote = newQuote.get("quote").getAsString();
        Integer id = 2;
        quotes.put(id, quote);
        try (PrintWriter out = response.getWriter()) {

            out.println(quotes.get(2));
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Scanner jsonScanner = new Scanner(request.getInputStream());
        String json = "";
        while (jsonScanner.hasNext()) {
            json += jsonScanner.nextLine();
        }

        JsonObject newQuote = new JsonParser().parse(json).getAsJsonObject();
        int key = newQuote.get("key").getAsInt();

        quotes.remove(key);

        try (PrintWriter out = response.getWriter()) {

            out.println(quotes.size());
        }
    }
}
