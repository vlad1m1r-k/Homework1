public class TriangleMain {
    public static void main(String[] args) {
        Triangle triangle1 = new Triangle(4, 5, 6);
        Triangle triangle2 = new Triangle(7, 8, 9);

        System.out.println("Triangle1 " + triangle1.getArea());
        System.out.println("Triangle2 " + triangle2.getArea());
    }
}

class Triangle {
    private double a, b, c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getArea() {
        double p = (a + b + c) / 2;
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return s;
    }
}