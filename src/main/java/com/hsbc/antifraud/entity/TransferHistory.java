package com.hsbc.antifraud.entity;

import java.time.LocalDateTime;
import jakarta.persistence.*;


@Entity
@Table(name = "transfer_history")
public class TransferHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long fromAccount;
    private long toAccount;
    private int amount;
    private LocalDateTime transfer_time;
    private int transfer_status;
    private String remarks;
    public TransferHistory(long from_account, long to_account, int amount, LocalDateTime transfer_time, int transfer_status, String remarks) {
        this.fromAccount = from_account;
        this.toAccount = to_account;
        this.amount = amount;
        this.transfer_time = transfer_time;
        this.transfer_status = transfer_status;
        this.remarks = remarks;
    }
    public TransferHistory() {
    }
    // 生成对应的Getter和Setter方法

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Integer from_account) {
        this.fromAccount = from_account;
    }

    public long getToAccount() {
        return fromAccount;
    }

    public void setToAccount(Integer to_account) {
        this.fromAccount = to_account;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public LocalDateTime getTransfer_time() {
        return transfer_time;
    }

    public void setTransfer_time(LocalDateTime transfer_time) {
        this.transfer_time = transfer_time;
    }

    public int getTransfer_status() {
        return transfer_status;
    }

    public void setTransfer_status(Byte transfer_status) {
        this.transfer_status = transfer_status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}