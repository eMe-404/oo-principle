package cc.oobootcamp.parking;

import java.util.Objects;

public class Car {
    private String carId;

    public Car(String carId) {
        this.carId = carId;
    }

    public String getCarId() {
        return carId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return carId.equals(car.carId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId);
    }
}
