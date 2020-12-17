package com.informatorio.myblog.controller;

import com.informatorio.myblog.model.User;
import com.informatorio.myblog.repository.UserRepository;
import com.informatorio.myblog.service.UserService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@RestController
@RequestMapping("/api/v1/user")
public class UserController {


    private UserRepository userRepository;
    private UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<?> createUser (@RequestBody User newUser){
        return new ResponseEntity<> (userService.createUser(newUser), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getUser() {
        return new ResponseEntity<>(userService.findUser(), HttpStatus.OK);
    }


    @GetMapping("/city")
    public ResponseEntity<?> getUserByCity() {
        return new ResponseEntity<>(userService.userByCity(), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getUserByDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return new ResponseEntity<>(userService.findCreationDateAfter(date), HttpStatus.OK); }

    @PutMapping("/{userId}")
    public ResponseEntity<?> updateUser (@PathVariable Long userId, @RequestBody User user){

        User updateU = userService.getOne(userId);
        updateU.setName(user.getName());
        updateU.setLastName(user.getLastName());
        updateU.setEmail(user.getEmail());
        updateU.setPassword(user.getPassword());
        updateU.setCountry(user.getCountry());
        updateU.setState(user.getState());
        updateU.setCity(user.getCity());

        return new ResponseEntity<>(userService.updateUser(updateU), HttpStatus.OK);
    }

    @DeleteMapping ("/{userId}")
    public ResponseEntity<?> deleteUser (@PathVariable Long userId) {

        User user = userService.getOne(userId);
        userService.delete(user);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
