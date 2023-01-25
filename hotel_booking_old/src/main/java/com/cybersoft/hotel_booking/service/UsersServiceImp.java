package com.cybersoft.hotel_booking.service;

import com.cybersoft.hotel_booking.entity.TokenExpiredEntity;
import com.cybersoft.hotel_booking.entity.UsersEntity;
import com.cybersoft.hotel_booking.repository.TokenRepository;
import com.cybersoft.hotel_booking.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public UsersEntity findUsersById(Integer id) {
        return usersRepository.findById(id).orElse(null);
    }

    @Override
    public UsersEntity updateUsers(Integer id, UsersEntity usersEntity) {
        boolean exist = usersRepository.existsById(id);
        if (exist) {
            usersEntity.setId(id);
            return usersRepository.save(usersEntity);
        }
        return null;
    }

    @Override
    public boolean deleteUsersById(Integer id) {
        boolean exist = usersRepository.existsById(id);
        if (exist) {
            usersRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
