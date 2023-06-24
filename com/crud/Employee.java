package com.crud;

public class Employee {
    private int empId;
    private String empName;
    private String empEmail;
    private float empSalary;

    Employee(){    }

    Employee(String empName, String empEmail, Float empSalary){
        this.empEmail = empEmail;
        this.empName = empName;
        this.empSalary = empSalary;
    }

    Employee(int empId ,String empName, String empEmail, Float empSalary){
        this.empId = empId;
        this.empEmail = empEmail;
        this.empName = empName;
        this.empSalary = empSalary;
    }

    public int getId(){
        return empId;
    }

    public String getName(){
        return empName;
    }

    public String getEmail(){
        return empEmail;
    }

    public float getSalary(){
        return empSalary;
    }
}
