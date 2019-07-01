package cc.oobootcamp.parking;

import cc.oobootcamp.car.Car;
import cc.oobootcamp.ticket.Ticket;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ParkingLotTest {

    @Test
    public void should_let_the_car_in_when_parking_given_parking_car_and_has_space() {
        ParkingLot parkingLot = new ParkingLot(1);

        boolean canParking = parkingLot.canParking();

        assertTrue(canParking);
    }

    @Test
    public void should_dont_let_the_car_in_when_parking_given_parking_car_and_has_no_space() {
        ParkingLot parkingLot = new ParkingLot(0);

        boolean canParking = parkingLot.canParking();

        assertFalse(canParking);
    }

    @Test
    public void should_give_ticket_when_parking_given_car_parking_and_has_space() {
        Car car = new Car("ABC12345");
        ParkingLot parkingLot = new ParkingLot(1);

        Ticket ticket = parkingLot.parking(car);

        assertNotNull(ticket);
    }

    @Test
    public void should_dont_give_ticket_when_parking_given_car_parking_and_has_no_space() {
        Car car = new Car("ABC12345");
        ParkingLot parkingLot = new ParkingLot(0);

        Ticket ticket = parkingLot.parking(car);

        assertNull(ticket);
    }

    @Test
    public void should_let_car_out_when_car_id_in_ticket_is_valid() {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car("ABC12345");
        parkingLot.parking(car);
        Ticket ticket = new Ticket("ABC12345");

        Car pickedUpCar = parkingLot.pickUp(ticket);

        assertNotNull(pickedUpCar);
    }

    @Test
    public void should_not_let_car_out_when_car_id_in_ticket_is_invalid() {
        ParkingLot parkingLot = new ParkingLot(0);
        Ticket ticket = new Ticket("ABC67890");

        Car pickedUpCar = parkingLot.pickUp(ticket);

        assertNull(pickedUpCar);
    }
}
