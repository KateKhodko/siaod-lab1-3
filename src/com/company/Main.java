package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MyList personList = new MyList();
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("1.Добавить абонента\n" +
                    "2.Вывод списка абонентов\n"+
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
                        sort(personList);
                        print(personList);
                        break;
                    case 3:
                        if (!personList.isEmpty()) {
                            String number = inputPhoneNumber();
                            Person person = searchByPhone(number, personList);
                            if (person != null) {
                                System.out.println(person.toString());
                            } else {
                                System.out.println("Абонент с таким номером не найден");
                            }
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
        while (true) {
           number = inputPhoneNumber();
           if (searchByPhone(number, personList) == null) {
               break;
           } else {
               System.out.println("Такой номер телефона уже существует!");
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
            Person min = personList.get(i);
            int minInd = i;
            for (int j = i; j < personList.size(); j++) {
                if (min.getSurname().compareToIgnoreCase(personList.get(j).getSurname()) > 0) {
                    minInd = j;
                } else if (min.getSurname().compareToIgnoreCase(personList.get(j).getSurname()) == 0) {
                    if (min.getName().compareToIgnoreCase(personList.get(j).getName()) > 0) {
                        minInd = j;
                    } else if (min.getName().compareToIgnoreCase(personList.get(j).getName()) == 0) {
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

    public static Person searchByPhone(String number, MyList personList) {
        Person person = null;
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getNumber().equals(number)) {
                person = personList.get(i);
            }
        }
        return person;
    }

    public static void searchBySurname(MyList personList) {
        System.out.println("Введите фамилию");
        String surname = inputNSP();
        boolean flag = false;
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).getSurname().equals(surname)) {
                System.out.println(personList.get(i).toString());
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Номера для абонентов с такой фамилией не найдены");
        }
    }
}
