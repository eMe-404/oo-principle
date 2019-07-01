package cc.oobootcamp.parking;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GraduateParkingBoyTest {
    private Car car = new Car("ABC123456");

    @Test
    public void should_park_car_to_first_parking_lot_when_park_car_given_multi_parking_lot_with_available_space() {
        List<ParkingLot> parkingLotList = asList(new ParkingLot(10),
                new ParkingLot(10),
                new ParkingLot(10));

        GraduateParkingBoy parkingBoy = new GraduateParkingBoy(parkingLotList);

        parkingBoy.park(car);

        ParkingLot firstParkingLot = parkingBoy.getManagedParkingLots().get(0);
        assertTrue(firstParkingLot.getParkedCars().contains(car));
    }

    @Test
    public void should_not_park_car_and_indicate_parking_lot_is_full_when_park_car_given_multi_parking_lot_without_available_space() {
        List<ParkingLot> parkingLotList = asList(new ParkingLot(0),
                new ParkingLot(0),
                new ParkingLot(0));

        GraduateParkingBoy parkingBoy = new GraduateParkingBoy(parkingLotList);

        assertThrows(ParkingLotIsFullException.class, () -> parkingBoy.park(car));
    }

    @Test
    public void should_park_car_into_3rd_parking_lot_when_park_car_given_5_parking_lot_and_last_three_are_available() {
        List<ParkingLot> parkingLotList = asList(new ParkingLot(0),
                new ParkingLot(0),
                new ParkingLot(10),
                new ParkingLot(10),
                new ParkingLot(10));

        GraduateParkingBoy parkingBoy = new GraduateParkingBoy(parkingLotList);

        parkingBoy.park(car);

        ParkingLot thirdParkingLot = parkingBoy.getManagedParkingLots().get(2);
        assertTrue(thirdParkingLot.getParkedCars().contains(car));
    }

    @Test
    public void should_park_car_into_1st_parking_lot_when_park_car_given_5_parking_lot_and_first_three_are_available() {
        List<ParkingLot> parkingLotList = asList(new ParkingLot(10),
                new ParkingLot(10),
                new ParkingLot(0),
                new ParkingLot(0),
                new ParkingLot(0));

        GraduateParkingBoy parkingBoy = new GraduateParkingBoy(parkingLotList);

        parkingBoy.park(car);

        ParkingLot firstParkingLot = parkingBoy.getManagedParkingLots().get(0);
        assertTrue(firstParkingLot.getParkedCars().contains(car));
    }

    @Test
    public void should_take_car_when_pick_up_car_given_ticket_with_corresponding_car() {

        List<ParkingLot> parkingLotList = asList(new ParkingLot(1),
                new ParkingLot(0));
        GraduateParkingBoy parkingBoy = new GraduateParkingBoy(parkingLotList);
        Ticket ticket = parkingBoy.park(car);

        assertNotNull(parkingBoy.pickUp(ticket));
    }

    @Test
    public void should_not_take_car_when_pick_up_car_given_ticket_without_corresponding_car() {
        List<ParkingLot> parkingLotList = asList(new ParkingLot(1),
                new ParkingLot(0));
        GraduateParkingBoy parkingBoy = new GraduateParkingBoy(parkingLotList);
        Car car = new Car("ABC1234");
        parkingBoy.park(car);
        Ticket ticket = new Ticket("DEF1234");

        assertThrows(TicketInvalidException.class, () -> parkingBoy.pickUp(ticket));
    }
}
