package pl.javastart.bikerent;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BikeService {
    private final BikeRepository bikeRepository;

    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    @Transactional
    public void add(BikeDTO newBike){
        Bike bike = new Bike(newBike.getId(),
                newBike.getModel(),
                newBike.getSerialNo(),
                newBike.getHourPrice(),
                newBike.getDayPrice());
        bikeRepository.save(bike);
    }

    @Transactional
    public void deleteById(Long bikeId){
        bikeRepository.deleteById(bikeId);
    }

    @Transactional
    public double rentForHours(String serialNo, int hours, String borrowerId){
        LocalDateTime dateOfReturn = LocalDateTime.now().plusHours(hours);
        Bike bike = updateBike(serialNo, dateOfReturn, borrowerId);
        return bike.getHourPrice() * hours;
    }

    private Bike updateBike(String serialNo, LocalDateTime dateOfReturn,String borrowerId ) {
        Bike bike = bikeRepository.findBySerialNoIgnoreCase(serialNo)
                .orElseThrow(BikeNotFoundException::new);
        bike.setDateOfReturn(dateOfReturn);
        bike.setBorrowerId(borrowerId);
        bikeRepository.save(bike);
        return bike;
    }

    @Transactional
    public double rentForDay(String serialNo, String borrowerId){
        LocalDateTime dateOfReturn = LocalDateTime.now().withHour(23).withMinute(59);
        Bike bike = updateBike(serialNo, dateOfReturn, borrowerId);
        return bike.getDayPrice();
    }

    @Transactional
    public void returnBike(String serialNo){
        updateBike(serialNo,null,null);
    }

    public int countBorrowedBikes(){
        return bikeRepository.countAllByBorrowerIdIsNotNull();
    }

    public List<BikeDTO> findAllAvailableBikes(){
        return bikeRepository.findAllByBorrowerIdIsNullOrderByDayPrice()
                .stream().map(bike-> new BikeDTO(
                        bike.getId(),
                        bike.getModel(),
                        bike.getSerialNo(),
                        bike.getHourPrice(),
                        bike.getDayPrice()
                )).collect(Collectors.toList());
    }
}
