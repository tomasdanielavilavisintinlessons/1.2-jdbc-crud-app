package com.example.jdbcCrudApp.connection;

import java.sql.Connection;

public interface ConnectionHandler {
    Connection getConnection();
}
