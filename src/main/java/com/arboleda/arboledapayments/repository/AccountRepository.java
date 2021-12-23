package com.arboleda.arboledapayments.repository;

import com.arboleda.arboledapayments.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
