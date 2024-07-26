package services;

import entitys.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AddNewAnimal {

    private final IdFactory idFactory = new IdFactory();

    public Animal addAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добавление нового животного.");
        System.out.println("выберите вид животного");
        System.out.println("""
                    введите цифру из списка:
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
                System.out.println("Добавление нового животного.");
                System.out.println("""
                            вет такого вида, повторите ввод:
                        1 - Собака.
                        2 - Кошка.
                        3 - Хомяк.
                            Ваш выбор:
                        """);
            }
        }
        Integer kindId = command;
        System.out.println("Добавление нового животного.");
        System.out.println("введите имя животного: ");
        String name = scanner.nextLine();
        System.out.println("Добавление нового животного.");
        System.out.println("введите команды, которым обучено животное(через запятую',' без пробелов): ");
        List<String> commandsAnimal = Arrays.asList(scanner
                .nextLine()
                .split(","));
        System.out.println("Добавление нового животного.");
        System.out.println("введите дату рождения животного в формате(гггг-мм-дд): ");
        String dateBirth = scanner.nextLine();
        Animal animal = null;
        switch (command) {
            case (1):
                try {
                    animal = new Dog(idFactory.createId(), name, commandsAnimal, dateBirth, kindId);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case (2):
                try {
                    animal = new Cat(idFactory.createId(), name, commandsAnimal, dateBirth, kindId);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case (3):
                try {
                    animal = new Hamster(idFactory.createId(), name, commandsAnimal, dateBirth, kindId);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
        return animal;
    }
}
