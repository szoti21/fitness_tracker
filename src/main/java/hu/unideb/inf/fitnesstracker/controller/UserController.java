package hu.unideb.inf.fitnesstracker.controller;

import hu.unideb.inf.fitnesstracker.data.entity.UserEntity;
import hu.unideb.inf.fitnesstracker.data.repository.BiometricsRepository;
import hu.unideb.inf.fitnesstracker.data.repository.IntakeRepository;
import hu.unideb.inf.fitnesstracker.data.repository.UserRepository;
import hu.unideb.inf.fitnesstracker.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fitness/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private BiometricsRepository biometricsRepository;

    @Autowired
    private IntakeRepository intakeRepository;

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping("")
    public List<UserEntity> getUsers(){
        return userRepository.findAll();
    }

    @PreAuthorize("hasAuthority('admin') or @userService.hasId(#id)")
    @GetMapping("/{id}")
    public UserEntity getById(@PathVariable("id") int id){
        return userRepository.findById(id).orElse(null);
    }

    @PreAuthorize("hasAuthority('admin')")
    @PostMapping("")
    public UserEntity saveUser(@RequestBody UserEntity user){
        return userRepository.save(user);
    }

    @PreAuthorize("hasAuthority('admin') or @userService.hasId(#id)")
    @PutMapping("/{id}")
    public UserEntity updateUser(@PathVariable("id") int id, @RequestBody UserEntity user) {
        if(user.getId() > 0L){
            if(!SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().anyMatch(auth -> auth.getAuthority().equals("admin"))) {
                user.setRole(userRepository.findById(id).get().getRole());
            }
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    @PreAuthorize("hasAuthority('admin')")
    @DeleteMapping("/{id}")
    @Transactional
    public void deleteUser(@PathVariable("id") int id){
        intakeRepository.deleteAllByUserId(id);
        biometricsRepository.deleteAllByUserId(id);
        userRepository.deleteById(id);
    }
}
