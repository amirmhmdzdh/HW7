package repository;

import model.Product;
import model.Shareholder;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShareholderRepository {

    private final Connection connection;

    public ShareholderRepository(Connection connection) {
        this.connection = connection;
    }

    public int signUp(Shareholder shareholder) throws SQLException {

        String add = "INSERT INTO shareholder (name, phone_number, national_code) VALUES (?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(add);

        preparedStatement.setString(1, shareholder.getName());
        preparedStatement.setString(2, shareholder.getPhoneNumber());
        preparedStatement.setString(3, shareholder.getNationalCode());

        int result = preparedStatement.executeUpdate();
        return result;
    }

    public Shareholder findShareholder(String nationalcode) throws SQLException {

        String findShareholder = "SELECT * FROM shareholder WHERE national_code = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(findShareholder);
        preparedStatement.setString(1, nationalcode);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String phoneNumber = resultSet.getString("phone_number");
            String nationalCode = resultSet.getString("national_code");

            return new Shareholder(id, name, phoneNumber, nationalCode);
        } else
            return null;

    }

    public Shareholder editeshareholder(Shareholder shareholder) throws SQLException {

        String editShareholder = "UPDATE shareholder set name =? , phone_number = ? , national_code = ? WHERE id = ? ;";
        PreparedStatement preparedStatement = connection.prepareStatement(editShareholder);

        preparedStatement.setString(1, shareholder.getName());
        preparedStatement.setString(2, shareholder.getPhoneNumber());
        preparedStatement.setString(3, shareholder.getNationalCode());
        preparedStatement.setInt(4, shareholder.getId());

        preparedStatement.executeUpdate();
        return shareholder;

    }

    public Shareholder load(int id) throws SQLException {

        String select = "SELECT * FROM shareholder WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(select);

        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {

            int shareholderId = resultSet.getInt("id");
            String shareholderName = resultSet.getString("name");
            String phoneNumber = resultSet.getString("phone_number");
            String nationalCode = resultSet.getString("national_code");

            Shareholder shareholder = new Shareholder(shareholderId, shareholderName, phoneNumber, nationalCode);

            return shareholder;

        } else return null;

    }

    public Shareholder deleteShareholder(Shareholder shareholder) throws SQLException {
        String deleteQuery = "DELETE FROM shareholder WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
        preparedStatement.setInt(1, shareholder.getId());
        preparedStatement.executeUpdate();
        return shareholder;
    }




}
