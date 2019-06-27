package cc.oobootcamp.parking;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ParkingLotTest {

    @Test
    public void should_let_the_car_in_when_parking_given_empty_space() {
        ParkingLot parkingLot = new ParkingLot(1);

        boolean canParking = parkingLot.canParking();

        assertTrue(canParking);
    }

    @Test
    public void should_not_let_the_car_in_when_parking_given_space_is_full() {
        ParkingLot parkingLot = new ParkingLot(0);

        boolean canParking = parkingLot.canParking();

        assertFalse(canParking);
    }

    @Test
    public void should_give_ticket_when_parking_given_car_parked() {
        Car car = new Car("ABC12345");
        ParkingLot parkingLot = new ParkingLot(1);

        Ticket ticket = parkingLot.parking(car);

        assertNotNull(ticket);
    }

    @Test
    public void should_not_give_ticket_when_parking_given_car_in_and_has_no_space() {
        Car car = new Car("ABC12345");
        ParkingLot parkingLot = new ParkingLot(0);

        Ticket ticket = parkingLot.parking(car);

        assertNull(ticket);
    }

}
