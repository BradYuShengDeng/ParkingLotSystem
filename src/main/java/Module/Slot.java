package Module;

import Interface.ICar;
import Interface.ISlot;

public class Slot implements ISlot {

    private final Integer number;
    private ICar car;

    public Slot(Integer number){
        this.number = number;
    }

    public ICar getCar() {
        return car;
    }

    public void setCar(ICar car) {
        this.car = car;
    }

}
