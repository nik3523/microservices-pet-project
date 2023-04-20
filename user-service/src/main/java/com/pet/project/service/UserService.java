package com.pet.project.service;

import com.pet.project.common.AdditionDirection;
import com.pet.project.entity.User;
import com.pet.project.exception.EntityNotFoundException;
import com.pet.project.repository.UserRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.pet.project.common.AdditionDirection.DECREMENT;

@Service
@Log
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException(id);
        }
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public int countNewPost(Long id, AdditionDirection direction) {
        log.info("Change amount of posts for User id: " + id + " direction: " + direction);
        User userById = getUserById(id);
        int amountOfPosts = userById.getAmountOfPosts();
        if (DECREMENT.equals(direction)) {
            amountOfPosts--;
        } else {
            amountOfPosts++;
        }
        userById.setAmountOfPosts(amountOfPosts);
        return userRepository.save(userById).getAmountOfPosts();
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
