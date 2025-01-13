package com.hsbc.antifraud.controller;

import com.hsbc.antifraud.entity.TransInfo;
import com.hsbc.antifraud.entity.User;
import com.hsbc.antifraud.service.Impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@Controller
//@ComponentScan("com.example.controller")
@RequestMapping("/transfer")
public class TransferController {
    private static final Logger logger = LoggerFactory.getLogger(TransferController.class);
    private int threshlod = 100000;
    @Autowired
    private UserServiceImpl userServiceImpl;
    @PostMapping("/submit")
    @ResponseBody
    public HashMap<String, Object> submit(@RequestBody TransInfo transInfo) {
        HashMap<String, Object> response = new HashMap<>();
        int success = 1;
        String message = "转账操作成功";
        //logger.info(transInfo.getfromAccount()+" from to "+transInfo.gettoAccount()+" balance "+transInfo.getBalance());
        int balance = Integer.parseInt(transInfo.getBalance());
        int toCardId = Integer.parseInt(transInfo.gettoAccount());
        int FromCardId = Integer.parseInt(transInfo.getfromAccount());
        User toUser = userServiceImpl.findByUserCard(toCardId);
        User FromUser = userServiceImpl.findByUserCard(FromCardId);
        if(FromUser.getBalance()<balance||balance>threshlod || balance<0||toUser==null||toUser.getStatus()==2){
            success = 0;
            message = "转账操作失败";
        }else {
            userServiceImpl.tranferBalance(FromUser,toUser,balance);
        }

        response.put("success", success);
        response.put("message", message);
        response.put("fromAccount", transInfo.getfromAccount());
        response.put("toAccount", transInfo.gettoAccount());
        response.put("balance", transInfo.getBalance());

        return response;
    }
    @GetMapping("/top")
    public String top() {
        //return "main/login";
        return "transfer";
    }
}

