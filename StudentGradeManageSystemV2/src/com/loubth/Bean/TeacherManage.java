package com.loubth.Bean;

public class TeacherManage {
    private int id;
    private String name;
    private int subjectClass;
    private int mainClass;

    public TeacherManage() {
    }

    public TeacherManage(int id, String name, int subjectClass, int mainClass) {
        this.id = id;
        this.name = name;
        this.subjectClass = subjectClass;
        this.mainClass = mainClass;
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

    public int getSubjectClass() {
        return subjectClass;
    }

    public void setSubjectClass(int subjectClass) {
        this.subjectClass = subjectClass;
    }

    public int getMainClass() {
        return mainClass;
    }

    public void setMainClass(int mainClass) {
        this.mainClass = mainClass;
    }
}
