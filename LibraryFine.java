import java.util.Scanner;

abstract class LibraryItem {
    protected String title;
    protected int daysLate;

    LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double calculateFine();
}

class Book extends LibraryItem {

    Book(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return daysLate * 2;
    }
}

class DVD extends LibraryItem {

    DVD(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return Math.min(daysLate * 5, 50);
    }
}

class Magazine extends LibraryItem {

    Magazine(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return daysLate;
    }
}

public class LibraryFine {

    static LibraryItem createItem(
            String type,
            String title,
            int daysLate) {

        switch (type) {

            case "BOOK":
                return new Book(title, daysLate);

            case "DVD":
                return new DVD(title, daysLate);

            case "MAGAZINE":
                return new Magazine(title, daysLate);

            default:
                return null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String title = sc.next();
            int daysLate = sc.nextInt();

            LibraryItem item =
                    createItem(
                            type,
                            title,
                            daysLate
                    );

            double fine =
                    item.calculateFine();

            System.out.printf(
                    "%s: %.2f%n",
                    title,
                    fine
            );

            total += fine;
        }

        System.out.printf(
                "Total Fines: %.2f%n",
                total
        );

        sc.close();
    }
}