package btvn.kha1;

public class Cirle extends Shape implements Drawable{
    private double radius;
    public Cirle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Ve hinh tron");
    }

    @Override
    public double getArea() {
        return Math.PI*radius*radius;
    }

    @Override
    public double getPerimeter() {
        return 2*Math.PI*radius;
    }


}
