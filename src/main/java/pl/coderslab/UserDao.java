package pl.coderslab;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.utils.DbUtil;

import java.sql.*;
import java.util.Arrays;

public class UserDao {

    private static final String CREATE_QUERY = "INSERT INTO workshop2 (email, username, password) VALUES (?, ?, ?)";
    private static final String CHECK_ID = "SELECT * FROM workshop2 WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM workshop2 WHERE id = ?";
    private static final String UPDATE_QUERY = "UPDATE workshop2 SET email = ?, username = ?, password = ? WHERE id = ?";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM workshop2";


    // creating new user
    public User createUser(User user) {

        try
                (Connection connection = DbUtil.getConnection()) {

            PreparedStatement preparedStatement1 = connection.prepareStatement(CREATE_QUERY, Statement.RETURN_GENERATED_KEYS);
            preparedStatement1.setString(1, user.getEmail());
            preparedStatement1.setString(2, user.getUserName());
            preparedStatement1.setString(3, hashPassword(user.getPassword()));
            preparedStatement1.executeUpdate();

            ResultSet resultSet1 = preparedStatement1.getGeneratedKeys();
            if (resultSet1.next()) {
                user.setId(resultSet1.getInt(1));
            }
            return user;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }


    // reading existing user form database, taking in a row from table and turning it into na object
    public static User readUser(int idUser) {

        // check connection
        try
                (Connection connection = DbUtil.getConnection();
                 PreparedStatement preparedStatement2 = connection.prepareStatement(CHECK_ID)) {

            preparedStatement2.setInt(1, idUser); // setting value for prepared statement

            try (ResultSet resultSet2 = preparedStatement2.executeQuery()) {
                if (resultSet2.next()) {
                    // if id is in the database, checks if the sql query returned at least one row
                    // there is a row with the given id

                    //System.out.println("ID found in database");

                    // retrieve info
                    User userResult = new User();
                    userResult.setId(resultSet2.getInt("id"));
                    userResult.setEmail(resultSet2.getString("email"));
                    userResult.setUserName(resultSet2.getString("username"));
                    userResult.setPassword(hashPassword(resultSet2.getString("password")));

                    // print info, need to call getter to see user's info
                    return userResult;

                } else {
                    //System.out.println("ID not found in database");
                    return null;
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    // delete method
    public static void deleteUser(int idUser) {
        User userToDelete = readUser(idUser);

        try
                (Connection connection = DbUtil.getConnection();
                 PreparedStatement preparedStatement3 = connection.prepareStatement(DELETE_QUERY)) {

            preparedStatement3.setInt(1, idUser);
            preparedStatement3.executeUpdate();

            // if the id doesn't exist nothing gets printed, maybe fix that?


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // update method
    public static void updateUser(User user) {

        try
                (Connection connection = DbUtil.getConnection();
                 PreparedStatement preparedStatement4 = connection.prepareStatement(UPDATE_QUERY)) {

            preparedStatement4.setString(1, user.getEmail());
            preparedStatement4.setString(2, user.getUserName());
            preparedStatement4.setString(3, hashPassword(user.getPassword()));
            preparedStatement4.setInt(4, user.getId());

            preparedStatement4.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // find all
    public static User[] findAll() {

        User[] usersAll = new User[0];

        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement5 = connection.prepareStatement(SELECT_ALL_QUERY)) {

            ResultSet resultSet5 = preparedStatement5.executeQuery();

            while (resultSet5.next()) {

                User userResultHolder = new User();
                userResultHolder.setId(resultSet5.getInt("id"));
                userResultHolder.setEmail(resultSet5.getString("email"));
                userResultHolder.setUserName(resultSet5.getString("username"));
                userResultHolder.setPassword(hashPassword(resultSet5.getString("password")));

                usersAll = addToArray(userResultHolder, usersAll);

            }

            return usersAll;


        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }


    private static User[] addToArray(User u, User[] users) {
        User[] tmpUsers = Arrays.copyOf(users, users.length + 1);
        tmpUsers[users.length] = u;
        return tmpUsers;
    }

    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

}





