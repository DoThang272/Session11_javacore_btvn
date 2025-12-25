package btvn.gioi1;

public class Demo {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        employees[0] = new FullTimeEmployee(1, "Thang", 15);
        employees[1] = new PartTimeEmplyee(2, "Thuy" , 0.3, 35);
        employees[2] = new PartTimeEmplyee(3,"Hoai" , 0.3, 29);

        for (Employee e: employees){
            e.showInfo();
            if (e instanceof BonusEligible){
                System.out.println("Luong cua nhan vien lam partime la: "+(((BonusEligible)e).calculateBonus()+e.calculateSalary()));
            }else
                System.out.println("Luong cua nhan vien lam fulltime la: "+e.calculateSalary());
        }
    }
}
