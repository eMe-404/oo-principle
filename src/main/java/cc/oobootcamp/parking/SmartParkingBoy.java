package cc.oobootcamp.parking;

import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy extends ParkingBoy {

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
}
