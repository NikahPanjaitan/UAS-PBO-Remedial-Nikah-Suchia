package pbo.f01.model;

/**
 * Entity Vehicle
 *
 * Nama : Nikah Suchia Panjaitan
 * NIM  : 12S24041
 */
public class Vehicle {

    private String plateNumber;
    private String owner;
    private String type;

    public Vehicle(String plateNumber, String owner, String type) {
        this.plateNumber = plateNumber;
        this.owner = owner;
        this.type = type;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getOwner() {
        return owner;
    }

    public String getType() {
        return type;
    }
}