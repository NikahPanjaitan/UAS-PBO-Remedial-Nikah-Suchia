package pbo.f01.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * Driver class utama
 * Nama: Nikah Suchia Panjaitan 
 * Nim: 12S24041
 */
@Entity
public class Vehicle {

    @Id
    private String plateNumber;

    private String owner;

    private String type;

    public Vehicle() {
    }

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