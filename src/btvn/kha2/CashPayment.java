package btvn.kha2;

public class CashPayment extends Payment {

    public CashPayment(double amount) {
        super(amount);
    }

    @Override
    void pay() {
        System.out.println("THanh toan bang tien mat va khogn duocj hoan tra");
    }

}
