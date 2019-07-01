package cc.oobootcamp.parking;

import cc.oobootcamp.car.Car;
import cc.oobootcamp.ticket.Ticket;

import java.util.List;

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
}
