package nl.test.motor.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "t_motor")
public class Motor implements Serializable {

   @Id
   @GeneratedValue(generator = "motor_generator")
   @SequenceGenerator(
         name = "motor_generator",
         sequenceName = "motor_sequence"
   )
   private Long id;
   private String name;
   private String type;

   public Motor() { }

   private Motor(String name, String type) {
      this.name = name;
      this.type = type;
   }

   public static Motor createNaked(String name) {
      return new Motor(name, "Naked");
   }

   public static Motor createTour(String name) {
      return new Motor(name, "Tour");
   }

   public static Motor createSupersport(String name) {
      return new Motor(name, "Supersport");
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }
}
