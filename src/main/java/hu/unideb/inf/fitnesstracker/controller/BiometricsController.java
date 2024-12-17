package hu.unideb.inf.fitnesstracker.controller;

import hu.unideb.inf.fitnesstracker.data.entity.BiometricsEntity;
import hu.unideb.inf.fitnesstracker.data.repository.BiometricsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("fitness/users/{userId}/biometrics")
public class BiometricsController {
    @Autowired
    private BiometricsRepository biometricsRepository;

    @PreAuthorize("hasAuthority('admin') or @userService.hasId(#userId)")
    @GetMapping("")
    public List<BiometricsEntity> getBiometrics(@PathVariable("userId") int userId){
        return biometricsRepository.findByUserIdOrderByDate(userId);
    }

    @PreAuthorize("hasAuthority('admin') or @userService.hasId(#userId)")
    @GetMapping("/{date}")
    public BiometricsEntity getByUserIdAndDate(@PathVariable("userId") int userId, @PathVariable("date") Long date){
        return biometricsRepository.findByUserIdAndDate(userId, new Date(date));
    }

    @PreAuthorize("hasAuthority('admin') or @userService.hasId(#userId)")
    @PostMapping("")
    public BiometricsEntity saveBiometrics(@PathVariable("userId") int userId, @RequestBody BiometricsEntity biometrics){
        biometrics.setUserId(userId);
        return biometricsRepository.save(biometrics);
    }

    @PreAuthorize("hasAuthority('admin') or @userService.hasId(#userId)")
    @PutMapping("/{date}")
    @Transactional
    public BiometricsEntity updateBiometrics(@PathVariable("userId") int userId, @PathVariable("date") Long date, @RequestBody BiometricsEntity biometrics) {
        if(biometrics.getDate() != null){
            BiometricsEntity updatedBiometrics = biometrics;
            deleteBiometrics(userId, date);
            return biometricsRepository.save(updatedBiometrics);
        } else {
            return null;
        }
    }

    @PreAuthorize("hasAuthority('admin') or @userService.hasId(#userId)")
    @DeleteMapping("/{date}")
    @Transactional
    public void deleteBiometrics(@PathVariable("userId") int userId, @PathVariable("date") Long date){
        biometricsRepository.deleteByUserIdAndDate(userId, new Date(date));
    }
}
