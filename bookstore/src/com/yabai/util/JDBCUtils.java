package com.yabai.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {

    private static DataSource dataSource;
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    static {
        try {
            Properties properties = new Properties();
            properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("resources/jdbc.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {

        try {
            Connection connection = threadLocal.get();

            if (connection == null) {
                connection = dataSource.getConnection();
                threadLocal.set(connection);
            }

            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void releaseConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();

                threadLocal.remove();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
