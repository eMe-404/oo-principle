package cc.oobootcamp.parking;


class ParkingLot {
    private int emptySpace;
    private int totalSpace;

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
        this.emptySpace = emptySpace - 1;
        return new Ticket(car.getCarId());
    }
}
