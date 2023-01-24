package de.lubowiecki.productmanagement;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(value = {"", "/products"})
public class ProductServlet extends HttpServlet {

    private ProductRepository repository = new ProductRepository();


    // Direkter aufruf der URL (/products) mit GET. Übersicht der Produkte
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Die aufgerufenen URL entscheiden darüber, was das Servlet macht

        // Parameter aus der URL lesen
        final String action = request.getParameter("a");

        if(action != null && action.equals("form")) { // Formular
            getServletContext().getRequestDispatcher("/WEB-INF/form.jsp").forward(request, response);
        }
        else { // Auflistung der Produkte
            final String search = request.getParameter("s"); // Einlesen von Suchparametern
            if(search != null) {
                request.setAttribute("products", repository.find(search));
            }
            else {
                request.setAttribute("products", repository.find());
            }
            getServletContext().getRequestDispatcher("/WEB-INF/list.jsp").forward(request, response);
        }
    }

    // Verarbeitung der Formulardaten (POST)
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        final String name = request.getParameter("name");
        final String description = request.getParameter("description");
        final double price = Double.parseDouble(request.getParameter("price"));

        repository.save(new Product(name, description, price)); // Speichern

        response.sendRedirect("products"); // Auf die Übersicht umleiten
    }
}