import java.util.Scanner;

abstract class Plot {
    protected String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double calculateArea();

    abstract String getShape();
}

class Circle extends Plot {
    private double radius;

    Circle(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    double calculateArea() {
        return Math.PI * radius * radius;
    }

    String getShape() {
        return "CIRCLE";
    }
}

class Rectangle extends Plot {
    private double length;
    private double width;

    Rectangle(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    double calculateArea() {
        return length * width;
    }

    String getShape() {
        return "RECTANGLE";
    }
}

class Triangle extends Plot {
    private double base;
    private double height;

    Triangle(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    double calculateArea() {
        return 0.5 * base * height;
    }

    String getShape() {
        return "TRIANGLE";
    }
}

public class GardenPlot {

    static Plot createPlot(
            String shape,
            String owner,
            double a,
            double b) {

        switch (shape) {
            case "CIRCLE":
                return new Circle(owner, a);

            case "RECTANGLE":
                return new Rectangle(owner, a, b);

            case "TRIANGLE":
                return new Triangle(owner, a, b);

            default:
                return null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalArea = 0;

        for (int i = 0; i < n; i++) {

            String shape = sc.next();
            String owner = sc.next();

            double a = sc.nextDouble();
            double b = 0;

            if (!shape.equals("CIRCLE")) {
                b = sc.nextDouble();
            }

            Plot plot =
                    createPlot(shape, owner, a, b);

            double area = plot.calculateArea();

            System.out.printf(
                    "%s (%s): %.2f%n",
                    owner,
                    plot.getShape(),
                    area
            );

            totalArea += area;
        }

        System.out.printf(
                "Total Area: %.2f%n",
                totalArea
        );

        sc.close();
    }
}