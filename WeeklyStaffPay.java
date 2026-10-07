import java.util.Scanner;

abstract class Staff {
    protected String name;

    Staff(String name) {
        this.name = name;
    }

    abstract double calculatePay();
}

class FullTime extends Staff {
    private double salary;

    FullTime(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    double calculatePay() {
        return salary;
    }
}

class Hourly extends Staff {
    private double hours;
    private double rate;

    Hourly(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    double calculatePay() {

        if (hours <= 40) {
            return hours * rate;
        }

        double regularPay = 40 * rate;
        double overtimeHours = hours - 40;
        double overtimePay =
                overtimeHours * rate * 1.5;

        return regularPay + overtimePay;
    }
}

class Intern extends Staff {
    private double stipend;

    Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    double calculatePay() {
        return stipend;
    }
}

public class WeeklyStaffPay {

    static Staff createStaff(
            String type,
            String name,
            double value1,
            double value2) {

        switch (type) {

            case "FULLTIME":
                return new FullTime(
                        name,
                        value1
                );

            case "HOURLY":
                return new Hourly(
                        name,
                        value1,
                        value2
                );

            case "INTERN":
                return new Intern(
                        name,
                        value1
                );

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
            String name = sc.next();

            double value1 = sc.nextDouble();
            double value2 = 0;

            if (type.equals("HOURLY")) {
                value2 = sc.nextDouble();
            }

            Staff staff =
                    createStaff(
                            type,
                            name,
                            value1,
                            value2
                    );

            double pay =
                    staff.calculatePay();

            System.out.printf(
                    "%s: %.2f%n",
                    name,
                    pay
            );

            total += pay;
        }

        System.out.printf(
                "Total Payroll: %.2f%n",
                total
        );

        sc.close();
    }
}