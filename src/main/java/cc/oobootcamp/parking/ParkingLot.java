package cc.oobootcamp.parking;


import java.util.ArrayList;
import java.util.List;

class ParkingLot {
    private int emptySpace;
    private int totalSpace;
    private List<Car> parkedCars = new ArrayList<>();

    ParkingLot(int totalSpace) {
        this.totalSpace = totalSpace;
        this.emptySpace = totalSpace;
    }

    String checkSpace() {
        if (emptySpace > 0) {
            return "there has empty space in parking lot";
        }
        return "parking lot is full, sorry";
    }

    Ticket park(Car car) {
        parkedCars.add(car);
        this.emptySpace = totalSpace - parkedCars.size();
        return new Ticket(car.getCarId());
    }

    String takeCar(Ticket ticket) {
        if (hasCar(ticket.getCarId())) {
            return "farewell";
        }
        return "you got the wrong ticket!";
    }

    private boolean hasCar(String carId) {
        return parkedCars.stream()
                .anyMatch(car -> car.getCarId().equals(carId));
    }
}
