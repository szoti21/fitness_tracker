package hu.unideb.inf.fitnesstracker.controller;

import hu.unideb.inf.fitnesstracker.data.entity.UserEntity;
import hu.unideb.inf.fitnesstracker.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fitness/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public List<UserEntity> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public UserEntity getById(@PathVariable("id") int id){
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping("")
    public UserEntity saveUser(@RequestBody UserEntity user){
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    public UserEntity updateUser(@RequestBody UserEntity user) {
        if(user.getId() > 0L){
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id){
        userRepository.deleteById(id);
    }
}
