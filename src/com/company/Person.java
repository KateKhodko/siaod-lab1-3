package com.company;

public class Person {
    private String name;
    private String surname;
    private String patronymic;
    private int number;

    public Person(String name, String surname, String patronymic, int number) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
