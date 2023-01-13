package com.cybersoft.hotel_booking.service;

import com.cybersoft.hotel_booking.entity.TokenExpiredEntity;
import com.cybersoft.hotel_booking.entity.UsersEntity;

import java.util.List;

public interface UsersService {
    UsersEntity checkLogin(String email);

    List<TokenExpiredEntity> invalidToken(String token);

    boolean checkToken(String token);

    UsersEntity addUsers(UsersEntity usersEntity);

    List<UsersEntity> findAllUsers();

    UsersEntity findUsersById(int id);

    UsersEntity updateUsers(int id, UsersEntity usersEntity);

    boolean deleteUsersById(int id);
}
