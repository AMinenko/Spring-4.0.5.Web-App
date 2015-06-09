package com.anmi.webapp.services.ligtadmin;

import com.anmi.webapp.entity.DiscountProgram;
import com.anmi.webapp.services.ligtadmin.scopes.AdminTypeFilter;
import com.anmi.webapp.services.ligtadmin.scopes.AdminTypeSpecification;
import org.lightadmin.api.config.AdministrationConfiguration;
import org.lightadmin.api.config.builder.*;
import org.lightadmin.api.config.unit.EntityMetadataConfigurationUnit;
import org.lightadmin.api.config.unit.FieldSetConfigurationUnit;
import org.lightadmin.api.config.unit.FiltersConfigurationUnit;
import org.lightadmin.api.config.unit.ScopesConfigurationUnit;

import static org.lightadmin.api.config.utils.ScopeMetadataUtils.all;
import static org.lightadmin.api.config.utils.ScopeMetadataUtils.filter;
import static org.lightadmin.api.config.utils.ScopeMetadataUtils.specification;

public class DiscountProgramAdministration extends AdministrationConfiguration<DiscountProgram> {

    public  EntityMetadataConfigurationUnit configuration( EntityMetadataConfigurationUnitBuilder configurationBuilder ) {
        return configurationBuilder
                .nameField( "discount" ).pluralName("Discounts").singularName("Discount").build();
    }

    public FieldSetConfigurationUnit listView( FieldSetConfigurationUnitBuilder fragmentBuilder ) {
        return fragmentBuilder
                .field( "name" ).caption("Name").field("accounts").caption("Customers").build();
    }

    public FieldSetConfigurationUnit quickView( FieldSetConfigurationUnitBuilder fragmentBuilder ) {
        return fragmentBuilder
                .field( "name" ).caption( "Name" ).field("accounts").caption( "Customers" ).build();
    }

    public FieldSetConfigurationUnit showView( final FieldSetConfigurationUnitBuilder fragmentBuilder ) {
        return fragmentBuilder
                .field( "name" ).caption( "Name" ).field("accounts").caption( "Customers" ).build();
    }

    public FieldSetConfigurationUnit formView( final PersistentFieldSetConfigurationUnitBuilder fragmentBuilder ) {
        return fragmentBuilder
                .field( "name" ).caption( "Name" ).field("accounts").caption( "Customers" ).build();
    }

    public FiltersConfigurationUnit filters( final FiltersConfigurationUnitBuilder filterBuilder ) {
        return filterBuilder
                .filter("Name", "name").filter("Customers", "accounts").build();
    }

    public ScopesConfigurationUnit scope(ScopesConfigurationUnitBuilder scopeBuilder){
        return scopeBuilder
                .scope("All", all())
                .scope("Admins Filter", filter(new AdminTypeFilter()))
                .scope("Not Admins Specification", specification(new AdminTypeSpecification(false))).defaultScope().build();
    }
}
