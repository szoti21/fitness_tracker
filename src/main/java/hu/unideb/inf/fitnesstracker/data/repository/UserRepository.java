package hu.unideb.inf.fitnesstracker.data.repository;

import hu.unideb.inf.fitnesstracker.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
