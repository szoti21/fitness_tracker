package hu.unideb.inf.fitnesstracker.service;


import hu.unideb.inf.fitnesstracker.data.entity.UserEntity;
import hu.unideb.inf.fitnesstracker.data.repository.UserRepository;
import hu.unideb.inf.fitnesstracker.service.dto.LoginDto;
import hu.unideb.inf.fitnesstracker.service.dto.RegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService{
    @Autowired
    UserRepository repo;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    AuthenticationManager manager;

    @Autowired
    JwtService jwtService;

    public String registration(RegistrationDto dto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(dto.getName());
        userEntity.setEmailAddress(dto.getEmailAddress());
        userEntity.setPassword(encoder.encode(dto.getPassword()));
        userEntity.setBirthDate(dto.getBirthDate());
        userEntity.setPhone(dto.getPhone());
        /*if (role != null) {
            userEntity.setRoles(Set.of(role));
        } else {
            role = new RoleEntity(null, "USER");
            role = roleRepo.save(role);
            userEntity.setRole(Set.of(role));
        }*/

        userEntity = repo.save(userEntity);

        return jwtService.generateToken(userEntity, userEntity.getId());

    }

    public String login(LoginDto dto) {
        manager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getEmailAddress(),dto.getPassword())
        );
        var user = repo.findByEmailAddress(dto.getEmailAddress());
        return jwtService.generateToken(user, user.getId());
    }
}
