package servlet.webapi.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlet.webapi.model.Product;
import servlet.webapi.service.ProductService;

import java.io.IOException;

@WebServlet("/product")
public class ProductController extends HttpServlet {
    private final ProductService productService = new ProductService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        productService.save(new Product(null, "test", 30d));
    }
}
