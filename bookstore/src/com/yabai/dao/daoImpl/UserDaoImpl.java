package com.yabai.dao.daoImpl;


import com.yabai.dao.api.UserDao;
import com.yabai.entity.User;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

    //1.用户登录
    @Override
    public User selectUserByNamePwd(String username, String encode) {

        //1.书写sql语句
        String sql = "select user_id,user_name,user_pwd,email from t_user where user_name = ? and user_pwd = ?";
        User user = selectSingleEntity(sql,User.class,username,encode);

        return user;
    }


    //2.用户注册
    @Override
    public long selectCntByName(String username) {
        String sql = "select count(*) from t_user where user_name = ?";
        return (long) selectValue(sql,username);
    }

    @Override
    public boolean insertUserInfo(User user) {
        String sql = "insert into t_user values(null,?,?,?)";

        return update(sql,user.getUsername(),user.getPassword(),user.getEmail())>0;
    }






}
