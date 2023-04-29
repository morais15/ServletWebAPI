package servlet.webapi.controller;

import com.google.gson.Gson;
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
    private final Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        req.getReader().lines().forEach(sb::append); //get fields from post body

        Product product = gson.fromJson(sb.toString(), Product.class);
        productService.save(product);
    }
}
