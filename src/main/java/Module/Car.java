package Module;

import Interface.ICar;

/**
 * Author: Brad Yu-Sheng Deng
 * Version: 1.0.0
 * Description: Car object
 */
public class Car implements ICar {

    private String registrationNumber;
    private Color color;

    /**
     * Description: Colors from car
     */
    public enum Color{
        Red, Orange, Yellow, Green, Blue, Purple, White, Grey, Black, Brown, Pink;

        public static boolean contains(String color){
            Color[] colors = Color.values();
            for(Color c : colors){
                if(c.name().equals(color)){
                    return true;
                }
            }
            return false;
        }
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
