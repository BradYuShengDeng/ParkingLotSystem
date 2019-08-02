package Service;

import Module.ParkingLot;
import org.junit.Assert;
import org.junit.Test;

import static Constant.MainConstant.*;

/**
 * Author: Brad Yu-Sheng Deng
 * Version: 1.0.0
 * Description: This is the service test based on Service.MainService.
 */
public class MainServiceTest {

    private ParkingLot parkingLot = null;

    @Test
    public void testCreateParkingLot(){
        parkingLot = MainService.createParkingLot("6");

        Assert.assertEquals(6, parkingLot.getSlots().size());
    }

    @Test
    public void testParkCar() throws Exception{
        Integer slotNumber = MainService.parkCar("KA-01-HH-1234", "Black");

        Assert.assertEquals(1, slotNumber.intValue()); // The first car to park in the parking lot.
    }

    @Test
    public void testCheckStatus() throws Exception{
        StringBuilder expectedStatus = new StringBuilder("Slot No.");
        expectedStatus.append(SHORT_SPACE).append("Registration No.").append(SHORT_SPACE).append("Colour").append(NEW_LINE)
                .append(1).append(LONG_SPACE).append("KA-01-HH-1234").append(SHORT_SPACE).append("Black").append(NEW_LINE);
        String status = MainService.checkStatus();

        Assert.assertEquals(expectedStatus.toString(), status);
    }

    @Test
    public void testGetRegistrationNumbersByColor() throws Exception{
        String[] expectedRegistrationNumbers = { "KA-01-HH-1234" };
        String[] registrationNumbers = MainService.getRegistrationNumbersByColor("Black");

        Assert.assertArrayEquals(expectedRegistrationNumbers, registrationNumbers);
    }

    @Test
    public void testGetSlotNumbersByColor() throws Exception{
        Integer[] expectedSlotNumbers = { 1 };
        Integer[] slotNumbers = MainService.getSlotNumbersByColor("Black");

        Assert.assertArrayEquals(expectedSlotNumbers, slotNumbers);
    }

    @Test
    public void testGetSlotNumberByRegistrationNumber() throws Exception{
        Integer slotNumber = MainService.getSlotNumberByRegistrationNumber("KA-01-HH-1234");

        Assert.assertEquals(1, slotNumber.intValue());
    }

    @Test
    public void testLeaveCar() throws Exception{
        MainService.leaveCar("1");

        Assert.assertEquals(null, parkingLot.getSlots().get(1).getCar());
    }
}
