package com.hsbc.antifraud.entity;

public class TransInfo {
    private String fromAccount;
    private String toAccount;
    private String balance;
    //private String creditCard;
    // 构造函数、Getter和Setter方法等
    public TransInfo(String fromAccount, String toAccount,String balance) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.balance = balance;
    }
    public String getfromAccount() {
        return fromAccount;
    }
    public String setfromAccount() {
        return this.fromAccount = fromAccount;
    }
    public void settoAccount(String toAccount) {
        this.toAccount = toAccount;
    }
    public String gettoAccount() {
        return toAccount;
    }
    public String getBalance() {
        return balance;
    }
    public void setBalance(String balance) {
        this.balance = balance;
    }
}
