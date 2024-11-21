package hu.unideb.inf.fitnesstracker.controller;

import hu.unideb.inf.fitnesstracker.data.entity.BiometricsEntity;
import hu.unideb.inf.fitnesstracker.data.repository.BiometricsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("fitness/users")
public class BiometricsController {
    @Autowired
    private BiometricsRepository biometricsRepository;

    @GetMapping("{userId}/biometrics")
    public List<BiometricsEntity> getBiometrics(@PathVariable("userId") int userId){
        return biometricsRepository.findByUserIdOrderByDateDesc(userId);
    }

    @PostMapping("/biometrics")
    public BiometricsEntity saveBiometrics(@RequestBody BiometricsEntity biometrics){
        return biometricsRepository.save(biometrics);
    }
}
