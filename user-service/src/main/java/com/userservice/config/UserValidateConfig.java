package com.userservice.config;

import com.userservice.Repository.UserAccountRepository;
import com.userservice.entity.UserAccount;
import com.userservice.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserValidateConfig implements UserDetailsService {

    @Autowired
    private UserInformationService userInformationService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<UserAccount> userInformation = userInformationService.findByUserName(username);
        return userInformation.map(UserInformationConfig::new).orElseThrow(() -> new UsernameNotFoundException("user not found with name :" + username));
    }
}
