package com.example.spring_data_Intro.services;

import com.example.spring_data_Intro.models.Account;
import com.example.spring_data_Intro.models.User;
import com.example.spring_data_Intro.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void registerAccount(Account account) {
        Account exists = accountRepository.findById(account.getId());
        if (exists == null) {
            accountRepository.save(account);
        }
    }

    @Override
    public void withdrawMoney(BigDecimal money, Long id) {
        Account found = accountRepository.findById(id);
        if (found == null) {
            return;
        }

        BigDecimal currentBalance = found.getBalance();
        User user = found.getUser();

        if (user != null && currentBalance.compareTo(money) >= 0) {
            found.setBalance(currentBalance.subtract(money));
        }
    }

    @Override
    public void transferMoney(BigDecimal money, Long id) {
        Account found = accountRepository.findById(id);
        if (found == null) {
            return;
        }

        BigDecimal currentBalance = found.getBalance();
        User user = found.getUser();

        if (user != null && currentBalance.compareTo(BigDecimal.ZERO) >= 0) {
            found.setBalance(currentBalance.add(money));
        }
    }
}
