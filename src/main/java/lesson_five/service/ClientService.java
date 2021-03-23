package lesson_five.service;

import lesson_five.database.Database;
import lesson_five.entity.Client;
import lesson_five.entity.ClientStatusAge18;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private static final String SELECT_ALL_CLIENT_QUERY = "SELECT * FROM clients";
    private static final String SAVE_CLIENT_QUERY = "INSERT INTO clients (name, email, phone, about, age) VALUES (?,?,?,?,?)";
    private static final String UPDATE_CLIENT_QUERY = "UPDATE clients SET name = ?, email = ?, phone = ?, about = ?, age = ? " +
            "WHERE id = ?";
    private static final String DELETE_CLIENT_QUERY = "DELETE FROM clients WHERE id = ?";
    private static final String FIND_CLIENT_BY_PHONE_QUERY = "SELECT * FROM clients WHERE phone = ?";
    private static final String FIND_CLIENT_WITH_ID_FROM_ACCOUNTS_QUERY = "SELECT c.* FROM clients c " +
            "INNER JOIN accounts a ON c.id = a.client_id";
    private static final String FIND_CLIENT_STATUS_WITH_AGE_MORE_THAN_18_QUERY = "SELECT c.name, c.email, s.alias FROM clients c " +
            "INNER JOIN client_status cs ON c.id = cs.client_id " +
            "INNER JOIN statuses s ON cs.status_id = s.id " +
            "WHERE c.age > 18;";

    public List<Client> getAll() {
        List<Client> clients = new ArrayList<>();

        try (Connection connection = Database.getConnection(); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_CLIENT_QUERY);
            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                client.setPhone(resultSet.getLong("phone"));
                client.setAbout(resultSet.getString("about"));
                client.setAge(resultSet.getInt("age"));
                clients.add(client);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public void save(Client client) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement(SAVE_CLIENT_QUERY)) {
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getEmail());
            preparedStatement.setLong(3, client.getPhone());
            preparedStatement.setString(4, client.getAbout());
            preparedStatement.setInt(5, client.getAge());
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Client client, int id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement(UPDATE_CLIENT_QUERY)) {
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getEmail());
            preparedStatement.setLong(3, client.getPhone());
            preparedStatement.setString(4, client.getAbout());
            preparedStatement.setInt(5, client.getAge());
            preparedStatement.setInt(6, id);
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement(DELETE_CLIENT_QUERY)) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Client> getClientByPhone(long phone) {
        List<Client> clients = new ArrayList<>();

        try (Connection connection = Database.getConnection();
             PreparedStatement preparedStatement = connection.
                     prepareStatement(FIND_CLIENT_BY_PHONE_QUERY)) {
            preparedStatement.setLong(1, phone);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                client.setPhone(resultSet.getLong("phone"));
                client.setAbout(resultSet.getString("about"));
                client.setAge(resultSet.getInt("age"));

                if (client.getPhone() == phone){
                    clients.add(client);
                }
                else {
                    return null;
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public List<Client> getClientsWithIdAppearedInAccounts() {
        List<Client> clients = new ArrayList<>();

        try (Connection connection = Database.getConnection(); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(FIND_CLIENT_WITH_ID_FROM_ACCOUNTS_QUERY);
            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getInt("id"));
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                client.setPhone(resultSet.getLong("phone"));
                client.setAbout(resultSet.getString("about"));
                client.setAge(resultSet.getInt("age"));
                clients.add(client);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public List<ClientStatusAge18> getClientsStatusWithAgeMoreThan18() {
        List<ClientStatusAge18> clients = new ArrayList<>();

        try (Connection connection = Database.getConnection(); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(FIND_CLIENT_STATUS_WITH_AGE_MORE_THAN_18_QUERY);

            while (resultSet.next()) {
                ClientStatusAge18 client = new ClientStatusAge18();
                client.setName(resultSet.getString("name"));
                client.setEmail(resultSet.getString("email"));
                client.setAlias(resultSet.getString("alias"));
                clients.add(client);
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }
}