package vhrybyniuk.reflection.api;

public class Employee {
    private long id;
    private String name;
    private int age;
    private double salary;
    private Gen gender;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Gen getGender() {
        return gender;
    }

    public void setGender(Gen gender) {
        this.gender = gender;
    }


    public Employee() {
    }

    public Employee(long id, String name, int age, double salary, Gen gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
    }




    public Employee(Employee employee) {
        id = employee.getId();
        name = employee.getName();
        age = employee.getAge();
        salary = employee.getSalary();
        gender = employee.getGender();
    }

    enum Gen{
        Mr,
        Ms
    }
}
