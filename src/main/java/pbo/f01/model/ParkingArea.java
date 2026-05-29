package pbo.f01.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Entity ParkingArea
 *
 * Nama : Nikah Suchia Panjaitan
 * NIM  : 12S24041
 */
public class ParkingArea {

    private String name;
    private int capacity;
    private String allowedType;
    private List<Vehicle> vehicles;

    public ParkingArea(String name, int capacity, String allowedType) {
        this.name = name;
        this.capacity = capacity;
        this.allowedType = allowedType;
        this.vehicles = new ArrayList<>();
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

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}