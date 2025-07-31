package org.budgetmanager.registersetvice.controller;

import lombok.RequiredArgsConstructor;
import org.budgetmanager.registersetvice.entity.AuthRequest;
import org.budgetmanager.registersetvice.entity.LoginResponse;
import org.budgetmanager.registersetvice.entity.UserInfo;
import org.budgetmanager.registersetvice.service.JwtService;
import org.budgetmanager.registersetvice.service.UserInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class UserController {

    private final UserInfoService service;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/addNewUser")
    public ResponseEntity<Map<String, String>> addUser(@RequestBody UserInfo userInfo) {
        service.addUser(userInfo);
        Map<String, String> response = new HashMap<>();
        response.put("message", "User added successfully!");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        String jwt = service.login(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(new LoginResponse(jwt));
    }



    @PostMapping("/generateToken")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("Invalid user request!");
        }
    }
}
