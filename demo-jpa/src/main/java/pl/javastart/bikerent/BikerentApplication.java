package pl.javastart.bikerent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BikerentApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BikerentApplication.class, args);
        BikeDTO bike1 = new BikeDTO(1L, "Kross ESker 4.0, 29 inch male", "KRS12345", 30, 100);
        BikeDTO bike2 = new BikeDTO(2L, "Merida Kalahari 2020, 29 inch female", "MFR4767", 25, 80);
        BikeDTO bike3 = new BikeDTO(3L, "Trek XSPeed 2, 29 inch male", "MKSFBGF123", 40, 150);
        BikeDTO bike4 = new BikeDTO(4L, "Superior XR Super, 26 inch female", "POZ123", 30, 100);
        BikeService bikeService = context.getBean(BikeService.class);
        bikeService.add(bike1);
        bikeService.add(bike2);
        bikeService.add(bike3);
        bikeService.add(bike4);
        double payment = bikeService.rentForDay("MKSFBGF123","ABC1234");
        System.out.println("to pay for rent: " + payment);

        int borrowedBikes = bikeService.countBorrowedBikes();
        System.out.println("amount of borrowed bikes: "+ borrowedBikes);

        System.out.println("Available bikes (by increasing price):");
        bikeService.findAllAvailableBikes().forEach(System.out::println);



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
