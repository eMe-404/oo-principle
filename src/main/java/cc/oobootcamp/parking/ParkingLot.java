package cc.oobootcamp.parking;


class ParkingLot {
    private int emptySpace;

    ParkingLot(int totalEmptySpace) {
        this.emptySpace = totalEmptySpace;
    }

    Ticket parking(Car car) {
        if (emptySpace > 0) {

            return new Ticket(car.getCarId());
        }
        return null;
    }

    public boolean canParking() {
        return emptySpace > 0;
    }
}
