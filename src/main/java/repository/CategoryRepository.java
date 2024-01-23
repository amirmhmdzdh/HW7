package repository;
import model.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRepository {

    private final Connection connection;

    public CategoryRepository(Connection connection) {
        this.connection = connection;
    }

    public int CreateCategory(Category category) throws SQLException {

        String createCategory = "INSERT INTO category(name , description)VALUES(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(createCategory);

        preparedStatement.setString(1, category.getName());
        preparedStatement.setString(2, category.getDescription());

        int result = preparedStatement.executeUpdate();
        return result;

    }
    public Category editCategory(Category category) throws SQLException {

        String editCategory = "UPDATE category SET name = ? ,description = ?  WHERE id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(editCategory);

        preparedStatement.setString(1, category.getName());
        preparedStatement.setString(2, category.getDescription());
        preparedStatement.setInt(3, category.getId());

        preparedStatement.executeUpdate();
        return category;


    }

    public Category load(int id) throws SQLException {

        String select = "SELECT * FROM category WHERE id=? ";
        PreparedStatement preparedStatement = connection.prepareStatement(select);

        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {

            int categoryId = resultSet.getInt("id");
            String categoryName = resultSet.getString("name");
            String description = resultSet.getString("description");

            Category category = new Category(categoryId, categoryName, description);

            return category;
        } else return null;

    }

    public Category deleteCategory(Category category) throws SQLException {
        String deleteQuery = "DELETE FROM category WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
        preparedStatement.setInt(1, category.getId());
        preparedStatement.executeUpdate();
        return category;

    }


}





