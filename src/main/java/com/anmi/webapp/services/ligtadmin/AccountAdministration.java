package com.anmi.webapp.services.ligtadmin;

import com.anmi.webapp.entity.Account;
import com.anmi.webapp.services.ligtadmin.renderers.CustomNameRenderer;
import org.lightadmin.api.config.AdministrationConfiguration;
import org.lightadmin.api.config.builder.EntityMetadataConfigurationUnitBuilder;
import org.lightadmin.api.config.builder.FieldSetConfigurationUnitBuilder;
import org.lightadmin.api.config.builder.PersistentFieldSetConfigurationUnitBuilder;
import org.lightadmin.api.config.builder.ScreenContextConfigurationUnitBuilder;
import org.lightadmin.api.config.unit.EntityMetadataConfigurationUnit;
import org.lightadmin.api.config.unit.FieldSetConfigurationUnit;
import org.lightadmin.api.config.unit.ScreenContextConfigurationUnit;
import org.lightadmin.api.config.utils.EntityNameExtractor;
import org.lightadmin.api.config.utils.EnumElement;

public class AccountAdministration extends AdministrationConfiguration<Account> {
    public EntityMetadataConfigurationUnit configuration( EntityMetadataConfigurationUnitBuilder configurationBuilder ) {
        return configurationBuilder.nameField( "account" ).singularName("Account").pluralName("Accounts")
                .nameExtractor(userNameExtractor()).build();
    }

    public ScreenContextConfigurationUnit screenContext( ScreenContextConfigurationUnitBuilder screenContextBuilder ) {
        return screenContextBuilder
                .screenName("Users management").build();
    }


    public  FieldSetConfigurationUnit listView( final FieldSetConfigurationUnitBuilder fragmentBuilder ) {
        return fragmentBuilder
                .field("firstName").caption("First Name")
                .renderable(new CustomNameRenderer()).caption("Custom Rendered Name")
                .field("admin").caption("is Admin")
                .field("accountType").caption("Account type")
                .build();
    }

    public FieldSetConfigurationUnit formView( final PersistentFieldSetConfigurationUnitBuilder fragmentBuilder ) {
        return fragmentBuilder
                .field("firstName").caption("First Name")
                .field("lastName").caption("Last Name")
                .field("password").caption("Password")
                .field("admin").caption("is Admin")
                .field("firstName").caption("First Name")
                .field("picture").caption( "Picture")
                .field("accountType").caption("Account type").enumeration(
                        EnumElement.element("1", Account.AccountType.ADMIN.name()),
                        EnumElement.element("2", Account.AccountType.MAINTENACE.name()),
                        EnumElement.element("3", Account.AccountType.USER.name()))
                .build();
    }

    public FieldSetConfigurationUnit quickView( final PersistentFieldSetConfigurationUnitBuilder fragmentBuilder ) {
        return fragmentBuilder
                .field("firstName").caption("First Name").field("picture").caption( "Picture" ).build();
    }

    private static EntityNameExtractor<Account> userNameExtractor(){
        return new EntityNameExtractor<Account>() {
            @Override
            public String apply(Account account) {
                return String.format("%s %s",account.getLastName(),account.getFirstName());
            }
        };
    }



}
