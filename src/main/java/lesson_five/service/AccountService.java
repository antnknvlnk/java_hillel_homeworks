package lesson_five.service;

import lesson_five.database.Database;
import lesson_five.entity.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountService {
    private static final String SELECT_ALL_ACCOUNT_QUERY = "SELECT * FROM accounts";
    private static final String SAVE_ACCOUNT_QUERY = "INSERT INTO accounts (client_id, number, value) VALUES (?,?,?)";
    private static final String UPDATE_ACCOUNT_QUERY = "UPDATE accounts SET client_id = ?, number = ?, value = ? WHERE id = ?";
    private static final String DELETE_ACCOUNT_QUERY = "DELETE FROM accounts WHERE id = ?";
    private static final String GET_NUMBER_QUERY = "SELECT number FROM accounts WHERE value > ?";

    public List<Account> getAll() {
        List<Account> accounts = new ArrayList<>();
        try (Connection connection = Database.getConnection(); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_ACCOUNT_QUERY);
            while (resultSet.next()) {
                Account account = new Account();
                account.setId(resultSet.getInt("id"));
                account.setClientId(resultSet.getInt("client_id"));
                account.setNumber(resultSet.getString("number"));
                account.setValue(resultSet.getDouble("value"));
                accounts.add(account);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public void save(Account account) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement(SAVE_ACCOUNT_QUERY)) {
            preparedStatement.setInt(1, account.getClientId());
            preparedStatement.setString(2, account.getNumber());
            preparedStatement.setDouble(3, account.getValue());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Account account, int id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement(UPDATE_ACCOUNT_QUERY)) {
            preparedStatement.setInt(1, account.getClientId());
            preparedStatement.setString(2, account.getNumber());
            preparedStatement.setDouble(3, account.getValue());
            preparedStatement.setInt(4, id);
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement(DELETE_ACCOUNT_QUERY)) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getNumbersMoreThanValue(double value) {
        List<String> numbers = new ArrayList<>();

        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement(GET_NUMBER_QUERY)) {
            preparedStatement.setDouble(1, value);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String number = resultSet.getString("number");
                numbers.add(resultSet.getString("number"));
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numbers;
    }

}
