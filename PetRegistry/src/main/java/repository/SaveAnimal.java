package repository;

import entitys.Animal;

import java.sql.SQLException;

public interface SaveAnimal {

    void saveAnimal(Animal animal) throws SQLException, ClassNotFoundException;

}
