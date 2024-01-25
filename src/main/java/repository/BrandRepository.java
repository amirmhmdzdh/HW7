package repository;

import model.Brand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BrandRepository {

    private final Connection connection;


    public BrandRepository(Connection connection) {
        this.connection = connection;
    }

    public int CreateBrand(Brand brand) throws SQLException {

        String createBrand = "INSERT INTO brand(name , website , description)VALUES(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(createBrand);

        preparedStatement.setString(1, brand.getBrandName());
        preparedStatement.setString(2, brand.getWebsite());
        preparedStatement.setString(3, brand.getDescription());

        int result = preparedStatement.executeUpdate();
        return result;

    }
    public Brand editBrand(Brand brand) throws SQLException {

        String editBrand = "UPDATE brand SET name = ? , website = ? , description = ?  WHERE id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(editBrand);

        preparedStatement.setString(1, brand.getBrandName());
        preparedStatement.setString(2, brand.getWebsite());
        preparedStatement.setString(3, brand.getDescription());
        preparedStatement.setInt(4, brand.getId());

        preparedStatement.executeUpdate();
        return brand;
    }
    public Brand load(int id) throws SQLException {

        String select = "SELECT * FROM brand WHERE id=? ";
        PreparedStatement preparedStatement = connection.prepareStatement(select);

        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {

            int brandId = resultSet.getInt("id");
            String brandName = resultSet.getString("name");
            String brandWebsite = resultSet.getString("website");
            String description = resultSet.getString("description");

            Brand brand = new Brand(brandId, brandName, brandWebsite, description);

            return brand;
        } else return null;

    }

    public void deleteBrand(Brand brand) throws SQLException {
        String deleteQuery = "DELETE FROM brand WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
        preparedStatement.setInt(1, brand.getId());
        preparedStatement.executeUpdate();

    }
}


