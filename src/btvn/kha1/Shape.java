package btvn.kha1;

public abstract class Shape {
    private String name;

    public Shape(String name) {
        this.name = name;
    }

    public abstract double getArea();
    public abstract double getPerimeter();
    public void displayInfo(){
        System.out.printf("Day la hinh %s\n",name);
    }
}
