package pbo.f01.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

/**
 * Driver class utama
 * Nama: Nikah Suchia Panjaitan 
 * Nim: 12S24041
 */
@Entity
public class ParkingArea {

@Id 
private String name;

private int capacity;

private String allowedType;

 @OneToMany
    private List<Vehicle> vehicles = new ArrayList<>();

    public ParkingArea() {
    }

    public ParkingArea(String name, int capacity, String allowedType) {
        this.name = name;
        this.capacity = capacity;
        this.allowedType = allowedType;
    }

public String getName() {
    return name;
}

public int getCapacity() {
    return capacity;
}

public String getAllowedType() {
    return allowedType;
}

public List<Vehicles> getVehicles(){
    return vehicles;
}
}
