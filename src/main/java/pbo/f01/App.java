package pbo.f01;

import pbo.f01.model.ParkingArea;
import pbo.f01.model.Vehicle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Driver class utama
 *
 * Nama : Nikah Suchia Panjaitan
 * NIM  : 12S24041
 */
public class App {

    public static void main(String[] args) {

        Map<String, ParkingArea> areas = new HashMap<>();
        Map<String, Vehicle> vehicles = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {

            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                break;
            }

            String[] data = input.split("#");

            switch (data[0]) {

                case "area-add":

                    areas.put(
                            data[1],
                            new ParkingArea(
                                    data[1],
                                    Integer.parseInt(data[2]),
                                    data[3]
                            )
                    );
                    break;

                case "vehicle-add":

                    vehicles.put(
                            data[1],
                            new Vehicle(
                                    data[1],
                                    data[2],
                                    data[3]
                            )
                    );
                    break;

                case "park":

                    String plate = data[1];
                    String areaName = data[2];

                    Vehicle vehicle = vehicles.get(plate);
                    ParkingArea area = areas.get(areaName);

                    if (vehicle != null && area != null) {

                        if (vehicle.getType().equals(area.getAllowedType())) {

                            if (area.getVehicles().size() < area.getCapacity()) {

                                boolean alreadyParked = false;

                                for (Vehicle v : area.getVehicles()) {
                                    if (v.getPlateNumber().equals(vehicle.getPlateNumber())) {
                                        alreadyParked = true;
                                        break;
                                    }
                                }

                                if (!alreadyParked) {
                                    area.getVehicles().add(vehicle);
                                }
                            }
                        }
                    }

                    break;

                case "display-all":

                    List<ParkingArea> areaList =
                            new ArrayList<>(areas.values());

                    areaList.sort(
                            Comparator.comparing(ParkingArea::getName)
                    );

                    for (ParkingArea parkingArea : areaList) {

                        System.out.println(
                                parkingArea.getName() + " "
                                        + parkingArea.getAllowedType() + " "
                                        + parkingArea.getCapacity() + "|"
                                        + parkingArea.getVehicles().size()
                        );

                        List<Vehicle> parkedVehicles =
                                new ArrayList<>(parkingArea.getVehicles());

                        parkedVehicles.sort(
                                Comparator.comparing(
                                        Vehicle::getPlateNumber
                                )
                        );

                        for (Vehicle parkedVehicle : parkedVehicles) {

                            System.out.println(
                                    parkedVehicle.getPlateNumber() + " "
                                            + parkedVehicle.getOwner() + " "
                                            + parkedVehicle.getType()
                            );
                        }
                    }

                    break;
            }
        }

        scanner.close();
    }
}