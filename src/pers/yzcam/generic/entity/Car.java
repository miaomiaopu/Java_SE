package pers.yzcam.generic.entity;

/**
 * @author cat
 */
public class Car {

    private String carNumber;
    private String position;
    private String color;

    public Car() {
    }

    public Car(String carNumber, String position, String color) {
        this.carNumber = carNumber;
        this.position = position;
        this.color = color;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
