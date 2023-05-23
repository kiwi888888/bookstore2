package com.yabai.dao.api;

import java.util.List;

public interface BaseDao<T> {

    /**
     * 通用的更新操作：增删改
     * @param sql
     * @param params
     * @return 受影响的行数
     */
    int update(String sql, Object ... params);

    /**
     * 通用的查询方法：根据查询条件执行查询
     * @param sql
     * @param param
     * @return List 集合
     */
    List<T> selectByCondition(String sql, Class<T> clazz, Object ... param);

    /**
     * 通用的查询方法：根据查询条件返回单个对象
     * @param sql
     * @param param
     * @return
     */
    T selectSingleEntity(String sql, Class<T> clazz, Object ... param);

    /**
     * 通用的查询方法：得到 SQL 函数返回的单个值
     * @param sql
     * @param param
     * @return
     */
    Object selectValue(String sql, Object ... param);

}
