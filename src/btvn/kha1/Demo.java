package btvn.kha1;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Shape[] arrShape = new Shape[2];
        arrShape[0] = new Cirle("Tron1" , 3);
        arrShape[1] = new Rectangle("HCN1" , 3,5);
        for (Shape shape: arrShape){
            shape.displayInfo();
            System.out.printf("Area: %.2f\n", shape.getArea());
            System.out.println("Perimeter: "+ shape.getPerimeter());

            if(shape instanceof Drawable){
                ((Drawable) shape).draw();
            }
        }


    }
}
