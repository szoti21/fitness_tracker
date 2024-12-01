package hu.unideb.inf.fitnesstracker.data.repository;

import hu.unideb.inf.fitnesstracker.data.entity.IntakeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IntakeRepository extends JpaRepository<IntakeEntity, Integer> {
    List<IntakeEntity> findByUserIdOrderByDate(int userId);
    IntakeEntity findByUserIdAndDate(int userId, Date date);
    void deleteByUserIdAndDate(int userId, Date date);
}
