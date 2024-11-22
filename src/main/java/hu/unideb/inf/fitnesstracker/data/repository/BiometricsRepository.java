package hu.unideb.inf.fitnesstracker.data.repository;

import hu.unideb.inf.fitnesstracker.data.entity.BiometricsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BiometricsRepository extends JpaRepository<BiometricsEntity, Integer> {
    List<BiometricsEntity> findByUserIdOrderByDateDesc(int userId);
}