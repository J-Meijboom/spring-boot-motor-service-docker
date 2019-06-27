package nl.test.motor.rest;

import nl.test.motor.entity.Motor;
import nl.test.motor.service.MotorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class MotorController {

   @Autowired private MotorService motorService;

   @GetMapping("motors")
   public List<Motor> getMotors() {
      return motorService.findAll();
   }

   @GetMapping("/motors/{name}")
   public Motor getMotorByName(@PathVariable String name) {
      return motorService.findByName(name);
   }

   @PostMapping("/motors")
   public Motor insert(@RequestBody Motor motorRequest) {
      return motorService.save(motorRequest);
   }

   @PutMapping("/motors/{id}")
   public Motor update(@PathVariable Long id, @RequestBody  Motor motorRequest) {
      return motorService.update(id, motorRequest);
   }

   @DeleteMapping("/motors/{id}")
   public ResponseEntity<?> delete(@PathVariable Long id) {
      return motorService.delete(id);
   }

}
