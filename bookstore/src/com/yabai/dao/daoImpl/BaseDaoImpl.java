package com.yabai.dao.daoImpl;


import com.yabai.dao.api.BaseDao;
import com.yabai.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BaseDaoImpl<T> implements BaseDao<T> {

    private QueryRunner queryRunner = new QueryRunner();

    @Override
    public int update(String sql, Object... params) {

        try {
            // 1、获取数据库连接
            Connection connection = JDBCUtils.getConnection();

            // 2、调用 QueryRunner 的方法执行更新操作
            return queryRunner.update(connection, sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<T> selectByCondition(String sql, Class<T> clazz, Object... param) {

        try {
            // 1、获取数据库连接
            Connection connection = JDBCUtils.getConnection();

            // 2、调用 QueryRunner 的方法执行查询操作
            return queryRunner.query(connection, sql, new BeanListHandler<>(clazz), param);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T selectSingleEntity(String sql, Class<T> clazz, Object... param) {

        try {
            // 1、获取数据库连接
            Connection connection = JDBCUtils.getConnection();

            // 2、调用 QueryRunner 的方法执行查询操作
            return queryRunner.query(connection, sql, new BeanHandler<>(clazz), param);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object selectValue(String sql, Object... param) {
        try {
            Connection connection = JDBCUtils.getConnection();

            // 对应 SQL 查询结果中单个值的情况，ResultSetHandler 使用 ScalarHandler
            return queryRunner.query(connection, sql, new ScalarHandler(), param);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
