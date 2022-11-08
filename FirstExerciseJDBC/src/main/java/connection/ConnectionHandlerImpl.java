package connection;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionHandlerImpl implements ConnectionHandler {
    private Connection connection;

    private static ConnectionHandlerImpl sharedInstance = new ConnectionHandlerImpl();

    private ConnectionHandlerImpl() {
        try {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL("jdbc:mysql://localhost:3306/first-exercise-jdbc");
            dataSource.setUser("root");
            dataSource.setPassword("Mysql&!2022");
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ConnectionHandlerImpl getSharedInstance() {
        return sharedInstance;
    }

    public Connection getConnection() {
        return this.connection;
    }
}
