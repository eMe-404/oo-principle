package cc.oobootcamp.parking;

import cc.oobootcamp.car.Car;
import cc.oobootcamp.ticket.Ticket;

import java.util.List;

class ParkingLotManager {
    private final List<ParkingLot> parkingLotList;
    private final List<ParkingBoy> parkingBoyList;

    ParkingLotManager(List<ParkingLot> parkingLotList, List<ParkingBoy> parkingBoyList) {
        this.parkingLotList = parkingLotList;
        this.parkingBoyList = parkingBoyList;
    }

    Ticket park(Car car) {
        Ticket ticketByParkingBoy = parkingBoyList.stream()
                .map(parkingBoy -> parkingBoy.park(car))
                .findAny()
                .orElse(null);

        if (ticketByParkingBoy == null) {
            return parkingLotList.stream()
                    .map(parkingLot -> parkingLot.parking(car))
                    .findAny()
                    .orElseThrow(ParkingLotIsFullException::new);
        }

        return ticketByParkingBoy;
    }

    Ticket parkBySelf(Car car) {
        return parkingLotList.stream()
                .map(parkingLot -> parkingLot.parking(car))
                .findAny()
                .orElseThrow(ParkingLotIsFullException::new);
    }
}
