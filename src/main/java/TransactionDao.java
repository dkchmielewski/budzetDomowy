import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionDao {

    public void add(Transaction transaction) {

        Connection connection = connect();
        PreparedStatement preparedStatement;

        try {
            String sql = "INSERT INTO transaction (type, description, amount, date) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, transaction.getType());
            preparedStatement.setString(2, transaction.getDescription());
            preparedStatement.setDouble(3, transaction.getAmount());
            preparedStatement.setString(4, transaction.getDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        close(connection);
    }

    private Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not find driver: " + e.getMessage());
        }
        String url = "jdbc:mysql://localhost:3306/transaction?characterEncoding=utf8&serverTimeZone=UCT";
        try {
             return DriverManager.getConnection(url, "root", "#Prince1970#");
        } catch (SQLException e) {
            System.out.println("Could not establish connection");
        }
        return null;
    }

    private void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Could not close connection");
        }
    }

    public void update(Transaction transaction) {
        Connection connection = connect();
        String sql = "UPDATE transaction SET type = ?, description = ?, amount = ?, date = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, transaction.getType());
            preparedStatement.setString(2, transaction.getDescription());
            preparedStatement.setDouble(3, transaction.getAmount());
            preparedStatement.setString(4, transaction.getDate());
            preparedStatement.setLong(5, transaction.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Nie udalo sie zaktualizowac transakcji: " + e.getMessage());
        }
        close(connection);
    }

    public void deleteById(long id) {
        Connection connection = connect();
        String sql = "DELETE FROM transaction WHERE id = ? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println("Nie udalo sie usunac transakcji: " + e.getMessage());
        }
        close(connection);
    }

    public void displayAssets() {
        Connection connection = connect();
        String sql = "SELECT * FROM transcation WHERE type = 'asset'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println("Nie udalo sie wyswietlic przychodow: " + e.getMessage());
        }
        close(connection);
    }

    public void displayLiabilities() {
        Connection connection = connect();
        String sql = "SELECT * FROM transaction WHERE type = 'liability'";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println("Nie udalo sie wysietlic wydatkow: " + e.getMessage());
        }
        close(connection);
    }
}
