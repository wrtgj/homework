package com.hsbc.antifraud.repository;

import com.hsbc.antifraud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface UserRepository extends JpaRepository<User, Long> {
    User getUserById(Long id);
    //@Query("select u from User u where u.username =?1")
    //@Query("select hsbc_member from User hsbc_member  where hsbc_member.username =?1")
    User findByUsername(String username);
    User findByCreditcardId(int card_id);
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.balance = ?2 WHERE u.id = ?1")
    void updateBalanceByUserId(long id, int balance);

}