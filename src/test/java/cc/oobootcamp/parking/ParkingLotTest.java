package cc.oobootcamp.parking;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ParkingLotTest {

    @Test
    public void should_indicate_there_has_empty_space_when_check_space_given_empty_space() {
        ParkingLot parkingLot = new ParkingLot(1);
        String expectedResult = "there has empty space in parking lot";

        String actualResult = parkingLot.checkSpace();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void should_indicate_parking_lot_is_full_when_check_given_no_empty_space() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car("ABC123456");
        parkingLot.park(car);
        String expectedResult = "parking lot is full, sorry";

        String actualResult = parkingLot.checkSpace();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void should_give_a_ticket_when_park_given_entered_car() {
        Car car = new Car("ABC12345");
        ParkingLot parkingLot = new ParkingLot(1);

        Ticket ticket = parkingLot.park(car);

        assertNotNull(ticket);
    }

    @Test
    public void should_let_the_car_leave_when_take_car_given_valid_ticket() {
        Car car = new Car("ABC12345");
        ParkingLot parkingLot = new ParkingLot(1);
        Ticket ticket = parkingLot.park(car);
        String expectedMessage = "farewell";

        String actualMessage = parkingLot.takeCar(ticket);

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void should_reject_to_leave_when_take_car_given_invalid_ticket() {
        Car car = new Car("ABC12345");
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(car);
        Ticket wrongTicket = new Ticket("CBA12345");
        String expectedMessage = "you got the wrong ticket!";

        String actualMessage = parkingLot.takeCar(wrongTicket);

        assertEquals(expectedMessage, actualMessage);
    }
}
