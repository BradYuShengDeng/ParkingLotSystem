package Module;

import Interface.ICar;

public class Car implements ICar {

    private String registrationNumber;
    private Color color;

    public enum Color{
        RED, ORANGE, YELLOW, GREEN, BLUE, PURPLE, WHITE, GREY, BLACK, BROWN, PINK
    }

    public Car(String registrationNumber, Color color){
        this.registrationNumber = registrationNumber;
        this.color = color;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
