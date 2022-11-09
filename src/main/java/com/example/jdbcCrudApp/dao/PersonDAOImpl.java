package com.example.jdbcCrudApp.dao;

import java.sql.*;

import com.example.jdbcCrudApp.connection.ConnectionHandler;
import com.example.jdbcCrudApp.connection.ConnectionHandlerImpl;

public class PersonDAOImpl implements PersonDAO {
    private ConnectionHandler connection;

    private static PersonDAO sharedInstance = new PersonDAOImpl();

    private PersonDAOImpl() {
        this.connection = ConnectionHandlerImpl.getSharedInstance();
    }

    public static PersonDAO getSharedInstance() {
        return sharedInstance;
    }

    @Override
    public void insertPerson(int id, String name, String surname, int age) {
        try {
            String insertPerson = "insert into people (id, name, surname, age) values (?, ?, ?, ?);";
            PreparedStatement updateStatement = connection.getConnection().prepareStatement(insertPerson);

            updateStatement.setInt(1, id);
            updateStatement.setString(2, name);
            updateStatement.setString(3, surname);
            updateStatement.setInt(4, age);

            System.out.println("Appended records: " + updateStatement.executeUpdate());
            System.out.println();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deletePersonBy(int id) {
        try {
            String deletePerson = "delete from people where id = ?;";
            PreparedStatement updateStatement = connection.getConnection().prepareStatement(deletePerson);
            updateStatement.setInt(1, id);

            System.out.println("Deleted records: " + updateStatement.executeUpdate());
            System.out.println();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updatePersonName(int id, String name) {
        try {
            String updatePerson = "update people set name = ? where id = ?";
            PreparedStatement updateStatement = connection.getConnection().prepareStatement(updatePerson);

            updateStatement.setString(1, name);
            updateStatement.setInt(2, id);

            System.out.println("Updated records: " + updateStatement.executeUpdate());
            System.out.println();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void retrieveAll() {
        try {
            Statement updateStatement = connection.getConnection().createStatement();

            ResultSet people = updateStatement.executeQuery("select * from people;");
            while (people.next()) {
                System.out.println(
                        people.getString("id") + " " + people.getString("name") + " " +
                                people.getString("surname") + " " + people.getString("age"));
            }
            System.out.println();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void retrievePersonById(int id) {
        try {
            String query = "select * from people where id = ?;";
            PreparedStatement updateStatement = connection.getConnection().prepareStatement(query);
            updateStatement.setInt(1, id);

            ResultSet people = updateStatement.executeQuery();
            while (people.next()) {
                System.out.println(
                        people.getString("id") + " " + people.getString("name") + " " +
                                people.getString("surname") + " " + people.getString("age"));
            }
            System.out.println();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
