package com.anmi.webapp.services;

import com.anmi.webapp.entity.Account;
import com.anmi.webapp.services.jpa.AccountService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/test-context.xml"})
public class AccountRepositoryTest {

    @Autowired
    private AccountService accountService;


    @Test
    public void test(){
        Account account = new Account();
        account.setFirstName("Andriy");
        account.setLastName("Minenko");

        accountService.save(account);

        Account dbAccount = accountService.findOne(account.getId());
        assertNotNull(dbAccount);
        System.out.println(dbAccount.getLastName());
    }
}
