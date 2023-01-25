package com.cybersoft.hotel_booking.service;

import com.cybersoft.hotel_booking.entity.TokenExpiredEntity;
import com.cybersoft.hotel_booking.entity.UsersEntity;

import java.util.List;

public interface UsersService {
    UsersEntity checkLogin(String email);
    List<TokenExpiredEntity> invalidToken(String token);
    boolean checkToken(String token);

    //CRUD
    UsersEntity addUsers(UsersEntity usersEntity);
    List<UsersEntity> findAllUsers();
    UsersEntity findUsersById(Integer id);
    UsersEntity updateUsers(Integer id, UsersEntity usersEntity);
    boolean deleteUsersById(Integer id);
}
