package com.anmi.webapp.services;

import com.anmi.webapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
public interface AccountService extends JpaRepository<Account,Long> {
}
