package userrepository;
import model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {

    private final Connection connection ;

    public UserRepository(Connection connection){
    this.connection = connection;
    }

    public int registerUser(User user) throws SQLException {

        String adduser = "INSERT INTO users(name , user_name , email , password)VALUES(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(adduser);

        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getUserName());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getPassword());

        int result = preparedStatement.executeUpdate();
        return result;
    }

    public User findUser(String username) throws SQLException {

        String findUser = "SELECT * FROM users WHERE user_name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(findUser);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String userName = resultSet.getString("user_name");
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");
            return new User(id, name, userName, email, password);
        } else
            return null;

    }
}
