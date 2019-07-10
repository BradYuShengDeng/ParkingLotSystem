package Module;

import Interface.ICar;
import Enum.Color;

public class Car implements ICar {

    private Long registrationNumber;
    private Color color;

    public Long getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(Long registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
