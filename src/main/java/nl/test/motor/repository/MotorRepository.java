package nl.test.motor.repository;

import nl.test.motor.entity.Motor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorRepository extends JpaRepository<Motor, Long> {
   Motor findByName(String name);
}
