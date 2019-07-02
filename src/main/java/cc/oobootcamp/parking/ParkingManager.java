package cc.oobootcamp.parking;

import java.util.Arrays;
import java.util.List;

public class ParkingManager extends ParkingBoy {
    private List<ParkingBoy> managedParkingBoys;

    public ParkingManager(List<ParkingLot> directMangedParkingLots, ParkingBoy... managedParkingBoys) {
        super(directMangedParkingLots);
        this.managedParkingBoys = Arrays.asList(managedParkingBoys);
    }

    @Override
    public Ticket park(Car car) {
        Ticket ticket = null;
        for (ParkingBoy managedParkingBoy : managedParkingBoys) {
            if (managedParkingBoy.isAvailable()) {
                ticket = managedParkingBoy.park(car);
                break;
            }
        }
        if (null == ticket) {
            ticket = parkBySelf(car);
        }
        return ticket;
    }

    private Ticket parkBySelf(Car car) {
        if (!isAvailable()) {
            throw new ParkingLotIsFullException();
        }
        ParkingLot firstAvailableParkingLot = super.getManagedParkingLots().stream()
                .filter(ParkingLot::canParking)
                .findFirst()
                .orElseThrow(ParkingLotIsFullException::new);
        return firstAvailableParkingLot.parking(car);
    }
}
