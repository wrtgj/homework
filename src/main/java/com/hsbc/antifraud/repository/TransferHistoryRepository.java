package com.hsbc.antifraud.repository;

import com.hsbc.antifraud.entity.TransferHistory;
import com.hsbc.antifraud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TransferHistoryRepository extends JpaRepository<TransferHistory, Long> {
    // 根据转出账户查询转账历史记录
    TransferHistory findByFromAccount(Integer fromAccount);

    // 根据转入账户查询转账历史记录
    TransferHistory findByToAccount(Integer toAccount);

    // 根据转账金额查询转账历史记录
    TransferHistory findByAmount(Integer amount);

    // 根据转账状态查询转账历史记录
    //TransferHistory findByTransfer_status(Byte transfer_status);
    //TransferHistory saveTransferHistory(TransferHistory transferHistory);

    // 可以根据更多业务需求组合条件查询，例如根据转出账户和转入账户查询转账历史
    //TransferHistory findByFrom_accountAndTo_account(Integer from_account, Integer to_account);
}