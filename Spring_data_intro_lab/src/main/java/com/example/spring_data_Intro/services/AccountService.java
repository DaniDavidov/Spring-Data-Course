package com.example.spring_data_Intro.services;

import com.example.spring_data_Intro.models.Account;

import java.math.BigDecimal;

public interface AccountService {
    void withdrawMoney(BigDecimal money, Long id);
    void transferMoney(BigDecimal money, Long id);
    void registerAccount(Account account);
}
