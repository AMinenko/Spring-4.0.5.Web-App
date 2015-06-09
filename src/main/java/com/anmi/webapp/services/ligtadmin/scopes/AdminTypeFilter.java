package com.anmi.webapp.services.ligtadmin.scopes;

import com.anmi.webapp.entity.Account;
import org.lightadmin.api.config.utils.DomainTypePredicate;

public class AdminTypeFilter implements DomainTypePredicate<Account> {



    @Override
    public boolean apply(Account input) {
        return input.isAdmin().equals(1);
    }
}
