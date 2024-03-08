package com.userservice.controller;

import com.userservice.model.LoginDTO;
import com.userservice.model.RegisterRequestDTO;
import com.userservice.model.ResponseDataDTO;
import com.userservice.service.AuthService;
import com.userservice.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
public class RestUserController {


    @Autowired
    UserInformationService userInformationService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    AuthService authService;

    @PostMapping("/auth/register")
    public ResponseEntity<ResponseDataDTO> register(@RequestBody RegisterRequestDTO registerRequestDTO) throws ParseException {
        ResponseDataDTO responseDataDTO = new ResponseDataDTO();
        responseDataDTO.setStatus("success");
        responseDataDTO.setData(userInformationService.saveData(registerRequestDTO));
        return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<ResponseDataDTO> getToken(@RequestBody LoginDTO loginDTO) {
        ResponseDataDTO responseDataDTO = new ResponseDataDTO();
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUserName(), loginDTO.getPassword()));
        if (authenticate.isAuthenticated()) {
            responseDataDTO.setStatus("success");
            responseDataDTO.setData(authService.generateToken(loginDTO.getUserName()));
        } else {
            throw new RuntimeException("invalid access");
        }
        return new ResponseEntity<>(responseDataDTO, HttpStatus.OK);

    }
    @GetMapping("/auth/validate")
    public String validateToken(@RequestParam("token") String token) {
        authService.validateToken(token);
        return "Token is valid";
    }

}
