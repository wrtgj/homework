package com.hsbc.antifraud.service.Impl;
import com.hsbc.antifraud.entity.TransferHistory;
import com.hsbc.antifraud.repository.TransferHistoryRepository;
import com.hsbc.antifraud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hsbc.antifraud.repository.UserRepository;
import com.hsbc.antifraud.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TransferHistoryRepository transferHistoryRepository;
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElse(null);  // 这里
    }
    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }
    public User findByUserCard(int card_id) {
        return userRepository.findByCreditcardId(card_id);
    }
    @Transactional
    public void tranferBalance(User Fromuser, User Touser, int balance) {
        userRepository.updateBalanceByUserId(Fromuser.getId(),Fromuser.getBalance()-balance);
        userRepository.updateBalanceByUserId(Touser.getId(),Touser.getBalance()+balance);
        TransferHistory history = new TransferHistory(Fromuser.getId(), Touser.getId(), balance, LocalDateTime.now(),  1, "正常转账");
        transferHistoryRepository.save(history);
    }
}