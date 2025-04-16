package pl.javastart.bikerent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BikerentApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BikerentApplication.class, args);
        NewBikeDTO bike1 = new NewBikeDTO(1L, "Kross ESker 4.0, 29 inch male", "KRS12345", 30, 100);
        BikeService bikeService = context.getBean(BikeService.class);
        bikeService.add(bike1);
        double payment = bikeService.rentForHours(1L, 5, "asc1234");
        System.out.println("to pay for rent: " + payment);
        bikeService.returnBike(1L);




        /*System.out.println("Saved in Database Bike1");
        Bike bike2 = new Bike(2L,"Trek Marlin 7, 26 inch female", "THM12345", 25, 80);
        bikeRepository.save(bike2);
        System.out.println("Saved in Database bike2");

        System.out.println("I fetch and display bike2");
        bikeRepository.findById(2L).ifPresent(System.out::println);

        System.out.println("I delete bike1 from the database");
        bikeRepository.deleteById(1L);

        System.out.println("I fetch and display bike1");
        bikeRepository.findById(1L).ifPresentOrElse(System.out::println, () -> System.out.println("There is no bike with ID 1"));
*/
    }

}
