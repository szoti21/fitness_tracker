package hu.unideb.inf.fitnesstracker.data.repository;

import hu.unideb.inf.fitnesstracker.data.entity.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, Integer> {
}
