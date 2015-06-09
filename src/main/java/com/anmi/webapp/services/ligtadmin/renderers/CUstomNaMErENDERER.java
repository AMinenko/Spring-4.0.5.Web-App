package com.anmi.webapp.services.ligtadmin.renderers;

import com.anmi.webapp.entity.Account;
import org.lightadmin.api.config.utils.FieldValueRenderer;

public class CustomNameRenderer implements FieldValueRenderer {
    @Override
    public String apply(Object o) {
        Account a = (Account)o;
        return String.format("%s %s","Custom Rendered",a.getFirstName());
    }
}
