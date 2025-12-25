package btvn.kha2;

public class EWalletPayment extends Payment implements Refundable{
    @Override
    void pay() {
        System.out.println("Thanh toan bang phuong thuc vi dien tu.");
    }

    @Override
    public void refund() {
        System.out.println("Phuong thuc vi dien tu duoc hoan tra hang.");
    }

    public EWalletPayment(double amount) {
        super(amount);
    }
}
