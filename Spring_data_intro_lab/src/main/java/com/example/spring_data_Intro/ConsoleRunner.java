package com.example.spring_data_Intro;

import com.example.spring_data_Intro.models.Account;
import com.example.spring_data_Intro.models.User;
import com.example.spring_data_Intro.services.AccountService;
import com.example.spring_data_Intro.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private UserService userService;
    private AccountService accountService;

    @Autowired
    public ConsoleRunner(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User("davidov", 23);
        Account account = new Account(BigDecimal.valueOf(25000), user);
        account.setUser(user);

        user.setAccounts(new HashSet<>() {{
            add(account);
        }});

        userService.registerUser(user);

        accountService.withdrawMoney(BigDecimal.valueOf(5500), 1L);
        accountService.transferMoney(BigDecimal.valueOf(6000), 1L);
    }
}
