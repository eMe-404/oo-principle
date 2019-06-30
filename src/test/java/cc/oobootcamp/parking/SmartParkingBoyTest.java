package cc.oobootcamp.parking;

import org.junit.Test;

import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertTrue;

public class SmartParkingBoyTest {
    @Test
    public void should_park_car_into_parking_lot_which_has_most_available_space_when_park_given_parking_lot_with_different_available_space() {
        ParkingLot mostAvailableSpaceParkingLot = new ParkingLot(10);
        ParkingLot anotherParkingLot = new ParkingLot(5);
        Car car = new Car("ABC1234");
        SmartParkingBoy parkingBoy = new SmartParkingBoy(asList(anotherParkingLot, mostAvailableSpaceParkingLot));

        parkingBoy.park(car);

        assertTrue(mostAvailableSpaceParkingLot.contains(car));
    }

    @Test
    public void should_park_car_into_first_parking_lot_which_has_most_available_empty_space_when_park_given_multi_parking_lot_have_most_available_empty_space() {
        ParkingLot firstParkingLot = new ParkingLot(5);
        ParkingLot secondParkingLot = new ParkingLot(10);
        ParkingLot thirdParkingLot = new ParkingLot(10);
        Car car = new Car("ABC1234");
        SmartParkingBoy parkingBoy = new SmartParkingBoy(asList(firstParkingLot, secondParkingLot, thirdParkingLot));

        parkingBoy.park(car);

        assertTrue(secondParkingLot.contains(car));
    }
}
