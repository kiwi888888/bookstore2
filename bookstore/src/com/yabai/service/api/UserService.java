package com.yabai.service.api;

import com.yabai.entity.User;

public interface UserService {

    User login(String username, String password);

    boolean register(User user);
}
