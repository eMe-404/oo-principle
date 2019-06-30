package cc.oobootcamp.parking;

import java.util.List;
import java.util.Objects;

public class GraduateParkingBoy extends ParkingBoy {

    public GraduateParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    @Override
    public Ticket park(Car car) {
        ParkingLot firstAvailableParkingLot = super.getManagedParkingLots().stream()
                .filter(ParkingLot::canParking)
                .findFirst()
                .orElseThrow(ParkingLotIsFullException::new);
        firstAvailableParkingLot.parking(car);

        return new Ticket(car.getCarId());
    }

    @Override
    public Car pickUp(Ticket ticket) {
        return super.getManagedParkingLots()
                .stream()
                .map(parkingLot -> parkingLot.pickUp(ticket))
                .filter(Objects::nonNull)
                .findFirst()
                .orElseThrow(TicketInvalidException::new);
    }
}
