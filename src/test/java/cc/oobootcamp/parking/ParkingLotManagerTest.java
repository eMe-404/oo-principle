package cc.oobootcamp.parking;

import cc.oobootcamp.car.Car;
import cc.oobootcamp.ticket.Ticket;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ParkingLotManagerTest {
    @Test
    void should_parking_lot_manager_call_parking_boy_to_park_car_when_park_car_given_multi_parking_lot_with_available_space_and_a_parking_boy_can_manage_all_parking_lot() {
        Car car = new Car("ABC1234");
        List<ParkingLot> parkingLotList = asList(new ParkingLot(3), new ParkingLot(5));
        ParkingBoy parkingBoy = spy(new GraduateParkingBoy(parkingLotList));
        List<ParkingBoy> parkingBoyList = singletonList(parkingBoy);
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLotList, parkingBoyList);

        Ticket ticket = parkingLotManager.park(car);

        verify(parkingBoy, times(1)).park(car);
        assertNotNull(ticket);
    }

    @Test
    void should_parking_lot_manager_park_car_when_park_car_by_self_given_multi_parking_lot_with_available_space_and_a_parking_boy_can_manage_all_parking_lot() {
        Car car = new Car("ABC1234");
        List<ParkingLot> parkingLotList = asList(new ParkingLot(3), new ParkingLot(5));
        ParkingBoy parkingBoy = spy(new SmartParkingBoy(parkingLotList));
        List<ParkingBoy> parkingBoyList = singletonList(parkingBoy);
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingLotList,parkingBoyList);

        Ticket ticket = parkingLotManager.parkBySelf(car);

        verify(parkingBoy, times(0)).park(car);
        assertNotNull(ticket);
    }
}
