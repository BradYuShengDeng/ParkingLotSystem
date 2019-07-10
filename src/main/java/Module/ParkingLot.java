package Module;

import Interface.ISlot;
import java.util.ArrayList;

public class ParkingLot {

    private ArrayList<ISlot> slots = new ArrayList<ISlot>();

    public ParkingLot(int number){
        for(int i = 1 ; i <= number ; i++){
            slots.add(new Slot(i));
        }
    }

    public ArrayList<ISlot> getSlots() {
        return slots;
    }
}
