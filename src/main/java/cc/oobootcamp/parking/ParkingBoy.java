package cc.oobootcamp.parking;

import java.util.List;
import java.util.Objects;

public abstract class ParkingBoy {
    private List<ParkingLot> parkingLotList;

    public ParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public List<ParkingLot> getManagedParkingLots() {
        return parkingLotList;
    }

    public abstract Ticket park(Car car);

    public Car pickUp(Ticket ticket) {
        return parkingLotList
                .stream()
                .map(parkingLot -> parkingLot.pickUp(ticket))
                .filter(Objects::nonNull)
                .findFirst()
                .orElseThrow(TicketInvalidException::new);
    }
}
