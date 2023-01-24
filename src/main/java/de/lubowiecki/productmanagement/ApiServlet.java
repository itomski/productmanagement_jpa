package de.lubowiecki.productmanagement;

import java.io.*;
import java.util.List;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(value = "/api")
public class ApiServlet extends HttpServlet {

    private ProductRepository repository = new ProductRepository();
    private Gson gson = new Gson();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        List<Product> products;
        final String search = request.getParameter("s");

        if(search != null) {
            products = repository.find(search);
        }
        else {
            products = repository.find();
        }

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        // Übersetzt die Produkt-Liste in JSON
        response.getWriter().write(gson.toJson(products));
    }
}