package btvn.gioi1;

public abstract class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public abstract double calculateSalary();
    public void showInfo(){
        System.out.printf("\nID: %d - Tên: %s \n",id, name);
    }

}
