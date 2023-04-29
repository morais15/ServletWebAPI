package servlet.webapi.service;

import servlet.webapi.config.DBConfig;
import servlet.webapi.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductService {
    private Connection connection = null;

    public void save(Product product) {
        if (connection == null)
            connection = DBConfig.getConnection();

        PreparedStatement preparedStatement;
        try {
            String query = "INSERT INTO products (id, description, price) VALUES (?, ?, ?)";
            System.out.println("Database query is '" + query + "'");

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, product.getId());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
