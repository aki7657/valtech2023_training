package com.valtech.training.day3;

import java.util.Comparator;

public class Employee {
    private int seniority;
    private int experience;
    private String name;
    private int age;
    private double salary;

 

    public Employee(int seniority, int experience, String name, int age, double salary) {
        this.seniority = seniority;
        this.experience = experience;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

 

    public int getSeniority() {
        return seniority;
    }

 

    public int getExperience() {
        return experience;
    }

 

    public String getName() {
        return name;
    }

 

    public int getAge() {
        return age;
    }

 

    public double getSalary() {
        return salary;
    }



}