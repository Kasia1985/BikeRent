
# Bike Rent – Simple Java Bike Rental App

A simple Spring Boot application for renting bikes. Users can add bikes, rent them by the hour or by the day, return them, and remove them from the database. The application uses JPA for persistence and an in-memory database for demonstration purposes.

> 📚 **This project was created as part of the [JavaStart](https://javastart.pl) Spring Boot course.**

---

## 🚲 Features

- Add new bikes  
- Rent bikes for a number of hours  
- Rent bikes for the day (until 23:59)  
- Return bikes  
- Delete bikes by ID  
- Calculate rental price based on time

---

## 🛠 Technologies Used

- Java 17+  
- Spring Boot  
- JPA (Hibernate)  
- H2 Database (or other)

---

## 🚀 Getting Started

### Prerequisites

- Java 17+  
- Maven or Gradle  
- IDE (e.g., IntelliJ IDEA or Eclipse)

### Installation

1. Clone the repository  
   ```bash
   git clone https://github.com/your-username/bike-rent.git
   cd bike-rent
2. Open the project in your IDE  
3. Run the `DemoJpaApplication.java` class  

---

### 💡 Usage Example

```java
NewBikeDTO bike1 = new NewBikeDTO(1L, "Kross Esker 4.0", "KRS12345", 30, 100);
bikeService.add(bike1);

double payment = bikeService.rentForHours(1L, 5, "asc1234");
System.out.println("To pay for rent: " + payment);

bikeService.returnBike(1L);
```
---

### 📂 Project Structure

- `Bike` – entity class representing a bike  
- `BikeRepository` – custom repository using `EntityManager`  
- `BikeService` – business logic for renting and returning bikes  
- `DemoJpaApplication` – main application class  
- `NewBikeDTO` – data transfer object for new bikes  

---

### ⚠ Notes
- Detached entities must be merged before removal to attach them to the persistence context.
- Example logic is included in the main method but commented for demonstration.

---

### 👤 Author

Created as part of the **JavaStart Spring Boot** course.


