package com.yabai.dao.api;


import com.yabai.entity.User;

public interface UserDao extends BaseDao<User>{

    //用户登录
    User selectUserByNamePwd(String username, String encode);

    long selectCntByName(String username);

    boolean insertUserInfo(User user);

    //用户注册



}
