package pl.javastart.bikerent;

public class BikeDTO {
    private Long id;
    private String model;
    private String serialNo;
    private double hourPrice;
    private double dayPrice;

    public BikeDTO(Long id, String model, String serialNo, double hourPrice, double dayPrice) {
        this.id = id;
        this.model = model;
        this.serialNo = serialNo;
        this.hourPrice = hourPrice;
        this.dayPrice = dayPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public double getHourPrice() {
        return hourPrice;
    }

    public void setHourPrice(double hourPrice) {
        this.hourPrice = hourPrice;
    }

    public double getDayPrice() {
        return dayPrice;
    }

    public void setDayPrice(double dayPrice) {
        this.dayPrice = dayPrice;
    }

    @Override
    public String toString() {
        return "BikeDTO{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", serialNo='" + serialNo + '\'' +
                ", hourPrice=" + hourPrice +
                ", dayPrice=" + dayPrice +
                '}';
    }
}
