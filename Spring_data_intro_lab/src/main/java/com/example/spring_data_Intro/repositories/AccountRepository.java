package com.example.spring_data_Intro.repositories;

import com.example.spring_data_Intro.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findById(Long id);
}
