package Service;

import Interface.ICar;
import Module.Car;
import Module.ParkingLot;
import org.junit.Assert;
import org.junit.Test;

public class MainServiceTest {

    @Test
    public void testCreateParkingLot(){
        ParkingLot parkingLot = MainService.createParkingLot("6");

        Assert.assertEquals(6, parkingLot.getSlots().size());
    }

    @Test
    public void testParkCar(){
        ICar expectedCar = new Car("KA-01-HH-1234", Car.Color.BLACK);
        ICar car = MainService.parkCar("KA-01-HH-1234", "Black");

        Assert.assertEquals(expectedCar, car);
    }

    @Test
    public void testCheckStatus(){
        String expectedStatus = "1  KA-01-HH-1234   Black";
        String status = MainService.checkStatus();

        Assert.assertEquals(expectedStatus, status);
    }

    @Test
    public void testGetRegistrationNumbersByColor(){
        String[] expectedRegistrationNumbers = { "KA-01-HH-1234" };
        String[] registrationNumbers = MainService.getRegistrationNumbersByColor("Black");

        Assert.assertArrayEquals(expectedRegistrationNumbers, registrationNumbers);
    }

    @Test
    public void testGetSlotNumbersByColor(){
        Integer[] expectedSlotNumbers = { 1 };
        Integer[] slotNumbers = MainService.getSlotNumbersByColor("Black");

        Assert.assertArrayEquals(expectedSlotNumbers, slotNumbers);
    }

    @Test
    public void testGetSlotNumberByRegistrationNumber(){
        Integer slotNumber = MainService.getSlotNumberByRegistrationNumber("KA-01-HH-1234");

        Assert.assertEquals(1, slotNumber.intValue());
    }

    @Test
    public void testLeaveCar(){
        ICar expectedCar = new Car("KA-01-HH-1234", Car.Color.BLACK);
        ICar car = MainService.leaveCar("1");

        Assert.assertEquals(expectedCar, car);
    }
}
