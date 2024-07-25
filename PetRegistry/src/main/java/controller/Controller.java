package controller;

import repository.DeleteAnimal;
import repository.FindAllAnimals;
import repository.FindAnimalByName;
import repository.SaveAnimalToDb;
import services.AddNewAnimal;
import services.AddNewCommand;
import services.GetAllAnimalCommands;

import java.sql.SQLException;
import java.util.Scanner;

public class Controller {

    private AddNewAnimal addNewAnimal;
    private SaveAnimalToDb saveAnimalToDb;
    private FindAllAnimals findAllAnimals;
    private FindAnimalByName findAnimalByName;
    private GetAllAnimalCommands getAllAnimalCommands;
    private AddNewCommand addNewCommand;
    private DeleteAnimal deleteAnimal;


    public void startApplication() {

        Scanner scanner = new Scanner(System.in);
        String name;
        System.out.println("Реестр домашних животных.");
        System.out.println("""
                    Введите команду из списка:
                1 - Добавить животное.
                2 - Получить список всех животных в реестр.
                3 - Получить список всех команд животного.
                4 - Добавить новую команду животному.
                5 - Удалить животное из реестра.
                    Ваш выбор:
                """);

        int command = Integer.MAX_VALUE;
        while (command < 1 || command > 5) {
            try {
                command = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("""
                            Нет такой команды, повторите ввод:
                        1 - Добавить животное.
                        2 - Получить список всех животных в реестр.
                        3 - Получить список всех команд животного.
                        4 - Добавить новую команду животному.
                        5 - Удалить животное из реестра.
                            Ваш выбор:
                        """);
            }
        }
        switch (command) {
            case (1)://Добавить животное
                try {
                    saveAnimalToDb.saveAnimal(addNewAnimal.add());
                    System.out.println("Животное добавлено.");
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case (2)://Получить список всех животных в реестр
                try {
                    findAllAnimals.findAll().forEach(System.out::println);
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                break;
            case (3)://Получить список всех команд животного
                System.out.println("""
                            Ведите вид животного из списка:
                        1 - Собака.
                        2 - Кошка.
                        3 - Хомяк.
                            Ваш выбор:
                        """);

                int command1 = Integer.MAX_VALUE;
                while (command1 < 1 || command1 > 3) {
                    try {
                        command1 = Integer.parseInt(scanner.nextLine());
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
                System.out.println("Введите имя животного: ");
                name = scanner.nextLine();
                switch (command1) {
                    case (1):
                        try {
                            getAllAnimalCommands.getAllCommands(findAnimalByName
                                    .findByName("Dog", name));
                        } catch (SQLException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case (2):
                        try {
                            getAllAnimalCommands.getAllCommands(findAnimalByName
                                    .findByName("Cat", name));
                        } catch (SQLException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case (3):
                        try {
                            getAllAnimalCommands.getAllCommands(findAnimalByName
                                    .findByName("Hamster", name));
                        } catch (SQLException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                }
                System.out.println("Команды добавлены.");
                break;
            case (4)://Добавить новую команду животному
                System.out.println("""
                            Ведите вид животного из списка:
                        1 - Собака.
                        2 - Кошка.
                        3 - Хомяк.
                            Ваш выбор:
                        """);

                int command2 = Integer.MAX_VALUE;
                while (command2 < 1 || command2 > 3) {
                    try {
                        command2 = Integer.parseInt(scanner.nextLine());
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
                System.out.println("Введите имя животного: ");
                name = scanner.nextLine();
                switch (command2) {
                    case (1):
                        try {
                            addNewCommand.addCommand(findAnimalByName
                                    .findByName("Dog", name));
                        } catch (SQLException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case (2):
                        try {
                            addNewCommand.addCommand(findAnimalByName
                                    .findByName("Cat", name));
                        } catch (SQLException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case (3):
                        try {
                            addNewCommand.addCommand(findAnimalByName
                                    .findByName("Hamster", name));
                        } catch (SQLException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                }
                break;
            case (5)://Удалить животное из реестра
                System.out.println("""
                            Ведите вид животного из списка:
                        1 - Собака.
                        2 - Кошка.
                        3 - Хомяк.
                            Ваш выбор:
                        """);
                int command3 = Integer.MAX_VALUE;
                while (command3 < 1 || command3 > 3) {
                    try {
                        command3 = Integer.parseInt(scanner.nextLine());
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
                System.out.println("Введите имя животного: ");
                name = scanner.nextLine();
                switch (command3) {
                    case (1):
                        try {
                            deleteAnimal.deleteAnimalByName(findAnimalByName
                                    .findByName("Dog", name));
                        } catch (SQLException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case (2):
                        try {
                            deleteAnimal.deleteAnimalByName(findAnimalByName
                                    .findByName("Cat", name));
                        } catch (SQLException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case (3):
                        try {
                            deleteAnimal.deleteAnimalByName(findAnimalByName
                                    .findByName("Hamster", name));
                        } catch (SQLException | ClassNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                }
                System.out.println("Животное удалено из реестра!");
                break;
        }
    }
}
