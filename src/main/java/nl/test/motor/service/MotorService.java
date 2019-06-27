package nl.test.motor.service;

import nl.test.motor.entity.Motor;
import nl.test.motor.repository.MotorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class MotorService {

   @Autowired
   private MotorRepository motorRepository;

   public Motor findByName(String name) {
      return motorRepository.findByName(name);
   }

   public List<Motor> findAll() {
      return motorRepository.findAll();
   }

   public Motor save(Motor motor) {
      return motorRepository.save(motor);
   }

   public Motor update(Long id, Motor motorRequest) {
      return motorRepository.findById(id)
            .map(motor -> {
               motor.setName(motorRequest.getName());
               motor.setType(motorRequest.getType());

               return motorRepository.save(motor);
            }).orElseThrow(() -> new EntityNotFoundException("Motor not found with id " + id));
   }

   public ResponseEntity<?> delete(Long id) {
      return motorRepository.findById(id)
            .map(motor -> {
               motorRepository.delete(motor);
               return ResponseEntity.ok().build();
            }).orElseThrow(() -> new EntityNotFoundException("Motor not found with id " + id));
   }
}
