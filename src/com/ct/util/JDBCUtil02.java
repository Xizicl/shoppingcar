package com.ct.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtil02 {

    static ComboPooledDataSource dataSource;

    static {
        dataSource = new ComboPooledDataSource();
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    /**
     * 获取连接对象
     *
     */
    public static Connection getConn() throws SQLException {
        return dataSource.getConnection();
    }


}
