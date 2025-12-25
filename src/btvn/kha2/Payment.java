package btvn.kha2;

public abstract class Payment {
    private double amount;
    abstract void pay();

    public Payment(double amount) {
        this.amount = amount;
    }

    public void printAmount(){
        System.out.println("Amount: "+amount);
    }
}
