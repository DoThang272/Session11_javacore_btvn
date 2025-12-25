package btvn.gioi2;

public class Demo {
    public static void main(String[] args) {
        Device[] devices = new Device[4];
        devices[0] = new SmartPhone(1, "Dien thoai iphone");
        devices[1]  = new Laptop(2, "Laptop macbook");
        devices[2] = new Television(3, "TV samsung");
        devices[3] = new SmartPhone(4, "Dien thoai samsung");

        for (Device d: devices){
            System.out.printf("id: %d  -  name: %s \n",d.getId(), d.getName());
            d.turnOn();

            if(d instanceof  Chargeable){
                if (d instanceof Connectable){
                    ((Connectable) d).connectWifi();
                }
                ((Chargeable) d).charge();
            }
        }
    }
}
