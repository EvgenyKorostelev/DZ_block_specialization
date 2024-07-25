package services;

import entitys.Animal;
import entitys.Cat;
import entitys.Dog;
import entitys.Hamster;

import java.util.*;

public class AddNewCommand {

    public Animal addCommand(Animal animal){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите новые команды(через запятую',' без пробелов): ");
        List<String> newCommands = Arrays.asList(scanner.nextLine().split(","));
        Set<String> newAllCommands = new HashSet<>(newCommands);
        if(animal instanceof Dog){
            newAllCommands.addAll(((Dog) animal).getCommands());
            ((Dog) animal).setCommands((List<String>) newAllCommands);
        } else if (animal instanceof Cat) {
            newAllCommands.addAll(((Cat) animal).getCommands());
            ((Cat) animal).setCommands((List<String>) newAllCommands);
        }else if (animal instanceof Hamster) {
            newAllCommands.addAll(((Hamster) animal).getCommands());
            ((Hamster) animal).setCommands((List<String>) newAllCommands);
        }
        return animal;
    }
}
