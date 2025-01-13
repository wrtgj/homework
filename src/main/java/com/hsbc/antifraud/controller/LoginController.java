package com.hsbc.antifraud.controller;
import com.hsbc.antifraud.entity.User;
import com.hsbc.antifraud.service.Impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
@Controller
//@ComponentScan("com.example.controller")
@RequestMapping("/account")
public class LoginController {
    @Autowired
    private UserServiceImpl userServiceImpl;
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @PostMapping ("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        User user = userServiceImpl.findByUserName(username);
        if(user == null||!hashWithGuava(password).equals(user.getPassword())) {
            logger.info(hashWithGuava(password)+" Username or"+password+" password incorrect"+user.getPassword());
            return "redirect:/main/login";
        }
        return "redirect:/transfer/top";
        //return "transfer";
    }
    public static String hashWithGuava(String input) {
        HashCode hashCode = Hashing.md5().hashBytes(input.getBytes());
        return hashCode.toString();
    }
}

