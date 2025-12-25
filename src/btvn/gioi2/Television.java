package btvn.gioi2;

public class Television extends Device implements Connectable{
    @Override
    public void connectWifi() {
        System.out.println("Connected wifi the television");
    }

    @Override
    public void turnOn() {
        System.out.println("Turn on the television!");
    }

    @Override
    public void turnOff() {
        System.out.println("Turn off the television!");
    }

    public Television(int id, String name) {
        super(id, name);
    }
}
