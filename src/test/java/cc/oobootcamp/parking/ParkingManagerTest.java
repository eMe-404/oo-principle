package cc.oobootcamp.parking;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ParkingManagerTest {
    private ParkingBoy graduateParkingBoy = Mockito.mock(GraduateParkingBoy.class);
    private ParkingBoy smartParkingBoy = Mockito.mock(SmartParkingBoy.class);

    @InjectMocks
    private ParkingBoy manager;

    private Car car = new Car("ABC123456");

    @Before
    public void setUp() {
        manager = Mockito.spy(new ParkingManager(Collections.singletonList(new ParkingLot(1)),
                graduateParkingBoy, smartParkingBoy));
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_choose_first_available_parking_boy_to_park_when_manager_received_parking_request_given_two_available_parking_boys() {
        when(graduateParkingBoy.isAvailable()).thenReturn(true);
        when(graduateParkingBoy.park(any())).thenReturn(new Ticket("ABC123"));
        when(smartParkingBoy.isAvailable()).thenReturn(true);
        when(smartParkingBoy.park(any())).thenReturn(new Ticket("ABC123"));

        manager.park(car);

        verify(graduateParkingBoy, times(1)).park(any());
        verify(smartParkingBoy, never()).park(any());
        assertTrue(manager.isAvailable());
    }

    @Test
    public void should_park_by_self_when_manager_received_parking_request_given_two_available_parking_boys_and_both_unavailable() {
        when(graduateParkingBoy.isAvailable()).thenReturn(false);
        when(smartParkingBoy.isAvailable()).thenReturn(false);

        manager.park(car);

        verify(graduateParkingBoy, never()).park(any());
        verify(smartParkingBoy, never()).park(any());
        assertFalse(manager.isAvailable());
    }

    @Test
    public void should_give_a_message_when_manager_received_parking_request_given_no_one_is_available() {
        when(graduateParkingBoy.isAvailable()).thenReturn(false);
        when(smartParkingBoy.isAvailable()).thenReturn(false);
        when(manager.isAvailable()).thenReturn(false);

        assertThrows(ParkingLotIsFullException.class, () -> manager.park(car));
    }
}
