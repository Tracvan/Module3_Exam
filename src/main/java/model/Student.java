package model;

import java.sql.Date;
import java.time.LocalDate;

public class Student {
    int id;
    String name;
    LocalDate birth;
    String address;
    String phoneNumber;
    String className;

    public Student(int id, String name, LocalDate birth, String address, String phoneNumber, String className) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.className = className;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }


}
