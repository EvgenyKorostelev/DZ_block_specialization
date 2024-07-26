package repository;

import entitys.Animal;
import entitys.Cat;
import entitys.Dog;
import entitys.Hamster;
import repository.db.Const;
import repository.db.DatabaseHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteAnimal {

    private final DatabaseHandler databaseHandler = new DatabaseHandler();

    public void deleteAnimalByName(Animal animal) throws SQLException, ClassNotFoundException {

        PreparedStatement prSt;

        if (animal instanceof Dog) {
            String delete = "DELETE  FROM " + Const.DOGS_TABLE +
                    " WHERE " + Const.DOG_ID + "=?";
            prSt = databaseHandler.getDbConnection().prepareStatement(delete);
            prSt.setString(1, String.valueOf(((Dog) animal).getId()));
            prSt.executeUpdate();
        } else if (animal instanceof Cat) {
            String delete = "DELETE  FROM " + Const.CATS_TABLE +
                    " WHERE " + Const.CAT_ID + "=?";
            prSt = databaseHandler.getDbConnection().prepareStatement(delete);
            prSt.setString(1, String.valueOf(((Cat) animal).getId()));
            prSt.executeUpdate();
        } else if (animal instanceof Hamster) {
            String delete = "DELETE  FROM " + Const.HAMSTERS_TABLE +
                    " WHERE " + Const.HAMSTER_ID + "=?";
            prSt = databaseHandler.getDbConnection().prepareStatement(delete);
            prSt.setString(1, String.valueOf(((Hamster) animal).getId()));
            prSt.executeUpdate();
        }
    }
}
