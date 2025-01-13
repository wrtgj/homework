package com.hsbc.antifraud.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "hsbc_member")  // table is hsbc_member
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String phone;
    private String password;
    private String username;
    private int status;
    private int creditcardId;
    private int balance;
    // 构造函数、getter和setter方法等
    public User() {
    }
    public User(String name, String email) {
        this.username = name;
        this.email = email;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserName() {
        return username;
    }
    public void setUserName(String name) {
        this.username = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
}