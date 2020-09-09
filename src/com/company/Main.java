package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MyList personList = new MyList();
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("1.Ввести абонента\n" +
                    "2.Выход");
            if (scan.hasNextInt()) {
                int n = scan.nextInt();
                switch (n) {
                    case 1:
                        personList.add(inputPerson(personList));
                        break;
                    case 2:
                        sort(personList);
                        print(personList);
                        return;
                    default:
                        System.out.println("Пункт меню введен не верно");
                }
            }
        }
    }

    public static Person inputPerson(MyList personList) {
        System.out.println("Введите фамилию");
        String name = inputNSP();
        System.out.println("Введите имя");
        String surname = inputNSP();
        System.out.println("Введите отчество");
        String patronymic = inputNSP();
        System.out.println("Введите номер телефона");
        String number = inputNumber();
        return new Person(surname, name, patronymic, number);
    }

    public static String  inputNSP() {
        while (true) {
            Scanner scan = new Scanner(System.in);
            String info = scan.nextLine();
            if (info.matches("(\\s*([А-Яа-я]+)\\s*)+")){
                return info.trim();
            } else {
                System.out.println("Неккоректный ввод");
            }
        }
    }

    public static String inputNumber() {
        while (true) {
            Scanner scan = new Scanner(System.in);
            String number = scan.nextLine();
            if (number.matches("(\\s*([0-9]{7})\\s*)+")){
                return number;
            } else {
                System.out.println("Неккоректный ввод номера телефона");
            }
        }
    }

    public static MyList sort(MyList personList){
        for (int i = 0; i < personList.size(); i++) {
            Person min = personList.get(i);
            int minInd = i;
            for (int j = i; j < personList.size(); j++) {
                if (min.getSurname().compareToIgnoreCase(personList.get(j).getSurname()) > 0) {
                    minInd = j;
                } else if (min.getSurname().compareToIgnoreCase(personList.get(j).getSurname()) == 0) {
                    if (min.getName().compareToIgnoreCase(personList.get(j).getName()) > 0) {
                        minInd = j;
                    }  else if (min.getName().compareToIgnoreCase(personList.get(j).getName()) == 0) {
                        if (min.getPatronymic().compareToIgnoreCase(personList.get(j).getPatronymic()) > 0) {
                            minInd = j;
                        }
                    }
                }
            }
            Person temp = personList.get(i);
            personList.set(i, personList.get(minInd));
            personList.set(minInd, temp);
        }
        return personList;
    }

    public static void print(MyList personList) {
        for (int i = 0; i < personList.size(); i++) {
            System.out.println(personList.get(i).toString());
        }
    }

    public static void searchByPhone(MyList personList) {
        for (int i = 0; i < personList.size(); i++) {

        }
    }

}
