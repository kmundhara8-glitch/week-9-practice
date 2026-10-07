import java.util.Scanner;

abstract class Booking {

    protected double distance;

    private static final double BOOKING_FEE = 50;

    Booking(double distance) {
        this.distance = distance;
    }

    abstract double calculateBaseFare();

    double calculateTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class Bus extends Booking {

    Bus(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return distance * 2;
    }
}

class Train extends Booking {

    Train(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return distance * 1.5;
    }
}

class Flight extends Booking {

    Flight(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return 2500 + (distance * 4);
    }
}

public class TravelBooking {

    static Booking createBooking(
            String mode,
            double distance) {

        switch (mode) {

            case "BUS":
                return new Bus(distance);

            case "TRAIN":
                return new Train(distance);

            case "FLIGHT":
                return new Flight(distance);

            default:
                return null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String mode = sc.next();
            double distance = sc.nextDouble();

            Booking booking =
                    createBooking(
                            mode,
                            distance
                    );

            double total =
                    booking.calculateTotal();

            System.out.printf(
                    "%s: %.2f%n",
                    mode,
                    total
            );
        }

        sc.close();
    }
}