package btvn.gioi1;

import java.util.Scanner;

public class PartTimeEmplyee extends Employee implements BonusEligible{
    Scanner sc =new Scanner(System.in);
    private double salaryPerHour;
    private int hour;
    private double bonusSalary ;

    public PartTimeEmplyee(int id, String name, double salaryPerHour, int hour) {
        super(id, name);
        this.salaryPerHour = salaryPerHour;
        this.hour = hour;
    }
    @Override
    public double calculateBonus() {
        if (hour >30 ){
            return inputBonus(sc);
        }
        return 0;
    }

    @Override
    public double calculateSalary() {
        return salaryPerHour*hour;
    }
    public double inputBonus(Scanner scanner){
        System.out.print("Nhan vien nay dat tieu chuan de them tien thuong, moi nhap tien thuong: ");
        return bonusSalary= Double.parseDouble(scanner.nextLine());
    }
}
