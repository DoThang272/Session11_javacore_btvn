package btvn.gioi2;

public class SmartPhone extends Device implements Connectable,Chargeable{
    public SmartPhone(int id, String name) {
        super(id, name);
    }

    @Override
    public void charge() {
        System.out.println("Charged the SM!");
    }

    @Override
    public void connectWifi() {
        System.out.println("Connected Wifi on SM!");
    }

    @Override
    public void turnOn() {
        System.out.println("Turn on smartphone!");
    }

    @Override
    public void turnOff() {
        System.out.println("Turn off the smartphone!");
    }
}
