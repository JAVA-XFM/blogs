package com.xfm.blogs.service;

import com.xfm.blogs.po.User;

/**
 * Created by limi on 2017/10/15.
 */
public interface UserService {

    User checkUser(String username, String password);
}
