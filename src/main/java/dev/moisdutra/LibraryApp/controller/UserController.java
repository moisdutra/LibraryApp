package dev.moisdutra.LibraryApp.controller;

import dev.moisdutra.LibraryApp.model.UserModel;
import dev.moisdutra.LibraryApp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/listusers")
    public ResponseEntity<List<UserModel>> listUsers() {
        List<UserModel> users = userService.listUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/listuser/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        UserModel user = userService.listUserById(id);
        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
    }

    @PostMapping("/adduser")
    public ResponseEntity<UserModel> addUser(@RequestBody UserModel newUser) {
        UserModel user = userService.createUser(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PatchMapping("/updateuser/{id}")
    public ResponseEntity<?> updateUser(
            @PathVariable Long id,
            @RequestBody UserModel updatedUser
    ) {
        UserModel user = userService.updateUser(id, updatedUser);
        if (user != null) {
            return ResponseEntity.status(HttpStatus.OK).body(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
    }

    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        if (userService.listUserById(id) != null) {
            userService.deleteUser(id);
            return ResponseEntity.status(HttpStatus.OK).body("User deleted.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
    }

}
