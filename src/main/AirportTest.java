package main;
import model.Plane;
import service.PlaneService;

import java.util.Scanner;

public class AirportTest {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        PlaneService service = new PlaneService();
        Plane p1 = service.create();
        Plane p2 = service.create();
        Plane p3 = service.create();
        Plane[] planes = {p1,p2,p3};

        boolean isMenuActive = true;
        while(isMenuActive) {
            System.out.println("\nEnter command number: ");
            System.out.println("1. prints cost and top Speed if the plane if Military, otherwise model and country,");
            System.out.println("2. returns the plane which is newer,");
            System.out.println("3. prints country of the plane with smallest seats count,");
            System.out.println("4. prints all non-military planes,");
            System.out.println("5. prints all military planes which were in air more than 100 hours.");
            System.out.println("6. returns the plane with minimal weight,");
            System.out.println("7. returns the plane with minimal cost from all military planes,");
            System.out.println("8. prints planes in ascending form order by year.");
            System.out.println("9. Exit");

            int command = keyboard.nextInt();

            switch (command) {
                case 1:
                    service.printCostTopSpeedOfMilitaryModelCountryOfOthers(p1);

                    break;
                case 2:
                    service.newerPlane(p1,p2).getInfo();
                    break;
                case 3:
                    service.printCountryOfPlaneWithSmallestSeatsCount(p1,p2,p3);
                    break;
                case 4:
                    service.printAllNonMilitaryPlanes(planes);
                    break;
                case 5:
                    service.printMilitaryPlanesInAirMoreThan100Hours(planes);
                    break;
                case 6:
                    service.minimalWeight(planes).getInfo();
                    break;
                case 7:
                    service.minimalCostFromMilitary(planes).getInfo();
                    break;
                case 8:
                    service.printPlanesInAscendingOrderByYear(planes);
                    break;
                case 9:
                    isMenuActive = false;
                    System.out.println("End.");
                    break;
                default:
                    System.out.println("Invalid command number");
            }
        }
    }


}
