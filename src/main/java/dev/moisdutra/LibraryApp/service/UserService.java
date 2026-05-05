package dev.moisdutra.LibraryApp.service;

import dev.moisdutra.LibraryApp.model.UserModel;
import dev.moisdutra.LibraryApp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create User
    public UserModel createUser(UserModel userModel) {
        return userRepository.save(userModel);
    }

    // List all Users
    public List<UserModel> listUsers() {
        return userRepository.findAll();
    }

    // List User by ID
    public UserModel listUserById(Long id) {
        Optional<UserModel> user = userRepository.findById(id);
        return user.orElse(null);
    }

    // Update User
    public UserModel updateUser(Long id, UserModel userModel) {
        UserModel user = listUserById(id);
        if (user != null) {
            if (userModel.getFirstName() != null) {
                user.setFirstName(userModel.getFirstName());
            }
            if (userModel.getLastName() != null) {
                user.setLastName(userModel.getLastName());
            }
            if (userModel.getEmail() != null) {
                user.setEmail(userModel.getEmail());
            }
            if (userModel.getPassword() != null) {
                user.setPassword(userModel.getPassword());
            }
            if (userModel.getRole() != null) {
                user.setRole(userModel.getRole());
            }
            if (userModel.getRole() != null) {
                user.setActive(userModel.getActive());
            }

            userRepository.save(user);
            return user;
        } else  {
            return null;
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
