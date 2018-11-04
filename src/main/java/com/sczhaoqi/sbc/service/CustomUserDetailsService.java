package com.sczhaoqi.sbc.service;

import com.sczhaoqi.sbc.beans.AuthorityInfo;
import com.sczhaoqi.sbc.beans.UserInfo;
import org.springframework.security.cas.authentication.CasAssertionAuthenticationToken;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

public class CustomUserDetailsService
        implements UserDetailsService,AuthenticationUserDetailsService<CasAssertionAuthenticationToken>
{
    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException
    {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(userName);
        userInfo.setName("admin");
        Set<AuthorityInfo> authorities = new HashSet<AuthorityInfo>();
        AuthorityInfo authorityInfo = new AuthorityInfo("TEST");
        authorities.add(authorityInfo);
        userInfo.setAuthorities(authorities);
        return userInfo;
    }
    @Override
    public UserDetails loadUserDetails(CasAssertionAuthenticationToken casAssertionAuthenticationToken)
            throws UsernameNotFoundException
    {
        String username = (casAssertionAuthenticationToken.getPrincipal() == null) ? "NONE_PROVIDED" : casAssertionAuthenticationToken.getName();
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setName("admin");
        Set<AuthorityInfo> authorities = new HashSet<AuthorityInfo>();
        AuthorityInfo authorityInfo = new AuthorityInfo("TEST");
        authorities.add(authorityInfo);
        userInfo.setAuthorities(authorities);
        return userInfo;
    }

}
