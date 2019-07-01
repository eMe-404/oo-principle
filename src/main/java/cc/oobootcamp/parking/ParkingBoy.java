package cc.oobootcamp.parking;

import cc.oobootcamp.car.Car;
import cc.oobootcamp.ticket.Ticket;
import cc.oobootcamp.ticket.TicketInvalidException;

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
