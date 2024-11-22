package hu.unideb.inf.fitnesstracker.controller;

import hu.unideb.inf.fitnesstracker.data.entity.FoodEntity;
import hu.unideb.inf.fitnesstracker.data.repository.FoodRepository;
import jakarta.transaction.Transactional;
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

    @GetMapping("/{id}")
    public FoodEntity getById(@PathVariable("id") int id){
        return foodRepository.findById(id).orElse(null);

    }
    @PostMapping()
    public FoodEntity saveFood(@RequestBody FoodEntity food) {
        return foodRepository.save(food);
    }

    @PutMapping("/{id}")
    public FoodEntity updateFood(@RequestBody FoodEntity food) {
        if(food.getId() > 0L){
            return foodRepository.save(food);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteFood(@PathVariable("id") int id){
        foodRepository.deleteById(id);

    }
}
