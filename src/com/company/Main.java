package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MyList personList = new MyList();
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("1.Добавить абонента\n" +
                    "2.Вывод списка абонентов\n" +
                    "3.Поиск абонента по номеру телефона\n" +
                    "4.Поиск номера телефона по фамилии абонента\n" +
                    "5.Выход");
            if (scan.hasNextInt()) {
                int n = scan.nextInt();
                switch (n) {
                    case 1:
                        personList.add(inputPersonInfo(personList));
                        break;
                    case 2:
                        if (!personList.isEmpty()) {
                            sort(personList);
                            print(personList);
                        } else {
                            System.out.println("Список абонентов пуст");
                        }
                        break;
                    case 3:
                        if (!personList.isEmpty()) {
                            searchByPhone(personList);
                        } else {
                            System.out.println("Список абонентов пуст");
                        }
                        break;
                    case 4:
                        if (!personList.isEmpty()) {
                            searchBySurname(personList);
                        } else {
                            System.out.println("Список абонентов пуст");
                        }
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Пункт меню введен не верно");
                }
            } else {
                System.out.println("Пункт меню введен не верно");
            }
        } while (true);
    }

    public static Person inputPersonInfo(MyList personList) {
        System.out.println("Введите фамилию");
        String name = inputNSP();
        System.out.println("Введите имя");
        String surname = inputNSP();
        System.out.println("Введите отчество");
        String patronymic = inputNSP();
        String number = "";
        boolean flag = true;
        while (flag) {
            flag = false;
            number = inputPhoneNumber();
            for (int i = 0; i < personList.size(); i++) {
                if (personList.get(i).getNumber().equals(number)) {
                    flag = true;
                    System.out.println("Такой номер телефона уже существует!");
                    break;
                }
            }
        }
        return new Person(surname, name, patronymic, number);
    }

    public static String inputNSP() {
        while (true) {
            Scanner scan = new Scanner(System.in);
            String info = scan.nextLine();
            if (info.matches("(\\s*([А-Яа-я]+)\\s*)+")) {
                return info.trim();
            } else {
                System.out.println("Неккоректный ввод");
            }
        }
    }

    public static String inputPhoneNumber() {
        System.out.println("Введите номер телефона");
        while (true) {
            Scanner scan = new Scanner(System.in);
            String number = scan.nextLine();
            if (number.matches("(\\s*([0-9]{7})\\s*)+")) {
                return number.trim();
            } else {
                System.out.println("Неккоректный ввод номера телефона");
            }
        }
    }

    public static MyList sort(MyList personList) {
        for (int i = 0; i < personList.size(); i++) {
            int minInd = i;
            for (int j = i; j < personList.size(); j++) {
                if (personList.get(minInd).getSurname().compareToIgnoreCase(personList.get(j).getSurname()) > 0) {
                    minInd = j;
                } else if (personList.get(minInd).getSurname().compareToIgnoreCase(personList.get(j).getSurname()) == 0) {
                    if (personList.get(minInd).getName().compareToIgnoreCase(personList.get(j).getName()) > 0) {
                        minInd = j;
                    } else if (personList.get(minInd).getName().compareToIgnoreCase(personList.get(j).getName()) == 0) {
                        if (personList.get(minInd).getPatronymic().compareToIgnoreCase(personList.get(j).getPatronymic()) > 0) {
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
        String number = inputPhoneNumber();
        System.out.println(number);
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getNumber().equals(number)) {
                System.out.println(personList.get(i).toString());
                return;
            }
        }
        System.out.println("Абонент с таким номером не найден");
    }

    public static void searchBySurname(MyList personList) {
        System.out.println("Введите фамилию");
        String surname = inputNSP();
        boolean flag = false;
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getSurname().equalsIgnoreCase(surname)) {
                System.out.println(personList.get(i).toString());
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Номера для абонентов с такой фамилией не найдены");
        }
    }
}
