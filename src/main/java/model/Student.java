package model;

import java.time.LocalDate;
import java.util.Date;

public class Student {
    int id;
    String name;
    LocalDate birth;
    String address;
    String phoneNumber;
    int classRoom;

    public Student(int id, String name, LocalDate birth, String address, String phoneNumber, int classRoom) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.classRoom = classRoom;
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

    public int getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(int classRoom) {
        this.classRoom = classRoom;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", classRoom=" + classRoom +
                '}';
    }
}
