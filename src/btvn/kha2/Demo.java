package btvn.kha2;

public class Demo {
    public static void main(String[] args) {
        Payment[]  payments = new Payment[4];
        payments[0] = new CashPayment(100);
        payments[1] = new CreaditCardPayment(150);
        payments[2] = new EWalletPayment(200);
        payments[3] = new CashPayment(50000);

        for (Payment p : payments){
            p.printAmount();
            p.pay();
            if (p instanceof Refundable){
                ((Refundable) p).refund();
            }
        }
    }
}
