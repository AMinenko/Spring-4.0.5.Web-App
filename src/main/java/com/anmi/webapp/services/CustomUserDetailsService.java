package com.anmi.webapp.services;

import com.anmi.webapp.entity.Account;
import com.anmi.webapp.entity.Role;
import com.anmi.webapp.services.jpa.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Account account = accountService.findByUserName(userName);
        List<GrantedAuthority> authorities = buildUserAuthority(account.getUserRole());
        return buildUserForAuthentication(account, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Set<Role> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities
        for (Role userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
        }

        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

        return Result;
    }
    private User buildUserForAuthentication(Account account,
                                            List<GrantedAuthority> authorities) {
        return new User(account.getUserName(),
                account.getPassword(), account.isEnabled(),
                true, true, true, authorities);
    }
}
