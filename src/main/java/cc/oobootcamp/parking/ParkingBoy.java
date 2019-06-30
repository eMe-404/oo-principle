package cc.oobootcamp.parking;

import java.util.List;

public abstract class ParkingBoy {
    private List<ParkingLot> parkingLotList;

    public ParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public abstract Ticket park(Car car);

    public List<ParkingLot> getManagedParkingLots() {
        return parkingLotList;
    }

    public abstract Car pickUp(Ticket ticket);
}
