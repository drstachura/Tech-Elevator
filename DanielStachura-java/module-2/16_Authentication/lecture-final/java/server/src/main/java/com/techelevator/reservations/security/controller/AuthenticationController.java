package com.techelevator.reservations.security.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techelevator.reservations.security.controller.dto.LoginDto;
import com.techelevator.reservations.security.jwt.JWTFilter;
import com.techelevator.reservations.security.jwt.TokenProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Controller to authenticate users.
 */
@RestController
public class AuthenticationController {

    private final TokenProvider tokenProvider;

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public AuthenticationController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    @PostMapping("/login")  // alternative to @RequestMapping(path="/login",method=RequestMethod.POST)
    // This method will handle login requests for the application
    // It returns a JWT and receives a DTO containing the user nameand password
    //    a DataTransferObject is a POJO to share data that is not Application data
    // @Valid - tells the server to apply any validation annotations in the POJO before accepting it
    // @RequestBody - tells the server to take the JSON out of the request body and instantiate an object
    public ResponseEntity<JWTToken> authorize(@Valid @RequestBody LoginDto loginDto) {

        // we are using classes and methods provided by Java to handle the authentication and authorization we need
        // we will not be going in detail on the internal workings of any of them
        // we will focus on how to use them

        // instantiate an authenication object to hold the username and password
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());

        // instantiate an authentication object to manage authentication
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // set the rememberme boolean based on the value in the LoginDto
        // if rememberme is NOT in the LoginDto set it to false, if it is set it to teh value in the LoginDto
        boolean rememberMe = (loginDto.isRememberMe() == null) ? false : loginDto.isRememberMe();

        // Use the JWT tokenProvider to generate a JWT with the username, password and rememberme we have
        // We put the username and password in teh object called authentication
        String jwt = tokenProvider.createToken(authentication, rememberMe);

        // Create a response object with the JWT and return it
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JWTFilter.AUTHORIZATION_HEADER, "Bearer " + jwt);
        return new ResponseEntity<>(new JWTToken(jwt), httpHeaders, HttpStatus.OK);
    }

    /**
     * Object to return as body in JWT Authentication.
     */
    static class JWTToken {

        private String token;

        JWTToken(String token) {
            this.token = token;
        }

        @JsonProperty("token")
        String getToken() {
            return token;
        }

        void setToken(String token) {
            this.token = token;
        }
    }
}

