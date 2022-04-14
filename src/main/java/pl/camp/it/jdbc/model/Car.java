package pl.camp.it.jdbc.model;

public class Car {
    private String model;
    private String brand;
    private String color;
    private int pieces;
    private int owner_id;

    public Car() {
    }

    public Car(String model, String brand, String color, int pieces, int owner_id) {
        this.model = model;
        this.brand = brand;
        this.color = color;
        this.pieces = pieces;
        this.owner_id = owner_id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", pieces=" + pieces +
                ", owner_id=" + owner_id +
                '}';
    }
}
