package services;

import entitys.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AddNewAnimal {

    private final IdFactory id = new IdFactory();

    public Animal add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите вид животного");
        System.out.println("""
                    Введите цифру из списка:
                1 - Собака.
                2 - Кошка.
                3 - Хомяк.
                    Ваш выбор:
                """);
        int command = Integer.MAX_VALUE;
        while (command < 1 || command > 3) {
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("""
                            Нет такого вида, повторите ввод:
                        1 - Собака.
                        2 - Кошка.
                        3 - Хомяк.
                            Ваш выбор:
                        """);
            }
        }
        Integer kindId = command;
        System.out.println("Введите имя животного: ");
        String name = scanner.nextLine();
        System.out.println("Введите команды, которым обучено животное(через запятую',' без пробелов): ");
        List<String> commandsAnimal = Arrays.asList(scanner
                .nextLine()
                .split(","));
        System.out.println("Введите дату рождения животного в формате(гггг-мм-дд): ");
        String dateBirth = scanner.nextLine();
        Animal animal = null;
        switch (command) {
            case (1):
                try {
                    animal = new Dog(id.createId(), name, commandsAnimal, dateBirth, kindId);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case (2):
                try {
                    animal = new Cat(id.createId(), name, commandsAnimal, dateBirth, kindId);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case (3):
                try {
                    animal = new Hamster(id.createId(), name, commandsAnimal, dateBirth, kindId);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
        return animal;
    }
}
