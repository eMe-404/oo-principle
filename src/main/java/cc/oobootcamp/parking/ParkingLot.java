package cc.oobootcamp.parking;


import cc.oobootcamp.car.Car;
import cc.oobootcamp.ticket.Ticket;

import java.util.ArrayList;
import java.util.List;

class ParkingLot {
    private List<Car> parkedCars = new ArrayList<>();
    private int emptySpace;

    ParkingLot(int emptySpace) {
        this.emptySpace = emptySpace;
    }

    Ticket parking(Car car) {
        if (emptySpace > 0) {
            parkedCars.add(car);
            emptySpace --;
            return new Ticket(car.getCarId());
        }
        return null;
    }

    boolean canParking() {
        return emptySpace > 0;
    }

    Car pickUp(Ticket ticket) {
        Car carInParkingLot = parkedCars.stream()
                .filter(car -> car.getCarId().equals(ticket.getCarId()))
                .findFirst()
                .orElse(null);

        if (null != carInParkingLot) {
            parkedCars.remove(carInParkingLot);
            return carInParkingLot;
        }
        return null;
    }

    List<Car> getParkedCars() {
        return parkedCars;
    }

    boolean contains(Car car) {
        Car carInParkingLot = parkedCars.stream()
                .filter(parkedCar -> parkedCar.getCarId().equals(car.getCarId()))
                .findFirst()
                .orElse(null);

        return null != carInParkingLot;
    }

    int getEmptySpace() {
        return emptySpace;
    }
}
