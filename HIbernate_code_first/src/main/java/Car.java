import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue("car")
public class Car extends Vehicle {
    private static final String TYPE = "car";
    @Column(name = "seats")
    private int seats;

    public Car(int seats) {
    }

    public Car(String model, BigDecimal price, String fuelType, int seats) {
        super(TYPE, model, price, fuelType);
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
}
