package com.example.service;

import com.example.domain.User;

import java.util.List;


public interface UserService {
    /**
     * 查询所有用户信息
     * @return
     * @throws Exception
     */
    List<User> findUsers() throws Exception;

    /**
     * 根据ID进行单独查询用户
     * @param id 主键
     * @return
     * @throws Exception
     */
    User findUserById(Integer id) throws Exception;

    void saveUser(User user);
}
