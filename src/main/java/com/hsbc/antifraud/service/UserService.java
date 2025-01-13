package com.hsbc.antifraud.service;

import com.hsbc.antifraud.entity.TransferHistory;
import com.hsbc.antifraud.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface UserService {
    public List<User> getAllUsers() ;
    public User getUserById(Long id) ;
    public User findByUserName(String username);
    public User findByUserCard(int card_id);
    public void tranferBalance(User Fromuser, User Touser, int balance) ;
}
