package models;

public class Employee {
    private String name;
    private int age;
    private double salary;
    private String jobTitle;
    public Employee(){}
    public Employee(String name,int age, double salary,String jobTitle){
        this.name=name;
        this.age=age;
        this.salary=salary;
        this.jobTitle=jobTitle;
    }
    public String[] getInfo(){
        String[] info=new String[4];
        info[0]=name;
        info[1]=Integer.toString(age);
        info[2]=Double.toString(salary);
        info[3]=jobTitle;
        return info;
    }
}
