package ru.mirea.task12.num1;

public class Students {
    private int iDNumber;
    private String name;
    private String surname;
    private int course;

    public Students(int iDNumber, String name, String surname, int course) {
        this.iDNumber = iDNumber;
        this.name = name;
        this.surname = surname;
        this.course = course;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setIDNumber(int iDNumber) {
        this.iDNumber = iDNumber;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public int getIDNumber() {
        return iDNumber;
    }

    public String getSurname() {
        return surname;
    }

    public int getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", iDNumber=" + iDNumber +
                ", surname='" + surname + '\'' +
                ", course=" + course +
                '}';
    }
}
