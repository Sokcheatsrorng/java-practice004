package repository;
import loading.LoadingProperties;
import model.service.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    // select all users
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        // loading properties from config.properties
        LoadingProperties.loadingProperty();
        // query select all users
        String sql = "SELECT * FROM users";
        try (Connection connection = DriverManager.getConnection(
                LoadingProperties.properties.getProperty("database_url"),
                LoadingProperties.properties.getProperty("database_username"),
                LoadingProperties.properties.getProperty("database_password")
        );
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            System.out.println("Connected to database");
            // Process the results
            while (rs.next()) {
                // Handle other columns as needed
                userList.add(new User(
                        rs.getInt("user_id"),
                        rs.getString("user_uuid"),
                        rs.getString("user_name"),
                        rs.getString("user_email"),
                        rs.getString("user_password"),
                        rs.getBoolean("is_deleted"),
                        rs.getBoolean("is_verified")
                ));
            }
        } catch (SQLException sqlException) {
            System.out.println("Problem during selecting data from database: " + sqlException.getMessage());
        }
        return userList;
    }

    // insert user
    public int createUser(User user) {
        LoadingProperties.loadingProperty();
        // SQL query
        String sql = "INSERT INTO users (user_uuid,user_name, user_email, user_password, is_deleted,is_verified) " +
                "VALUES (?,?,?,?,?,?)";
        try (Connection connection = DriverManager.getConnection(
                LoadingProperties.properties.getProperty("database_url"),
                LoadingProperties.properties.getProperty("database_username"),
                LoadingProperties.properties.getProperty("database_password")
        );
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            System.out.println("Connected to database");
            // create new users
            preparedStatement.setString(1, user.getUserUuid());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getUserEmail());
            preparedStatement.setString(4, user.getUserPassword());
            preparedStatement.setBoolean(5, user.getIsDeleted());
            preparedStatement.setBoolean(6, user.getIsVerified());
            return preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println("Problem during inserting data into database: " + sqlException.getMessage());
        }
        return 0;
    }

    // delete user
    public int deleteUserById(int id) {
        LoadingProperties.loadingProperty();
        // SQL query deleteUserById
        String sql = "DELETE FROM users WHERE user_id = ?";
        try (Connection connection = DriverManager.getConnection(
                LoadingProperties.properties.getProperty("database_url"),
                LoadingProperties.properties.getProperty("database_username"),
                LoadingProperties.properties.getProperty("database_password")
        );
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            System.out.println("Connected to database");
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println("Problem during deleting data from database: " + sqlException.getMessage());
        }
        return 0;
    }

    // update user by id
    public int updateUserById(int id, User user) {
        LoadingProperties.loadingProperty();
        // SQL query updateUserById
        String sql = "UPDATE users SET user_uuid = ?, user_name = ?, user_email = ?, user_password = ?, is_deleted = ?, is_verified = ? WHERE user_id = ?";
        try (Connection connection = DriverManager.getConnection(
                LoadingProperties.properties.getProperty("database_url"),
                LoadingProperties.properties.getProperty("database_username"),
                LoadingProperties.properties.getProperty("database_password")
        );
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            System.out.println("Connected to database");
            preparedStatement.setString(1, user.getUserUuid());
            preparedStatement.setString(2, user.getUserName());
            preparedStatement.setString(3, user.getUserEmail());
            preparedStatement.setString(4, user.getUserPassword());
            preparedStatement.setBoolean(5, user.getIsDeleted());
            preparedStatement.setBoolean(6, user.getIsVerified());
            preparedStatement.setInt(7, id);

            return preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            System.out.println("Problem during updating data in database: " + sqlException.getMessage());
        }
        return 0;
    }
}
