package com.anmi.webapp.services.ligtadmin.scopes;

import com.anmi.webapp.entity.Account;
import org.lightadmin.api.config.utils.DomainTypePredicate;
import org.lightadmin.api.config.utils.DomainTypeSpecification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class AdminTypeSpecification implements DomainTypeSpecification<Account> {

    private boolean admin;

    public AdminTypeSpecification(boolean admin) {
        this.admin = admin;
    }

    @Override
    public Predicate toPredicate(Root root, CriteriaQuery query, CriteriaBuilder cb) {
        return cb.equal(root.get("admin"), admin);
    }
}
