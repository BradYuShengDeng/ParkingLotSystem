package Module;

import Interface.ICar;
import Interface.ISlot;

/**
 * Author: Brad Yu-Sheng Deng
 * Version: 1.0.0
 * Description: Slot object in the parking lot
 */
public class Slot implements ISlot {

    private final Integer number;
    private ICar car;

    public Slot(Integer number){
        this.number = number;
    }

    public Integer getNumber() { return number; }

    public ICar getCar() {
        return car;
    }

    public void setCar(ICar car) {
        this.car = car;
    }

}
