package cc.oobootcamp.parking;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class SmartParkingBoy extends ParkingBoy{

    public SmartParkingBoy(List<ParkingLot> parkingLotList) {
        super(parkingLotList);
    }

    @Override
    public Ticket park(Car car) {
        return super.getManagedParkingLots()
                .stream()
                .filter(ParkingLot::canParking)
                .max(Comparator.comparingInt(ParkingLot::getEmptySpace))
                .orElseThrow(ParkingLotIsFullException::new)
                .parking(car);
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
