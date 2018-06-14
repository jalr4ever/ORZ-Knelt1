package com.loubth.Bean;

public class Student {
    private int id;
    private String password;
    private int clazz;
    private String name;
    private String sex;
    private int age;
    private String phoneNum;
    private String address;
    private String imagePath;
    private int chargeTeacher;

    public Student() {
    }

    public Student(int id, String password, int clazz, String name, String sex, int age, String phoneNum, String address, String imagePath, int chargeTeacher) {
        this.id = id;
        this.password = password;
        this.clazz = clazz;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phoneNum = phoneNum;
        this.address = address;
        this.imagePath = imagePath;
        this.chargeTeacher = chargeTeacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getClazz() {
        return clazz;
    }

    public void setClazz(int clazz) {
        this.clazz = clazz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getChargeTeacher() {
        return chargeTeacher;
    }

    public void setChargeTeacher(int chargeTeacher) {
        this.chargeTeacher = chargeTeacher;
    }
}
