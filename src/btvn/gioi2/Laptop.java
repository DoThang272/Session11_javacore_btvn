package btvn.gioi2;

public class Laptop extends Device implements Chargeable, Connectable{
    @Override
    public void charge() {
        System.out.println("Charged the laptop!");
    }

    @Override
    public void connectWifi() {
        System.out.println("Connected Wifi in laptop!");
    }

    @Override
    public void turnOn() {
        System.out.println("Turn on Laptop!");
    }

    @Override
    public void turnOff() {
        System.out.println("Turn off the Laptop!");
    }

    public Laptop(int id, String name) {
        super(id, name);
    }
}
