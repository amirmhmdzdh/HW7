package repository;

import model.Brand;
import model.Category;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRepository {

    private final Connection connection;

    public ProductRepository(Connection connection) {
        this.connection = connection;
    }

    public Brand[] findAll() throws SQLException {

        String query = "SELECT * FROM brand";
        PreparedStatement preparedStatement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.last();
        int rowCount = resultSet.getRow();
        resultSet.beforeFirst();

        Brand[] brands = new Brand[rowCount];


        int i = 0;
        while (resultSet.next()) {
            int brandId = resultSet.getInt("id");
            String brandName = resultSet.getString("name");
            String website = resultSet.getString("website");
            String description = resultSet.getString("description");

            Brand brand = new Brand(brandId, brandName, website, description);
            brands[i] = brand;
            i++;
        }
        return brands;
    }

    public Category[] findAllC() throws SQLException {

        String query = "SELECT * FROM category";
        PreparedStatement preparedStatement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.last();
        int rowCount = resultSet.getRow();
        resultSet.beforeFirst();

        Category[] categories = new Category[rowCount];


        int i = 0;
        while (resultSet.next()) {
            int categoryId = resultSet.getInt("id");
            String categoryName = resultSet.getString("name");
            String description = resultSet.getString("description");

            Category category = new Category(categoryId, categoryName, description);
            categories[i] = category;
            i++;
        }
        return categories;
    }

    public int createProduct(Product product) throws SQLException {

        String createProduct = "INSERT INTO product (name, create_date, category_id, brand_id) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(createProduct);

        preparedStatement.setString(1, product.getName());
        preparedStatement.setInt(2, product.getCreateDate());
        preparedStatement.setInt(3, product.getCategory());
        preparedStatement.setInt(4, product.getBrand());

        int result = preparedStatement.executeUpdate();
        return result;
    }
}
