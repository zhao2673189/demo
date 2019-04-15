package com.example.mapper;

import com.example.domain.User;
import com.example.domain.VoteInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    @Select("select * from user")
    List<User> findUsers() throws Exception;

    @Select("select * from user where id = #{id}")
    User findUserById(@Param("id") Integer id) throws Exception;

    @Insert("insert into user(id,name,phone,subject) values (#{id},#{name},#{phone},#{subject})")
    void saveUser(User user);

    @Select("select * from user where phone = #{phone}")
    User getUserByPhone(@Param("phone") String phone);

    List<User> getUserInfoById(Long id);


}
