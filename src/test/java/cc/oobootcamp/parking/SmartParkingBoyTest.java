package cc.oobootcamp.parking;

import cc.oobootcamp.car.Car;
import cc.oobootcamp.ticket.Ticket;
import cc.oobootcamp.ticket.TicketInvalidException;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SmartParkingBoyTest {
    private Car car = new Car("ABC1234");

    @Test
    public void should_park_car_into_parking_lot_which_has_most_available_space_when_park_given_parking_lot_with_different_available_space() {
        ParkingLot mostAvailableSpaceParkingLot = new ParkingLot(10);
        ParkingLot anotherParkingLot = new ParkingLot(5);
        SmartParkingBoy parkingBoy = new SmartParkingBoy(asList(anotherParkingLot, mostAvailableSpaceParkingLot));

        parkingBoy.park(car);

        assertTrue(mostAvailableSpaceParkingLot.contains(car));
    }

    @Test
    public void should_park_car_into_first_parking_lot_which_has_most_available_empty_space_when_park_given_multi_parking_lot_have_most_available_empty_space() {
        ParkingLot firstParkingLot = new ParkingLot(5);
        ParkingLot secondParkingLot = new ParkingLot(10);
        ParkingLot thirdParkingLot = new ParkingLot(10);
        SmartParkingBoy parkingBoy = new SmartParkingBoy(asList(firstParkingLot, secondParkingLot, thirdParkingLot));

        parkingBoy.park(car);

        assertTrue(secondParkingLot.contains(car));
    }

    @Test
    public void should_take_car_when_pick_up_car_given_ticket_with_corresponding_car() {
        List<ParkingLot> parkingLotList = asList(new ParkingLot(1), new ParkingLot(0));
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLotList);
        Ticket ticket = parkingBoy.park(car);

        Car myCar = parkingBoy.pickUp(ticket);

        assertNotNull(myCar);
    }

    @Test
    public void should_not_take_car_when_pick_up_car_given_ticket_without_corresponding_car() {
        List<ParkingLot> parkingLotList = asList(new ParkingLot(1), new ParkingLot(0));
        SmartParkingBoy parkingBoy = new SmartParkingBoy(parkingLotList);
        Car car = new Car("ABC1234");
        parkingBoy.park(car);
        Ticket ticket = new Ticket("DEF1234");

        assertThrows(TicketInvalidException.class, () -> parkingBoy.pickUp(ticket));
    }
}
