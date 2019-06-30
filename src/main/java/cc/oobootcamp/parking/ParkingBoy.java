package cc.oobootcamp.parking;

import java.util.List;
import java.util.Objects;

public class ParkingBoy {
    private List<ParkingLot> parkingLotList;

    public ParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public Ticket park(Car car) {
        ParkingLot firstAvailableParkingLot = parkingLotList.stream()
                .filter(ParkingLot::canParking)
                .findFirst()
                .orElseThrow(ParkingLotIsFullException::new);
        firstAvailableParkingLot.parking(car);

        return new Ticket(car.getCarId());
    }

    public List<ParkingLot> getManagedParkingLots() {
        return parkingLotList;
    }

    public Car pickUp(Ticket ticket) {
        return parkingLotList
                .stream()
                .map(parkingLot -> parkingLot.pickUp(ticket))
                .filter(Objects::nonNull)
                .findFirst()
                .orElseThrow(TicketInvalidException::new);
    }
}
