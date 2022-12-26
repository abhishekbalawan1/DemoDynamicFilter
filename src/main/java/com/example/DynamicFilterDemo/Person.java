package com.example.DynamicFilterDemo;

import com.fasterxml.jackson.annotation.JsonFilter;
import org.springframework.stereotype.Component;

@Component
@JsonFilter("PersonFilter")
public class Person {
    String name;
    String address;
    String company;
    int age;
    String gender;

    public Person(){}

    public Person(String name, String address, String company, int age, String gender) {
        this.name = name;
        this.address = address;
        this.company = company;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCompany() {
        return company;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
