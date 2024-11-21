package hu.unideb.inf.fitnesstracker.controller;

import hu.unideb.inf.fitnesstracker.data.entity.FoodEntity;
import hu.unideb.inf.fitnesstracker.data.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fitness/food")
public class FoodController {
    @Autowired
    private FoodRepository foodRepository;

    @GetMapping("")
    public List<FoodEntity> getFood(){
        return foodRepository.findAll();
    }

    @PostMapping()
    public FoodEntity saveFood(@RequestBody FoodEntity food) {
        return foodRepository.save(food);
    }
}
