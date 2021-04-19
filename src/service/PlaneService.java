package service;
import model.Plane;

import java.util.Scanner;

public class PlaneService {

    public Plane create() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter plane model: ");
        String model = keyboard.next();

        System.out.println("Enter the manufacturer country: ");
        String country = keyboard.next();

        System.out.println("Enter the year of manufacturing: ");
        int year = keyboard.nextInt();

        System.out.println("Enter the hours in the air: ");
        int hours = keyboard.nextInt();

        System.out.println("Enter whether the plane is military (y/n): ");
        boolean isMilitary = keyboard.next().charAt(0)=='y';

        System.out.println("Enter the weight of the plane: ");
        int weight = keyboard.nextInt();

        System.out.println("Enter the maximal speed per hour: ");
        int topSpeed = keyboard.nextInt();

        System.out.println("Enter the number of seats on the plane: ");
        int seats = keyboard.nextInt();

        System.out.println("Enter the cost of the plane: ");
        double cost = keyboard.nextDouble();

        Plane plane = new Plane(model,country,year);
        plane.setHours(hours);
        plane.setMilitary(isMilitary);
        plane.setWeight(weight);
        plane.setTopSpeed(topSpeed);
        plane.setSeats(seats);
        plane.setCost(cost);

        return plane;
    }

    //Task 1
    public void printCostTopSpeedOfMilitaryModelCountryOfOthers (Plane plane) {
        if(plane.isMilitary())
            System.out.println("Cost: " + plane.getCost() + "\nTop Speed: " + plane.getTopSpeed());
        else {
            System.out.println("Model: " + plane.getModel() + "\nCountry: " + plane.getCountry());
        }
    }

    //Task 2
    public Plane newerPlane ( Plane p1, Plane p2) {
        return p1.getYear() >= p2.getYear() ? p1 : p2;
    }

    //Task 3
    public void printCountryOfPlaneWithSmallestSeatsCount(Plane p1,Plane p2, Plane p3) {
        Plane planeWithSmallestSeatsCount = (p1.getSeats() <= p2.getSeats()) ? p1 : p2;
        planeWithSmallestSeatsCount = planeWithSmallestSeatsCount.getSeats() <= p3.getSeats() ? planeWithSmallestSeatsCount:p3;

        System.out.println(planeWithSmallestSeatsCount.getCountry());
    }

    //Task 4
    public void printAllNonMilitaryPlanes(Plane[] planes) {
        for(Plane plane:planes) {
            if(!plane.isMilitary()) {
                plane.getInfo();
            }
        }
    }

    //Task 5
    public void printMilitaryPlanesInAirMoreThan100Hours(Plane[] planes) {
        for(Plane plane: planes) {
            if(plane.isMilitary() && plane.getHours() > 100) {
                plane.getInfo();
            }
        }
    }

    //Task 6
    public Plane minimalWeight(Plane[] planes) {
        Plane min = planes[0];

        for(int i = 1; i < planes.length; i++) {
            if(planes[i].getWeight() <= min.getWeight()) {
                min = planes[i];
            }
        }
        return min;
    }

    //Task 7
    public Plane minimalCostFromMilitary (Plane[] planes) {
        Plane min = planes[0];
        for(int i = 1; i < planes.length; i++) {
            if(planes[i].isMilitary()) {
                if(!min.isMilitary()) {
                    min = planes[i];
                } else {
                    if(planes[i].getCost() < min.getCost()) {
                        min = planes[i];
                    }
                }
            }
        }
        return min;
    }

    //Task 8
    public void printPlanesInAscendingOrderByYear (Plane[] planes) {
        int l = planes.length;
        boolean check = true;

        while(check) {
            check = false;
            for(int i = 0; i < l-1; i++) {
                for(int j = 0; j < l - 1 - i; j++) {
                    if(planes[j].getYear() > planes[j+1].getYear()) {
                        Plane temp = planes[j];
                        planes[j] = planes[j+1];
                        planes[j+1] = temp;
                        check = true;
                    }
                }
            }
        }

        for(Plane plane: planes) {
            plane.getInfo();
        }
    }










}
