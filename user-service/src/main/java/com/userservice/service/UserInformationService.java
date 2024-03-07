package com.userservice.service;

import com.userservice.entity.UserAccount;
import com.userservice.model.RegisterRequestDTO;
import com.userservice.model.UserInformationDTO;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Optional;

@Service
public interface UserInformationService {

    public UserInformationDTO findByID(Integer id);

    public RegisterRequestDTO saveData(RegisterRequestDTO registerRequestDTO) throws ParseException;

    public String validateToken(String token);

    public Optional<UserAccount> findByUserName(String userName);

}
