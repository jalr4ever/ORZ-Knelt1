package com.loubth.Bean;

public class StudentGrade {
    private int id;
    private String name;
    private int clazz;
    private int chinese;
    private int math;
    private int english;
    private int physics;
    private int chemistry;
    private int politics;
    private int geograry;
    private int pe;
    private int sum;
    private int ave;
    private int rank;
    private String properties;

    public StudentGrade() {
    }

    public StudentGrade(int id, String name, int clazz, int chinese, int math, int english, int physics, int chemistry, int politics, int geograry, int pe, int sum, int ave, int rank, String properties) {
        this.id = id;
        this.name = name;
        this.clazz = clazz;
        this.chinese = chinese;
        this.math = math;
        this.english = english;
        this.physics = physics;
        this.chemistry = chemistry;
        this.politics = politics;
        this.geograry = geograry;
        this.pe = pe;
        this.sum = sum;
        this.ave = ave;
        this.rank = rank;
        this.properties = properties;
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

    public int getClazz() {
        return clazz;
    }

    public void setClazz(int clazz) {
        this.clazz = clazz;
    }

    public int getChinese() {
        return chinese;
    }

    public void setChinese(int chinese) {
        this.chinese = chinese;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getPhysics() {
        return physics;
    }

    public void setPhysics(int physics) {
        this.physics = physics;
    }

    public int getChemistry() {
        return chemistry;
    }

    public void setChemistry(int chemistry) {
        this.chemistry = chemistry;
    }

    public int getPolitics() {
        return politics;
    }

    public void setPolitics(int politics) {
        this.politics = politics;
    }

    public int getGeograry() {
        return geograry;
    }

    public void setGeograry(int geograry) {
        this.geograry = geograry;
    }

    public int getPe() {
        return pe;
    }

    public void setPe(int pe) {
        this.pe = pe;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getAve() {
        return ave;
    }

    public void setAve(int ave) {
        this.ave = ave;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }
}
