package hu.unideb.inf.fitnesstracker.controller;

import hu.unideb.inf.fitnesstracker.data.entity.BiometricsEntity;
import hu.unideb.inf.fitnesstracker.data.repository.BiometricsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("fitness/users/{userId}/biometrics")
public class BiometricsController {
    @Autowired
    private BiometricsRepository biometricsRepository;

    @GetMapping("")
    public List<BiometricsEntity> getBiometrics(@PathVariable("userId") int userId){
        return biometricsRepository.findByUserIdOrderByDate(userId);
    }

    @GetMapping("/{date}")
    public BiometricsEntity getByUserIdAndDate(@PathVariable("userId") int userId, @PathVariable("date") Long date){
        return biometricsRepository.findByUserIdAndDate(userId, new Date(date));
    }
    @PostMapping("")
    public BiometricsEntity saveBiometrics(@PathVariable("userId") int userId, @RequestBody BiometricsEntity biometrics){
        biometrics.setUserId(userId);
        return biometricsRepository.save(biometrics);
    }

    @PutMapping("/{date}")
    @Transactional
    public BiometricsEntity updateBiometrics(@PathVariable("userId") int id, @PathVariable("date") Long date, @RequestBody BiometricsEntity biometrics) {
        if(biometrics.getDate() != null){
            BiometricsEntity updatedBiometrics = biometricsRepository.save(biometrics);
            deleteBiometrics(id, date);
            return updatedBiometrics;
        } else {
            return null;
        }
    }

    @DeleteMapping("/{date}")
    @Transactional
    public void deleteBiometrics(@PathVariable("userId") int userId, @PathVariable("date") Long date){
        biometricsRepository.deleteByUserIdAndDate(userId, new Date(date));
    }
}
