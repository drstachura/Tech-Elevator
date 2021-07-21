package com.techelevator.hotels.services;

import com.techelevator.hotels.models.LoginDTO;
import org.springframework.http.*;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Map;

public class AuthenticationService {

    private String BASE_URL;
    private RestTemplate restTemplate = new RestTemplate();
    private ConsoleService console = new ConsoleService();

    // ctor will receive the base url for the server from the application program
    public AuthenticationService(String url) {
        this.BASE_URL = url;
    }

    // login method for a user
    // Receives String of credentials and returns a ResponseEnity
    public ResponseEntity<Map> login(String credentials) throws AuthenticationServiceException {
        LoginDTO loginDTO = new LoginDTO(credentials);     // instantiate a LoginDTO with credentials to send to the server
        HttpHeaders headers = new HttpHeaders();           // Create the request headers our HTTP POST to the server
        headers.setContentType(MediaType.APPLICATION_JSON);// Set the content type to indicate we are sending JSON
        HttpEntity<LoginDTO> entity = new HttpEntity<>(loginDTO, headers); // Create a request with the the LoginDTO and headers
        ResponseEntity<Map> response = null;               // hold the response from the request
        try {
            // Call the server /login path with the request containing the LoginDTO
            response = restTemplate.exchange(BASE_URL + "/login", HttpMethod.POST, entity, Map.class);
        } catch(RestClientResponseException ex) {   // If status code is greater than 299
            if (ex.getRawStatusCode() == 401 && ex.getResponseBodyAsString().length() == 0) {
                String message = ex.getRawStatusCode() + " : {\"timestamp\":\"" + LocalDateTime.now() + "+00:00\",\"status\":401,\"error\":\"Invalid credentials\",\"message\":\"Login failed: Invalid username or password\",\"path\":\"/login\"}";
                throw new AuthenticationServiceException(message);
            }
            else {
                String message = ex.getRawStatusCode() + " : " + ex.getResponseBodyAsString();
                throw new AuthenticationServiceException(message);
            }
        }
        return response;  // if teh login to the server was successful, return the response
    }

}
