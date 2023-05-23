package com.yabai.service.serviceImpl;


import com.yabai.dao.api.UserDao;
import com.yabai.dao.daoImpl.UserDaoImpl;
import com.yabai.entity.User;
import com.yabai.service.api.UserService;
import com.yabai.util.JDBCUtils;
import com.yabai.util.MD5Utils;

import java.sql.Connection;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {



        Connection connection = JDBCUtils.getConnection();

        //1.用户登录
        try {
            // 明文的密码执行加密操作，得到密文的密码
            String encodedPassword = MD5Utils.encode(password);

            // 核心操作
            User user = userDao.selectUserByNamePwd(username, encodedPassword);

            // 返回查询结果
            return user;
        } finally {
            // 在 finally 块中释放数据库连接，确保资源能够释放
            JDBCUtils.releaseConnection(connection);
        }
    }

    //2.用户注册
    @Override
    public boolean register(User user) {

        Connection connection = JDBCUtils.getConnection();

        //设置标志
        boolean flag = false;

        try {
            long count = userDao.selectCntByName(user.getUsername());
            if (count>2){
                throw new RuntimeException("数据库存在多个同名用户异常");
            }else if (count>1){
                throw new RuntimeException("存在相同用户名");
            }else if(count==0){
                String encode = MD5Utils.encode(user.getPassword());
                user.setPassword(encode);
                flag = userDao.insertUserInfo(user);
            }

            return flag;
        }finally {
            JDBCUtils.releaseConnection(connection);
        }

    }
}
