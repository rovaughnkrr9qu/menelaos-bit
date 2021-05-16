package HaverSine;

import java.util.Scanner;

public class Methods {
    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);

        // two test value Strings
        String cityOne = "New York";
        String cityTwo = "Los Angeles";


        System.out.print("Please enter two coordinate pairs, i.e. degrees latitude1 longitude1 latitude2 longitude2: ");
        double lat1 = input.nextDouble();
        double long1 = input.nextDouble();
        double lat2 = input.nextDouble();
        double long2 = input.nextDouble();
        // Prompt user to enter latitude1 between -90 and 90 degrees and longitude1 between -180 and 180 degrees
        // (negative for degrees south and west, positive for degrees north and east).
        double distanceBetweenCities = getDistance(lat1, long1, lat2, long2);
        System.out.println("The distance between (" + lat1 + ", " + long1 + ") and (" + lat2 + ", " + long2 +
                ") is " + distanceBetweenCities + " kilometers");
        // our scale
        System.out.println("Would you rather have this distance in miles, kilometers, meters or yards: ");
        String scale = input.next();
        double distance = convertDistance(distanceBetweenCities, scale);
        System.out.println("The distance between " + cityOne + " and " + cityTwo + " is " + distance + " " + scale);

        input.close();
    }
    public static double getDistance(double lat1, double long1, double lat2, double long2) {

        final int EARTH_RADIUS = 6371;

        // Haversine formula
        double a = Math.pow(Math.sin((lat1 - lat2) / 2), 2) +
                (Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin((long1 - long2) / 2), 2));
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = EARTH_RADIUS * c;

        return distance;
    }

    public static double convertDistance(double distanceBetweenCities, String scale) {

        double distanceBetweenCoordinates = 0.0;
        switch (scale) {
            case "Miles":
            case "miles":
                distanceBetweenCoordinates = distanceBetweenCities / 1.60934;
                return distanceBetweenCoordinates;

            case "Kilometers":
            case "kilometers":
                distanceBetweenCoordinates = distanceBetweenCities;
                return distanceBetweenCoordinates;
            case "Meters":
            case "meters":
                distanceBetweenCoordinates = distanceBetweenCities * 1000;
                return distanceBetweenCoordinates;
            case "Yards":
            case "yards":
                distanceBetweenCoordinates = distanceBetweenCities * 1093.613;
                return distanceBetweenCoordinates;
            // if they enter an invalid scale we will default into 0.0
            default:
                return distanceBetweenCoordinates;


        }


    }
}