import java.util.*;

public class Exp6 {
    public static void main(String[] args) {

        int[] vectorFromB = {5, 0, 8, 12, 6, 2};
        int[] vectorFromD = {16, 12, 6, 0, 9, 10};
        int[] vectorFromE = {7, 6, 3, 9, 0, 4};

        int delayToB = 6;
        int delayToD = 3;
        int delayToE = 5;

        String[] destinations = {"A", "B", "C", "D", "E", "F"};
        int numDestinations = destinations.length;

        int[] newRoutingTable = new int[numDestinations];
        String[] nextHop = new String[numDestinations];

        System.out.println("--- Calculating New Routing Table for Router C ---");
        System.out.printf("%-12s | %-10s | %-10s\n", "Destination", "New Delay", "Next Hop");
        System.out.println("----------------------------------------------");


        for (int i = 0; i < numDestinations; i++) {
            // Calculate cost via each neighbor
            int viaB = delayToB + vectorFromB[i];
            int viaD = delayToD + vectorFromD[i];
            int viaE = delayToE + vectorFromE[i];

            int minCost = viaB;
            String hop = "B";

            if (viaD < minCost) {
                minCost = viaD;
                hop = "D";
            }
            if (viaE < minCost) {
                minCost = viaE;
                hop = "E";
            }

            if (destinations[i].equals("C")) {
                newRoutingTable[i] = 0;
                nextHop[i] = "-";
            } else {
                newRoutingTable[i] = minCost;
                nextHop[i] = hop;
            }

            System.out.printf("%-12s | %-10d | %-10s\n", destinations[i], newRoutingTable[i], nextHop[i]);
        }
    }
}

