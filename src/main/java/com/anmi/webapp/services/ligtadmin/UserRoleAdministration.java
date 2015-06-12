package com.anmi.webapp.services.ligtadmin;

import com.anmi.webapp.entity.Role;
import org.lightadmin.api.config.AdministrationConfiguration;
import org.lightadmin.api.config.builder.*;
import org.lightadmin.api.config.unit.EntityMetadataConfigurationUnit;
import org.lightadmin.api.config.unit.FieldSetConfigurationUnit;


public class UserRoleAdministration extends AdministrationConfiguration<Role> {

    public  EntityMetadataConfigurationUnit configuration( EntityMetadataConfigurationUnitBuilder configurationBuilder ) {
        return configurationBuilder
                .nameField("role" ).pluralName("Roles").singularName("Role").build();
    }

    public FieldSetConfigurationUnit listView( FieldSetConfigurationUnitBuilder fragmentBuilder ) {
        return fragmentBuilder
                .field("role").caption("Role").build();
    }

    public FieldSetConfigurationUnit quickView( FieldSetConfigurationUnitBuilder fragmentBuilder ) {
        return fragmentBuilder
                .field("role").caption("Role").build();
    }

    public FieldSetConfigurationUnit showView( final FieldSetConfigurationUnitBuilder fragmentBuilder ) {
        return fragmentBuilder
                .field("role").caption("Role").build();
    }

    public FieldSetConfigurationUnit formView( final PersistentFieldSetConfigurationUnitBuilder fragmentBuilder ) {
        return fragmentBuilder
                .field("role").caption("Role").build();
    }

   /* public FiltersConfigurationUnit filters( final FiltersConfigurationUnitBuilder filterBuilder ) {
        return filterBuilder
                .filter("Name", "name").filter("Customers", "accounts").build();
    }

    public ScopesConfigurationUnit scope(ScopesConfigurationUnitBuilder scopeBuilder){
        return scopeBuilder
                .scope("All", all())
                .scope("Admins Filter", filter(new AdminTypeFilter()))
                .scope("Not Admins Specification", specification(new AdminTypeSpecification(false))).defaultScope().build();
    }*/
}
