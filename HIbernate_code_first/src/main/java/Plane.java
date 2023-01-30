import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue("plane")
public class Plane extends Vehicle {
    private static final String TYPE = "plane";

    @Column(name = "passenger_capacity")
    private int passengerCapacity;

    public Plane() {
    }

    public Plane(String model, BigDecimal price, String fuelType, int passengerCapacity) {
        super(TYPE, model, price, fuelType);
        this.passengerCapacity = passengerCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
}
