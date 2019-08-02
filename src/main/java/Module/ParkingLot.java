package Module;

import java.util.ArrayList;

/**
 * Author: Brad Yu-Sheng Deng
 * Version: 1.0.0
 * Description: Parking lot object
 */
public class ParkingLot {

    private ArrayList<Slot> slots = new ArrayList<Slot>();

    public ParkingLot(int number){
        for(int i = 1 ; i <= number ; i++){
            slots.add(new Slot(i)); // Put slots by ascending order.
        }
    }

    public ArrayList<Slot> getSlots() {
        return slots;
    }
}
