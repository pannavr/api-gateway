package com.userservice.service.serviceImpl;

import com.userservice.Repository.UserAccountRepository;
import com.userservice.Repository.UserInformationRepository;
import com.userservice.entity.UserAccount;
import com.userservice.entity.UserInformation;
import com.userservice.model.RegisterRequestDTO;
import com.userservice.model.UserInformationDTO;
import com.userservice.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class UserInformationServiceImpl implements UserInformationService {

    @Autowired
    UserAccountRepository userAccountRepository;

    @Autowired
    UserInformationRepository userInformationRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserInformationDTO findByID(Integer id) {
        return null;
    }

    @Override
    public RegisterRequestDTO saveData(RegisterRequestDTO registerRequestDTO) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilBirthDate = dateFormat.parse(registerRequestDTO.getBirthDate());
        Date birthDate = new Date(utilBirthDate.getTime()); // Convert to java.sql.Date
        Date currentDate = new Date(System.currentTimeMillis());

        UserInformation userInformation = new UserInformation();
        userInformation.setFullName(registerRequestDTO.getFullName());
        userInformation.setEmail(registerRequestDTO.getEmail());
        userInformation.setBirthDate(birthDate);
        userInformation.setGender(registerRequestDTO.getGender());
        userInformation.setCreateDate(currentDate);
        userInformation.setModifiedDate(currentDate);
        userInformation.setActive(1);
        userInformation = userInformationRepository.save(userInformation);

        UserAccount userAccount = new UserAccount();
        userAccount.setUserName(registerRequestDTO.getUserName());
        userAccount.setPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));
        userAccount.setActive(1);
        userAccount.setCreateDate(currentDate);
        userAccount.setModifiedDate(currentDate);
        userAccount.setUserInformation(userInformation);
        userAccountRepository.save(userAccount);
        return registerRequestDTO;
    }

    @Override
    public String validateToken(String token) {
        return null;
    }

    @Override
    public Optional<UserAccount> findByUserName(String userName) {
        return userAccountRepository.findByUserName(userName);
    }
}
