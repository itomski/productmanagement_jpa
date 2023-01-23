package de.lubowiecki.productmanagement;

import java.io.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(value = {"", "/products"})
public class ProductServlet extends HttpServlet {

    private ProductRepository repository = new ProductRepository();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        /*
        Product p = new Product("Handschuhe", "100% Wolle", 19.99);
        repository.save(p);
        System.out.println(p.getId());
         */



        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        repository.find(100).ifPresent((p) ->  {
            out.println("<h1>" + p.getName() + "</h1>");
            out.println("<p>" + p.getDescription() + "</p>");
            out.println("<p>Preis: " + p.getPrice() + " EUR</p>");
        });

        out.println("</body></html>");
    }
}