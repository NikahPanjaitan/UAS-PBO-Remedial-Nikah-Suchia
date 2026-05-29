package pbo.f01;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persitence;

import pbo.f01.model.ParkingArea;
import pbo.f01.model.Vehicle;

import java.util.Collections;
import java.util.Comparator;
import java.util.Lisr;
import java.util.Scanner;

/**
 * Driver class utama
 * Nama: Nikah Suchia Panjaitan 
 * Nim: 12S24041
 */

public class App {
    public static void main(String[] args) {

        EntityManagerFctory emf =
            Persistence.createEntityManagerFactory("parkit");
        
        EntityManager em =
             emf.createEntityManager();

        Scannner scanner = new Scanner(System.in);

        while (scanner hasNextLine()) {

            String input = scanner NextLine();
            if (input.equals("")) {
                break;
            }

            String[] data = input.split("#");

            // tambah area
            if (data[0].equals("area-add")) {

                String name = data[1];
                int capacity = Integer.parseInt(data[2]);
                String allowedType = data[3];

                ParkingArea area =
                        new ParkingArea(name, capacity, allowedType);

                em.getTransaction().begin();
                em.persist(area);
                em.getTransaction().commit();
            }

            // tambah vehicle
            else if (data[0].equals("vehicle-add")) {

                String plate = data[1];
                String owner = data[2];
                String type = data[3];

                Vehicle vehicle =
                        new Vehicle(plate, owner, type);

                em.getTransaction().begin();
                em.persist(vehicle);
                em.getTransaction().commit();
            }

            // park vehicle
             else if (data[0].equals("park")) {

                String plate = data[1];
                String areaName = data[2];

                Vehicle vehicle =
                        em.find(Vehicle.class, plate);

                ParkingArea area =
                        em.find(ParkingArea.class, areaName);

                if (vehicle != null && area != null) {

                    if (vehicle.getType()
                            .equals(area.getAllowedType())) {

                        if (area.getVehicles().size()
                                < area.getCapacity()) {

                            em.getTransaction().begin();
                            
                            area.getVehicles().add(vehicle);

                            em.merge(area);

                            em.getTransaction().commit();
                        }
                    }
                }
            }

            //display all
            else if (data[0].equals ("display-all")) {

                List<ParkingArea> areas =
                        em.createQuery(
                                "SELECT a FROM ParkingArea a",
                                ParkingArea.class
                        ).getResultList();

                Collections.sort(areas,
                        Comparator.comparing(ParkingArea::getName));

                for (ParkingArea area : areas) {

                    System.out.println(
                            area.getName() + " "
                            + area.getAllowedType() + " "
                            + area.getCapacity() + "|"
                            + area.getVehicles().size()
                    );

                 List<Vehicle> vehicles =
                            area.getVehicles();

                    Collections.sort(vehicles,
                            Comparator.comparing(
                                    Vehicle::getPlateNumber));

                    for (Vehicle vehicle : vehicles) {

                        System.out.println(
                                vehicle.getPlateNumber() + " "
                                + vehicle.getOwner() + " "
                                + vehicle.getType()
                        );
                    }
                }
            }
        }

        scanner.close();
        em.close();
        emf.close();
     }




 }




       