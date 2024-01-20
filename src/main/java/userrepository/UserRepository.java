package userrepository;

import connection.JdbcConnection;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepository {

    private final JdbcConnection jdbcConnection = new JdbcConnection();

    public UserRepository() throws SQLException {
    }

    public int registerUser(User user) throws SQLException {

        Connection connection = jdbcConnection.getConnection();

        String adduser = "INSERT INTO users(name , user_name , email , password)VALUES(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(adduser);

        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getUserName());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getPassword());

        int result = preparedStatement.executeUpdate();
        return result;
    }

}
