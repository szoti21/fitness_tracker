package hu.unideb.inf.fitnesstracker.controller;

import hu.unideb.inf.fitnesstracker.data.entity.IntakeEntity;
import hu.unideb.inf.fitnesstracker.data.repository.IntakeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/fitness/users/{userId}/intake")
public class IntakeController {
    @Autowired
    private IntakeRepository intakeRepository;

    @PreAuthorize("hasAuthority('admin') or @userService.hasId(#userId)")
    @GetMapping("")
    public List<IntakeEntity> getIntake(@PathVariable("userId") int userId){
        return intakeRepository.findByUserIdOrderByDate(userId);
    }

    @PreAuthorize("hasAuthority('admin') or @userService.hasId(#userId)")
    @GetMapping("/{date}")
    public IntakeEntity getByUserIdAndDate(@PathVariable("userId") int userId, @PathVariable("date") Long date){
        return intakeRepository.findByUserIdAndDate(userId, new Date(date));
    }

    @PreAuthorize("hasAuthority('admin') or @userService.hasId(#userId)")
    @PostMapping("")
    public IntakeEntity saveIntake(@PathVariable("userId") int userId, @RequestBody IntakeEntity intake){
        intake.setUserId(userId);
        return intakeRepository.save(intake);
    }

    @PreAuthorize("hasAuthority('admin') or @userService.hasId(#userId)")
    @PutMapping("/{date}")
    @Transactional
    public IntakeEntity updateIntake(@PathVariable("userId") int userId, @PathVariable("date") Long date, @RequestBody IntakeEntity intake) {
        if(intake.getDate() != null){
            IntakeEntity updatedIntake = intakeRepository.save(intake);
            deleteIntake(userId, date);
            return intakeRepository.save(updatedIntake);
        } else {
            return null;
        }
    }

    @PreAuthorize("hasAuthority('admin') or @userService.hasId(#userId)")
    @DeleteMapping("/{date}")
    @Transactional
    public void deleteIntake(@PathVariable("userId") int userId, @PathVariable("date") Long date){
        intakeRepository.deleteByUserIdAndDate(userId, new Date(date));
    }
}
