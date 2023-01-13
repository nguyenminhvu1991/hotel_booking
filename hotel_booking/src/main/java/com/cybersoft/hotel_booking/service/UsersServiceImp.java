package com.cybersoft.hotel_booking.service;

import com.cybersoft.hotel_booking.entity.TokenExpiredEntity;
import com.cybersoft.hotel_booking.entity.UsersEntity;
import com.cybersoft.hotel_booking.repository.TokenRepository;
import com.cybersoft.hotel_booking.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UsersServiceImp implements UsersService {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public UsersEntity checkLogin(String email) {
        return usersRepository.findByEmail(email).size() > 0 ? usersRepository.findByEmail(email).get(0) : null;
    }

    @Override
    public List<TokenExpiredEntity> invalidToken(String token) {
        TokenExpiredEntity tokenExpiredEntity = new TokenExpiredEntity();
        tokenExpiredEntity.setName(token);
        tokenRepository.save(tokenExpiredEntity);
        return tokenRepository.findAll();
    }

    @Override
    public boolean checkToken(String token) {
        String abc = null;
        System.out.println("tokenRepository.findByName(token) = " + tokenRepository.findByName(token));
        return tokenRepository.findByName(token) != null;
    }

    //CRUD
    @Override
    public UsersEntity addUsers(UsersEntity usersEntity) {
        usersEntity.setId(0);
        return usersRepository.save(usersEntity);
    }

    @Override
    public List<UsersEntity> findAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public UsersEntity findUsersById(int id) {
        return usersRepository.findById(id).orElse(null);
    }

    @Override
    public UsersEntity updateUsers(int id, UsersEntity usersEntity) {
        UsersEntity usersEntityFromDB = usersRepository.findById(id).orElse(null);
        if (usersEntityFromDB != null) {
            usersEntity.setId(id);
            return usersRepository.save(usersEntity);
        }
        return null;
    }

    @Override
    public boolean deleteUsersById(int id) {
        UsersEntity usersEntityFromDB = usersRepository.findById(id).orElse(null);
        if (usersEntityFromDB != null) {
            usersRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
