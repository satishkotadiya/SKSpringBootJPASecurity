package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * Created by ksatish on 01-02-2018.
 */
@Service
public class SecurityUtils {

    /*@Autowired
    static AuthenticationTrustResolver authenticationTrustResolver;*/

    public static boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder
                .getContext().getAuthentication();
        return authentication instanceof AnonymousAuthenticationToken;
//        AuthenticationTrustResolver authenticationTrustResolver = new AuthenticationTrustResolverImpl();
//        return authenticationTrustResolver.isAnonymous(authentication);
    }

    public static String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

}
