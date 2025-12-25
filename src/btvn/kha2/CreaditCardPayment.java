package btvn.kha2;

public class CreaditCardPayment extends Payment implements Refundable{
    @Override
    void pay() {
        System.out.println("Thanh toan bang The tin dung");
    }

    public CreaditCardPayment(double amount) {
        super(amount);
    }

    @Override
    public void refund() {
        System.out.println("Phuong thuc trar tien bang the tin dung duoc hoan tra.");
    }

}
