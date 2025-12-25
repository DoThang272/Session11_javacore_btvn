package btvn.kha1;

public class Rectangle extends Shape implements Drawable{
    private double width;
    private double height;

    public Rectangle(String name, double width, double height) {
        super(name);
        this.width = width;
        this.height = height;
    }

    public Rectangle(String name) {
        super(name);
    }


    @Override
    public void draw() {
        System.out.println("Ve hinh chu nhat");
    }

    @Override
    public double getArea() {
        return width*height;
    }

    @Override
    public double getPerimeter() {
        return 2*(width+height);
    }
}
